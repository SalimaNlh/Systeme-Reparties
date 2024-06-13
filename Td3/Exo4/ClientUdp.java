import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClientUdp {
    public static void main(String[] args) {
        try {
            //creer un datagrampacket pour lenvoyer 
            InetAddress ad =InetAddress.getByName("127.0.0.1");

            Scanner sc = new Scanner(System.in);
            System.out.println("Saisir le message : ");
            String message=sc.next();
            sc.close();

            byte[] data = message.getBytes();
            int port = 1235;

            //packet a envoyer  : messages en bytes, longueur du message , adresse , port 
            DatagramPacket packet = new DatagramPacket(data,data.length, ad, port);

            //creer une socket qui envoie le packet
            //le client peux ecouter sur un different port car il faut que le packet qui a le port ou le serveur ecoute 
            //le serveur e le client sont 2 differents programs , mais le datagram packet doit etre envoye dans le port ou le serveur ecoute  
            DatagramSocket client= new DatagramSocket(9898);
            client.send(packet);
            client.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        
    }
}
