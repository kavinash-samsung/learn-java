class ThreadOne extends Thread{

    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Thread one is running "+i);
        }
    }
}
class ThreadTwo extends Thread{

    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Thread two is running "+i);
        }
    }
}
public class App {


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello, World!");

        Thread one = new Thread(new ThreadOne());
        Thread two = new Thread(new ThreadTwo());
        Thread three = new Thread(()-> {
            // @Override
            // public void run(){
                for(int i=0;i<10;i++){
                    System.out.println("Thread three is running "+i);
                }
            // }
        });

        one.start();
        one.join();
        two.start();
        three.start();
        two.join();
        System.out.println("Done executing the thread");
    }
}
