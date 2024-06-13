import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exo3 {
    public static void main(String[] args) {
        File nom = new File("C:\\Users\\admin\\Desktop\\Td1exo3\\newfile.txt");
        try {
            if(!nom.exists()){
                nom.createNewFile();
                System.out.println("Fichier cree avec succes : "+nom.getName());
            }
            else {
                System.out.println("Fichier existe deja : "+nom.getName());
            }
            FileWriter fich =new FileWriter(nom,true);
            String chaine="\nbonjour je m'appelle salima";
            fich.write(chaine);
            System.out.println("Ecriture avec succes");
            fich.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
