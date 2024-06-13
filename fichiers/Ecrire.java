import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ecrire {
    public static void main(String[] args) {
        String contenu = "Bonjour, hello";
        //String nom ="C:\\Users\\admin\\Desktop\\fichiers\\haha.txt";
        File nom =new File("C:\\Users\\admin\\Desktop\\fichiers\\haha.txt");
        try {
            if(!nom.exists()){
                nom.createNewFile();
            }
        FileOutputStream test = new FileOutputStream(nom);
        byte[] donnees = contenu.getBytes();
        test.write(donnees);
        test.close();
        System.out.println("Ecriture avec succes");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
