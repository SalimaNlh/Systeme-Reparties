import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Serveur2 {
    public static void main(String[] args) {
        try{
            //ouvrir le serveur 
            ServerSocket serveur = new ServerSocket(1234);
            System.out.println("Serveur ouvert. Attente de connexions...");
            
            //lire les donnees du flux dentree du socket
            while(true){
                Socket client = serveur.accept();
                Handler clienthandler = new Handler(client);
                clienthandler.start();
            }
            

            /*ecrire.close();
            o.close();
            i.close();
            client.close();*/


        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    

}
