import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChatServer {

    private ServerSocketChannel serverSocketChannel;
    private Selector selector;
    private Map<SocketChannel, String> connectedClients = new HashMap<>();

    public ChatServer(int port) throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void start() throws IOException {
        System.out.println("Serveur de chat démarré sur le port " + serverSocketChannel.socket().getLocalPort());

        while (true) {
            selector.select();

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                if (key.isAcceptable()) {
                    handleAccept(key);
                } else if (key.isReadable()) {
                    handleRead(key);
                }
            }
        }
    }

    private void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel clientSocketChannel = serverSocketChannel.accept();
        clientSocketChannel.configureBlocking(false);
        clientSocketChannel.register(selector, SelectionKey.OP_READ);

        connectedClients.put(clientSocketChannel, "Client-" + clientSocketChannel.hashCode());
        System.out.println(connectedClients.get(clientSocketChannel) + " s'est connecté.");
    }

    private void handleRead(SelectionKey key) throws IOException {
        SocketChannel clientSocketChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = clientSocketChannel.read(buffer);

        if (bytesRead == -1) {
            // La connexion a été fermée par le client
            String username = connectedClients.get(clientSocketChannel);
            System.out.println(username + " s'est déconnecté.");
            connectedClients.remove(clientSocketChannel);
            clientSocketChannel.close();
            return;
        }

        buffer.flip();
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);

        String message = new String(bytes);

        String username = connectedClients.get(clientSocketChannel);
        System.out.println(username + ": " + message);

        broadcastMessage(username + ": " + message, clientSocketChannel);
    }

    private void broadcastMessage(String message, SocketChannel senderChannel) throws IOException {
        for (SocketChannel channel : connectedClients.keySet()) {
            if (channel != senderChannel) {
                channel.write(ByteBuffer.wrap(message.getBytes()));
            }
        }
    }

    public static void main(String[] args) {
        try {
            ChatServer chatServer = new ChatServer(8080);
            chatServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
