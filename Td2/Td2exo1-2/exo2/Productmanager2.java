import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.System;

public class Productsersalima implements Serializable{
    private static ArrayList<Product> plist=new ArrayList<Product>();
    //ajouter un produit a la liste
    public static void addproduct(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisir le nom du produit : ");
        String name=sc.nextLine();
        System.out.println("Saisir le prix du produit : ");
        Float price =sc.nextFloat();
        sc.close();
        Product p1 = new Product(name,price);
        plist.add(p1);        
    }
    //afficher la liste a l'utillisateur
    public static void displayproductlist(){
        for(int i=0;i<plist.size();i++){
            System.out.println(plist.get(i));
        }
    }
    //serialiser la liste
    public static void saveproductlist(){
        try {
            FileOutputStream fich = new FileOutputStream("C:\\Users\\admin\\Desktop\\Td2exo1-2\\haha.txt");
            ObjectOutputStream out = new ObjectOutputStream(fich);
            out.writeObject(plist);
            out.close();
            fich.close();
        } catch (IOException e) {
            System.out.println("Erreur de serialisation : "+e.getMessage());
        }
        
    }
    //charger la liste des objets a partir du fichier 
    public static void loadproductlist(){
        try {
            FileInputStream fich = new FileInputStream("C:\\Users\\admin\\Desktop\\Td2exo1-2\\haha.txt");
            ObjectInputStream in =new ObjectInputStream(fich);
            plist = (ArrayList<Product>) in.readObject();
            in.close();
            fich.close(); 
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur de deserialisation : "+e.getMessage());
        }
    }
    //afficher le menu 
    public static void main(String[] args) {
        System.out.println("1 : Afficher la liste des produits ;\n");
        System.out.println("2 : Ajouter un produit a la liste des produits ;\n");
        System.out.println("3 : Sauvegarder la liste des produits dans un fichier ;\n");
        System.out.println("4 : Charger la liste des produits a partir du fichier.\n");
        Scanner sc =new Scanner(System.in);
        int choix=sc.nextInt();
        sc.nextLine();
        sc.close();
        while(true){
            switch (choix) {
                case 1:
                    displayproductlist();
                    break;
                case 2: 
                    addproduct();
                    break;
                case 3 : 
                    saveproductlist();
                    break;
                case 4 : 
                    loadproductlist();
                    break ;
                default:
                    break;
            }
        }
    }
    
}
