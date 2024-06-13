public class Livre {
    String titre;
    String auteur;
    int ann_pub;
    public Livre (String titre, String auteur, int ann_pub){
        this.titre=titre;
        this.auteur=auteur;
        this.ann_pub=ann_pub;
    }
    public String gettitre(){ 
        return this.titre;
    }
    public void settitre(String t){ 
        this.titre = titre;
    }
    public String getauteur(){ 
        return this.auteur;
    }
    public void setauteur(String aut){ 
        this.auteur=aut;
    }
    public int getann(){ 
        return this.ann_pub;
    }
    public void setann(int ann){ 
        this.ann_pub=ann;
    }
    public void afficheLivre(){
        System.out.println("Livre : "+this.titre +", auteur : "+this.auteur+", Annee de pub : "+this.ann_pub);
    }








}