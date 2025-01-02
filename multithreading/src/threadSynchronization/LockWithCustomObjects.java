package threadSynchronization;

public class LockWithCustomObjects {
    private static int counter1 = 0;
    private static int counter2 = 0;
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    private static void increment1(){
        counter1++;
    }
    private static void increment2(){
        counter2++;
    }
    public static void main(String[] args){
        Thread one  = new Thread(()->{
            for(int i=0;i<100000;i++){
                synchronized(lock1){
                    increment1();
                }
            }
        });
        Thread two  = new Thread(()->{
            for(int i=0;i<100000;i++){
                synchronized(lock2){
                    increment2();
                }
            }

        });
        
        one.start();
        two.start();
        try{
            one.join();
            two.join();
        }catch (InterruptedException e){
            System.out.println("Thread interrupted");
        }
        System.out.println(counter1);
        System.out.println(counter2);
    }
}
