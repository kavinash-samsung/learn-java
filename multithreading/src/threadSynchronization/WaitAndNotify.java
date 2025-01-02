package threadSynchronization;

public class WaitAndNotify {
    private static final Object lock1 = new Object();

    public static void one() throws InterruptedException{
        synchronized(lock1){
            System.out.println("Hello from method one...");
            lock1.wait(10000);
            System.out.println("Back again in the method one");
        }
    }

    public static void two() throws InterruptedException {
        synchronized(lock1){
            System.out.println("Hello from method two...");
            lock1.notify();
            System.out.println("Hello from method two even after notifying ....");
        }
    }
    public static void main(String[] args) {
        Thread one = new Thread(()->{
            try{
                one();
            }catch(InterruptedException e){
                
            }
        });
        Thread two = new Thread(()->{
            try{
                two();
            }catch(InterruptedException e){
    
            }
            
        });

        two.start();
        one.start();


    }
}
