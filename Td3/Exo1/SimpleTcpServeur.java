

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    

    public static long factorielle(int n) {
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
            ServerSocket server = new ServerSocket(1234);
            System.out.println("le Serveur de chat es pret. Attente de connexion...");
            Socket client = server.accept();
            InputStream i = client.getInputStream();
            InputStreamReader lecture = new InputStreamReader(i);
            BufferedReader read = new BufferedReader(lecture);
            PrintWriter ecrire=new PrintWriter(client.getOutputStream(),true);
            String message;
            while(true){
                String data = "Saisissez un nombre : ";
                ecrire.println(data);
                
                message=read.readLine();
                int val=Integer.parseInt(message);
                long f = factorielle(val);
                data = "factorielle de "+message+" est :"+f;
                ecrire.println(data);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        

    }
}
