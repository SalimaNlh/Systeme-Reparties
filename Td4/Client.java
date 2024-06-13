import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;

public class Client {
    private static void sendDataToServer(SocketChannel socketChannel, String data) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(data.getBytes());
        socketChannel.write(buffer);
    }

    private static void readDataFromServer(SocketChannel socketChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = socketChannel.read(buffer);

        if (bytesRead > 0) {
            buffer.flip();
            byte[] data = new byte[buffer.remaining()];
            buffer.get(data);
            System.out.println("Received from server: " + new String(data));
        }
    }
    public static void main(String[] args) {
        try (SocketChannel socketChannel = SocketChannel.open()) {
            // Configure the client socket to be non-blocking
            socketChannel.configureBlocking(false);

            // Connect to the server
            socketChannel.connect(new InetSocketAddress("localhost", 4444));

            // Wait for the connection to be established
            while (!socketChannel.finishConnect()) {
            }
            System.out.println("Connected to the server. Type 'exit' to quit.");
            // Start reading user input and sending it to the server 
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.print("Enter message: ");
                    String userInput = scanner.nextLine();
                    if ("exit".equalsIgnoreCase(userInput)) { 
                        break; 
                    }
                    sendDataToServer(socketChannel, userInput);
                    readDataFromServer(socketChannel);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 