import java.util.ArrayList;

public class Todolist {
    private ArrayList<String> chaines;
    public Todolist(){
        this.chaines=new ArrayList<String>();
    }
    public void ajouter (String ch) throws TacheVideException{
        if (ch.isEmpty()){
            throw new TacheVideException("la tache est vide");
        }
        this.chaines.add(ch);
    }
    public void supprimer (int indice) throws  IndiceInvalideException{
        if(indice<0 || indice>=this.chaines.size()){
            throw new IndiceInvalideException("indice non valide");
        }
        else 
            this.chaines.remove(indice);
    }
    public static void main(String[] args) {Todolist t;
            t= new Todolist();
        try {
            
            t.ajouter("travail");
            t.ajouter("ecole");
            
            
        } catch (TacheVideException e) {
            System.out.println(e.getMessage());
        }
        try {
            t.supprimer(0);
        } catch (IndiceInvalideException d) {
            System.out.println(d.getMessage());
        }
        
    }

}
