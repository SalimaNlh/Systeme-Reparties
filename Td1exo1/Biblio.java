import java.util.ArrayList;
class Biblio{   
    ArrayList<Livre> livres;
    public Biblio (){
         this.livres=new ArrayList<Livre>();
    }
        
    public void ajouter(Livre A) throws BibliothequePleineException{
        if(livres.size()==100){
            throw new BibliothequePleineException("la taille limite c'est 100");
        }
        livres.add(A);
    }
    public void supprimer(String t){
        for (int i=0;i<livres.size();i++){
            if(t.equals(this.livres.get(i).gettitre())){
                livres.remove(this.livres.remove(i));
                System.out.println("Livre supprimer avec succes"); 
            }  
        }
    }
    public void affiche (){
        for(int i=0;i<livres.size();i++){
            livres.get(i).afficheLivre();
        }
    }


    
    public static void main(String[] args){
        try {
            Biblio sekkat= new Biblio();
            Livre L1 =new Livre("A","B",1990);
            Livre L2 =new Livre("C","D",1993);
            Livre L3 =new Livre("E","F",1995);
            sekkat.ajouter(L1);
            sekkat.ajouter(L2);
            sekkat.ajouter(L3);
            sekkat.affiche();
            sekkat.supprimer("O");
            sekkat.affiche();
        } catch (BibliothequePleineException e) {
            System.out.println("Exception : "+e.getMessage());
        }
        
    }
}
