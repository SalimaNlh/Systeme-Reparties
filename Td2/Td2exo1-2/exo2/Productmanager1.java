import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class Productmanager{
    private static ArrayList<Product> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("\n1.Ajouter un produit");
            System.out.println("2.Charger liste des produits");
            System.out.println("3.Display liste des produits");
            System.out.println("4.Sauvegarder la liste des produits");
            System.out.println("choisir une option: ");
            int op = s.nextInt();
            switch(op){
                case 1: addproduct();
                break;
                case 2: loadproduct();
                break;
                case 3: displaypruduct();
                break;
                case 4: saveproduct();
                break;
                default:
                break;
            }
        }
    }

    public  static void loadproduct(){
        try {
            FileInputStream fil = new FileInputStream("product.data");
            ObjectInputStream in = new ObjectInputStream(fil);
            list = (ArrayList<Product>) in.readObject();
            System.out.println("product loaded successfully");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading "+e.getMessage());
        }
    }

    public static void addproduct(){
        Scanner s = new Scanner(System.in);
        System.out.println("entrer nom produit : ");
        String name = s.nextLine();
        System.out.println("entrer prix produit : ");
        double price = s.nextDouble();
        list.add(new Product(name,price));
        System.out.println("prouduit ajouter avec succee");
    }

    public static void displaypruduct(){
        for(Product prod : list){
            System.out.println(prod);
        }
    }

    public  static void saveproduct(){
        try {
            FileOutputStream fil = new FileOutputStream("product.data");
            ObjectOutputStream out = new ObjectOutputStream(fil);
            out.writeObject(list);
            System.out.println("product loaded successfully");
        } catch (IOException e) {
            System.out.println("Error loading "+e.getMessage());
        }
    }

}
