

public class Monthread extends Thread{
    public void run (){
        for(int i=1;i<6;i++){
            System.out.println(this.getName()+" : "+i);       
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Monthread t1=new Monthread();
        Monthread t2=new Monthread();
        t1.start();
        t2.start();
    }
}
