package callableDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableDemo {
    static class RunTaskValue implements Callable<Integer>{
        
        @Override
        public Integer call() throws Exception{
            Thread.sleep(5000);
            return 12;
        }
        
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException{
        ExecutorService executorService=Executors.newFixedThreadPool(2);
        
            Future<Integer> result = executorService.submit(new RunTaskValue()); 

            result.cancel(true);

            System.out.println(result.get(10, TimeUnit.SECONDS));
            executorService.shutdown();
    }
}
