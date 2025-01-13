package concurrentCollections;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCache {

    private static final Map<String, String> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            final int threadNum = i;
            Thread t1 = new Thread(()->{
                String key = "Key @ "+ threadNum;
                for(int j=0;j<3;j++){
                    String value = getCachedValue(key);
                    System.out.println("Thread "+Thread.currentThread().getName() +  " : Key = "+key+" value = "+value);
                }
                
            });
            t1.start();
        }
    }

    static String getCacheValue(String key){
        String value = cache.get(key);
        
        if(value == null){
            value = compute(key);
            cache.put(key, value);
        }

        return value;
    }
}