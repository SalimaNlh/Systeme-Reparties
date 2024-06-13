import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exo4 {
    public static void main(String[] args) {
        File nom = new File("C:\\Users\\admin\\Desktop\\Td1exo3\\newfile.txt");
        File nom2 = new File("C:\\Users\\admin\\Desktop\\Td1exo3\\dest.txt");
        try {
            FileInputStream test1 = new FileInputStream(nom);
            FileOutputStream test2 = new FileOutputStream(nom2);
            byte[] donnees = new byte[1024];
            int octet;
            while((octet=test1.read(donnees))!=-1){
                test2.write(donnees, 0, octet);
            }
            System.out.println("Ecriture avec succes");
            test1.close();
            test2.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
