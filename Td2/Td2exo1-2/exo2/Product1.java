import java.io.Serializable;
import java.io.*;

public class Productsalima implements Serializable {
    private String nom;
    private float prix;
    public Productsalima(String nom,float prix){
        this.nom=nom;
        this.prix=prix;
    }
    public String getnom(){
        return nom ;
    }
    public void setnom(String nom){
        this.nom=nom ;
    }
    public float getprix(){
        return prix ;
    }
    public void setprix(float prix){
        this.prix=prix ;
    }
    public static void main(String[] args) {
        Productsalima p= new Productsalima("salima", 34);
        System.out.println("nom du produit : "+p.getnom());
    }
    
}
