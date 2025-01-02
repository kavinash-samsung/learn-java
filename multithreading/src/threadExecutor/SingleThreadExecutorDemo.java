package threadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{
    private final int taskid;
    public Task(int taskid){
        this.taskid = taskid;
    }
    @Override
    public void run(){
        System.out.println("Task with ID "+ taskid + " being executed by Thread "+ Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
public class SingleThreadExecutorDemo {

    public static void main(String[] args) {
        try(ExecutorService service = Executors.newSingleThreadExecutor()){
            for(int i=0;i<5;i++){
                service.execute(new Task(i));
            }
        }

    }
}