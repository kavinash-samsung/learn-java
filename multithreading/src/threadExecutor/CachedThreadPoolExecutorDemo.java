package threadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TaskOne implements Runnable{
    private final int taskId;
    public TaskOne(int taskid){
        this.taskId = taskid;
    }

    @Override
    public void run(){
        try{
            // Thread.sleep(500);
            System.out.println("Task: "+taskId+" being executed by "+Thread.currentThread().getName());
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}

public class CachedThreadPoolExecutorDemo {
    public static void main(String[] args) {
        // String maxThread = "";
        try(ExecutorService executorService = Executors.newCachedThreadPool()){
            for(int i=1;i<=10000;i++){
                executorService.execute(new TaskOne(i));
            }
        }
        
    }
}
