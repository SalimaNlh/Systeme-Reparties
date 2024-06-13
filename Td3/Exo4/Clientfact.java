import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Clientfact {
    public static void main(String[] args) {
        try {
            //creer un datagrampacket pour lenvoyer 
            InetAddress ad =InetAddress.getByName("127.0.0.1");
            int port = 1235;

            Scanner sc = new Scanner(System.in);
            int i = 1001;
            while(true){
                
                System.out.println("Saisir un nombre : ");
                String message=sc.next();
                if(message.equals("exit")){
                    System.out.println("Fermeture du client..");
                    break;
                }

                byte[] data = message.getBytes();
                
                //packet a envoyer  : messages en bytes, longueur du message , adresse , port 
                DatagramPacket packet = new DatagramPacket(data,data.length, ad, port);

                //creer une socket qui envoie le packet
                //le client peux ecouter sur un different port car il faut que le packet qui a le port ou le serveur ecoute 
                //le serveur e le client sont 2 differents programs , mais le datagram packet doit etre envoye dans le port ou le serveur ecoute  
                DatagramSocket client= new DatagramSocket(i);
                client.send(packet);
                i++;

                //packet pour recevoir le message du serveur : tableau vide, longeur du tab  
                byte[] rec = new byte[1024];
                DatagramPacket receivedata = new DatagramPacket(rec, rec.length);
                client.receive(receivedata);

                //extraire le message 
                byte[] recmess = receivedata.getData();
                message = new String(recmess, 0, receivedata.getLength());
                System.out.println(message);
            }
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        
    }
}
