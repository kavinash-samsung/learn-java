public class DaemonThreadDemo {
    static class DaemonHelper implements Runnable{
        @Override
        public void run(){
            int count = 0;
            while(count<500){
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
                count++;
                System.out.println("Daemon helper thread running.....");
            }
        }
    }
    static class UserThreadHelper implements Runnable{
        @Override
        public void run(){
            int count = 0;
            // while(count < 500){
                try{
                    Thread.sleep(5000);
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            // }
            System.out.println("User helper thread running......");
        }
    }
    public static void main(String[] args) {
        Thread daemon = new Thread(new DaemonHelper());
        Thread user = new Thread(new UserThreadHelper());
        daemon.setDaemon(true);
        daemon.start();
        user.start();
    }
}
