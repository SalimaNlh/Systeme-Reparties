import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Personne implements Serializable{
    private String nom;
    private int age;
    private String adress;
    public Personne(String nom,int age,String adress){
        this.nom=nom;
        this.age=age;
        this.adress=adress;
    }
    public String getnom(){
        return nom;
    }
    public void setnom(String nom){
        this.nom=nom;
    }
    public String getadress(){
        return adress;
    }
    public void setadress(String adress){
        this.adress=adress;
    }
    public int getage(){
        return age;
    }
    public void setage(int age){
        this.age=age;
    }
    public static void main(String[] args) {
        Personne p=new Personne("Salima", 20,"casablanca" ); 
        try {
            FileOutputStream nom = new FileOutputStream("C:\\Users\\admin\\Desktop\\Td2exo1-2\\haha.txt",true);
            ObjectOutputStream fich = new ObjectOutputStream(nom);
            fich.writeObject(p);
            fich.close();
            nom.close();
            System.out.println("object serialise avec succes ");
            FileInputStream nom2 = new FileInputStream("C:\\Users\\admin\\Desktop\\Td2exo1-2\\haha.txt");
            ObjectInputStream fich2 = new ObjectInputStream(nom2);
            Personne p2=(Personne) fich2.readObject();
            System.out.println("L'objet deserialiser : \nnom : "+p2.getnom()+"\nage : "+p.getage()+"\nAdresse : "+p.getadress());
            fich2.close();
            nom2.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("erreur de serialisation : "+e.getMessage());
        }
    }
}
