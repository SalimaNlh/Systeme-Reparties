import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;
public class FileChannelExample {
    public static void main(String[] args) {
        try (
            FileChannel sourceChannel = new FileInputStream("C:\\Users\\admin\\Desktop\\gr.txt").getChannel();
            FileChannel destChannel = new FileOutputStream("C:\\Users\\admin\\Desktop\\destinationCh.txt").getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (sourceChannel.read(buffer) != -1) {
                buffer.flip(); 
                //destChannel.write(buffer);
                byte[] data = new byte[buffer.remaining()];
                buffer.get(data);
                System.out.println(new String(data));
                buffer.clear(); 
            }
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

