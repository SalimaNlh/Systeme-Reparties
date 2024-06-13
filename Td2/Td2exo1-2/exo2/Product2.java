
import java.io.*;

public class Product implements Serializable {
    private String nom;
    private double prix;
    public Product(String nom,double prix){
        this.nom=nom;
        this.prix=prix;
    }
    public String toString(){
        return this.nom+" "+this.prix;
    }
}
