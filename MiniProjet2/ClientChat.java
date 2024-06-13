import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.io.*;

public class ClientChat {
    public static void main(String[] args) {
        try {
            //client initialiser et se connecte 
            SocketChannel client=SocketChannel.open();
            client.configureBlocking(false);
            client.connect(new InetSocketAddress("localhost",8989));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
