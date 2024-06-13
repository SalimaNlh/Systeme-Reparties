import java.io.Serializable;

public class Produit implements Serializable {
    private String nom;
    private float prix;
    public Produit(String n , float p){
        this.nom=n;
        this.prix=p;
    }
    public String getnom(){
        return nom;
    }
    public float getprix(){
        return prix ;
    }
    public void setnom(String n){
        this.nom=n;
    }
    public void setprix(float p){
        this.prix=p;
    }
}
