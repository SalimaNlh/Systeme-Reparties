import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Serveur {
    public static void main(String[] args) {
        try{
            //ouvrir le serveur 
            ServerSocket serveur = new ServerSocket(1234);
            System.out.println("Serveur ouvert. Attente de connexions...");
            Socket client = serveur.accept();
            
            //lire les donnees du flux dentree du socket
            
            InputStream i = client.getInputStream();
            OutputStream o = client.getOutputStream();
            PrintWriter ecrire = new PrintWriter(o,true);

            //desirialiser un objet du flux d'entree du socket
            ObjectInputStream objet = new ObjectInputStream(i);

            while(true){
                Produit pr =(Produit)objet.readObject();

                //ecrire un message au client dans le flux de sortie du socket 
                String message ="Nom du produit : "+pr.getnom()+"  Prix du produit : "+pr.getprix()+" Dh";
                System.out.println(message+"\n");
                ecrire.println(message);
            }

            /*ecrire.close();
            o.close();
            i.close();
            client.close();*/


        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
    

}
