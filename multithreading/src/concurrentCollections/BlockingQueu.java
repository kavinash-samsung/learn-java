package concurrentCollections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueu {
    public static void processTask(Integer task, String counsumer){
        try{
            System.out.println("Task "+task+" is being executed by "+counsumer);
            Thread.sleep(5000);
            System.out.println("Task "+task+" execution complete by "+counsumer);
        }catch (InterruptedException e){

        }
    }
    public static void main(String[] args) {
        System.out.println("Blocking Queue");

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run(){
                try{
                    for(int i=0;i<20;i++){
                        System.out.println("Produced produce task "+i);
                        blockingQueue.put(i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e){
    
                }
            }
        });
        Thread consumerone = new Thread(new Runnable() {
            @Override
            public void run(){
                try{
                    while(true){
                        int task = blockingQueue.take();
                        processTask(task, "Consumer One");
                    }

                }catch(InterruptedException e){

                }
            }
        });
        Thread consumertwo = new Thread(new Runnable() {
            @Override
            public void run(){
                try{
                    while(true){
                        int task = blockingQueue.take();
                        processTask(task, "Consumer Two");
                    }

                }catch(InterruptedException e){

                }
            }
        });

        producer.start();
        consumerone.start();
        consumertwo.start();
        try{
            producer.join();
            consumerone.join();
            consumertwo.join();

        } catch (InterruptedException e){

        }
    }
}
