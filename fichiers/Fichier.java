import java.io.File;
import java.io.IOException;

public class Fichier {
    public static void main(String[] args) {
        File test1 = new File("test1.txt");
        File test2 = new File("C:\\Users\\admin\\Desktop\\test2.txt");
        try{
            if(test1.createNewFile()){
                System.out.println("fichier creer avec succes : "+test1.getAbsolutePath());
            }
            else {
                System.out.println("erreur de creation ");
            }
            if(test2.createNewFile()){
                System.out.println("fichier creer avec succes: "+test2.getName());
            }
            else {
                System.out.println("erreur de creation ");
            }
            if(test1.delete()){
                System.out.println("fichier supprime avec succes: "+test1.getName());
            }
            else {
                System.out.println("erreur de suppression");
            }
        }catch(IOException e){
            System.out.println("erreur de creation de fichier : "+e.getMessage());
        }
        
    }
    
}
