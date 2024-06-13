import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            //creer une socket client et recuperer le flux d'entree pour lire les messages du serveur
            Socket client = new Socket("localhost", 1234);
            InputStream i = client.getInputStream();
            InputStreamReader i2 = new InputStreamReader(i);
            BufferedReader lire = new BufferedReader(i2);

            //creer dans flux de sortie (du socket)des objets : serialiser 
            OutputStream o = client.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(o);

            //Creation dun produit 
            Scanner sc = new Scanner(System.in);

            while(true){
                System.out.println("\nSaisir le nom du produit : ");
                String nom = sc.next();
                if(nom.equals("exit")){
                    System.out.println("Fermeture du client...");
                    break;
                }
                System.out.println("Saisir le prix du produit : ");
                float prix = sc.nextFloat();
                Produit produit =new Produit(nom, prix);
                
                //serialiser un objet (ecrire un objet sur un flux de sortie : socket )
                
                out.writeObject(produit);
                
                //lire la response du serveur 
                String message = lire.readLine();
                System.out.println(message);
            }

            /*o.close();
            i.close();
            out.close();
            client.close();*/

        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
