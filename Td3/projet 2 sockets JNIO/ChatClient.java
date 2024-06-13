import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ChatClient {

    private SocketChannel socketChannel;
    private String username;

    public ChatClient(String host, int port) throws IOException {
        socketChannel = SocketChannel.open(new InetSocketAddress(host, port));
        socketChannel.configureBlocking(false);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre nom d'utilisateur : ");
        username = scanner.nextLine();
        sendMessage(username + " s'est connecté.");

        new Thread(() -> {
            while (true) {
                try {
                    receiveMessage();
                    Thread.sleep(100); // Attente pour éviter la surcharge du CPU
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        while (true) {
            String message = scanner.nextLine();
            sendMessage(username + ": " + message);
        }
    }

    private void sendMessage(String message) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
        socketChannel.write(buffer);
    }

    private void receiveMessage() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = socketChannel.read(buffer);

        if (bytesRead > 0) {
            buffer.flip();
            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
            System.out.println(new String(bytes));
        }
    }

    public static void main(String[] args) {
        try {
            ChatClient chatClient = new ChatClient("localhost", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
