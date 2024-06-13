import java.net.*;

public class Serveurfact {
    public static long factorielle(long n) {
        if (n == 0 || n == 1) {
            return 1; 
        }
    
        long resultat = 1;
    
        for (int i = 2; i <= n; i++) {
            resultat *= i;
        }
    
        return resultat;
    }
    public static void main(String[] args) {
        try {
            //le serveur ecoutesur le port 1235
            DatagramSocket serveur = new DatagramSocket(1235);
            System.out.println("Serveur connecte. Attente de connexion...");

            //packet pour recevoir le message du serveur : tableau vide, longeur du tab  
            byte[] data2 = new byte[1024];
            DatagramPacket receivep = new DatagramPacket(data2, data2.length);
            int port = 1001;
            while(true){
                
                serveur.receive(receivep);

                //extraire le message 
                byte[] extract = receivep.getData();
                String message = new String(extract,0,receivep.getLength());
                long f =Long.parseLong(message);
                message ="Factorielle de "+f+" est : ";
                f=factorielle(f);
                message = message+f;

                //
                byte[] send =message.getBytes();
                InetAddress ad =InetAddress.getByName("127.0.0.1");
                

                DatagramPacket envoyep= new DatagramPacket(send, send.length, ad , port);
                port++;
                serveur.send(envoyep);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
