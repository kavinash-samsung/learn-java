package concurrentCollections;

import java.util.concurrent.CountDownLatch;

class Chef implements Runnable{
    private final String name;
    private final String dish;
    private final CountDownLatch latch; 
    Chef(String name, String dish, CountDownLatch latch){
        this.name = name;
        this.dish = dish;
        this.latch = latch;
    }
    @Override
    public void run(){
        System.out.println(String.format("Chef %s started preparing dish %s",name, dish));
        try{
            Thread.sleep(3000);

        } catch (InterruptedException e){

        }
        System.out.println(String.format("Chef %s completed the prepration of %s",name, dish));
        latch.countDown();
    }
}

public class Restaurant {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Restaurant class client");
        CountDownLatch latch = new CountDownLatch(3);
        
        Thread pasta = new Thread(new Chef("Chef 1", "Pasta", latch));
        Thread pizza = new Thread(new Chef("Chef 1", "Pizza", latch));
        Thread noodles = new Thread(new Chef("Chef 1", "Noodles", latch));

        pizza.start();
        pasta.start();
        noodles.start();

        latch.await();

        System.out.println("Hey your order is ready to served");

    }
}
