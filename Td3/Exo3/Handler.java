import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Handler extends Thread{
    private Socket client ;
    public Handler(Socket c){
        this.client=c;
    }
    public void run (){
        try {
             InputStream i = client.getInputStream();
            OutputStream o = client.getOutputStream();
            PrintWriter ecrire = new PrintWriter(o,true);

            //desirialiser un objet du flux d'entree du socket
            ObjectInputStream objet = new ObjectInputStream(i);

            while(true){
                Produit pr =(Produit)objet.readObject();

                //ecrire un message au client dans le flux de sortie du socket 
                String message ="Nom du produit : "+pr.getnom()+"  Prix du produit : "+pr.getprix()+" Dh";
                ecrire.println(message);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
       
    }
}
