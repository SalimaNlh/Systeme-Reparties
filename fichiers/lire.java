import java.io.FileInputStream;
import java.io.IOException;

public class lire {
    public static void main(String[] args) {
        String nom ="C:\\Users\\admin\\Desktop\\fichiers\\haha.txt";
        
        try {
            FileInputStream test = new FileInputStream(nom);
            int octet;
            byte[] tampon = new byte[1024];
            while((octet=test.read(tampon))!= -1){
                String texte = new String(tampon,0,octet);
                System.out.println(texte);
            }
            test.close();
            System.out.println("\nLecture du fichier avec succes");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
