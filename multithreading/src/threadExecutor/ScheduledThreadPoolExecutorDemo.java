package threadExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ProbeTask implements Runnable{
    @Override
    public void run(){
        System.out.println("Probing end point for updates....");
    }
}
public class ScheduledThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new ProbeTask(), 1000, 2000, TimeUnit.MILLISECONDS);
        try{
            if(!scheduledExecutorService.awaitTermination(1000, TimeUnit.MILLISECONDS)){
                scheduledExecutorService.shutdown();
            }
        }catch(InterruptedException e){

        }
    }
}
