import java.io.*;
import java.util.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;

public class ServerChat {
    public static void main(String[] args) {
        try {
            //creer un selecteur
            Selector selector=Selector.open();

            //creer un serveur 
            ServerSocketChannel server = ServerSocketChannel.open();
            server.bind(new InetSocketAddress(9898));
            server.configureBlocking(false);

            server.register(selector, SelectionKey.OP_ACCEPT);
            while(true){
                selector.select();
                Set<SelectionKey> SelectedKeys= selector.selectedKeys();
                Iterator<SelectionKey> keyIterator=SelectedKeys.iterator();
                while(keyIterator.hasNext()){
                    SelectionKey Key=keyIterator.next();
                    if(Key.isAcceptable()){

                    }
                    if(Key.isReadable()){
                        
                    }
                }
                
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
}
