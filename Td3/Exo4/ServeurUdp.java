import java.net.*;

public class ServeurUdp {
    public static void main(String[] args) {
        try {
            //le serveur ecoutesur le port 1235
            DatagramSocket serveur = new DatagramSocket(1235);
            System.out.println("Serveur connecte. Attente de connexion...");
            byte[] data2 = new byte[1024];

            //creer un packet receive pour recevoir le packet envoye
            DatagramPacket receivep = new DatagramPacket(data2, data2.length);
            serveur.receive(receivep);

            //extraire les donnees
            byte[] extract = receivep.getData();
            String message = new String(extract,0,receivep.getLength());
            System.out.println("message reçu : "+message);
            serveur.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
