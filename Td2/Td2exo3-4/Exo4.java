public class Exo4 {
    public static class Sharedcounter {
        private int i=0;
        public synchronized void increment(){
            this.i++;
            System.out.println("compteur i : "+i);
        }
    }
    public static class Producer implements Runnable{
        private Sharedcounter sc ;
        public Producer(Sharedcounter s){
            this.sc=s;
        }
        public void run(){
            for (int i=0;i<3;i++){
                sc.increment();
                System.out.println("compteur du thread : "+Thread.currentThread().getName()+" i = "+sc.i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static class Consommateur implements  Runnable {
        private Sharedcounter sc;
        public Consommateur(Sharedcounter s){
            this.sc=s;
        }
        public void run(){
            for (int i=0;i<3;i++){
                sc.increment();
                System.out.println("compteur du thread : "+Thread.currentThread().getName()+" i = "+sc.i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        Sharedcounter count = new Sharedcounter();
        Thread t1 = new Thread(new Producer(count));
        Thread t2 = new Thread(new Consommateur(count));
        t1.start();
        t2.start();

    }
}