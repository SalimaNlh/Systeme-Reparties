

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 1234);
            InputStreamReader i= new InputStreamReader(client.getInputStream());
            BufferedReader lire= new BufferedReader(i);
            InputStreamReader in= new InputStreamReader(System.in);
            BufferedReader console = new BufferedReader(in);
            PrintWriter ecrire = new PrintWriter(client.getOutputStream(),true);
            String data ;
            while (true) {
                data = lire.readLine();
                System.out.println(data);

                data = console.readLine();
                if (data.equals("exit")) {
                    System.out.println("Fermeture du client...");
                    break;
                }
                ecrire.println(data);
                String response2=lire.readLine() ;
                System.out.println(response2);    
            }
            ecrire.close();
            console.close();
            lire.close();
            client.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
