package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Rodney Taylor (u228616)
 */
public class SheepManager {
    private int sheepCount = 0;
    
    private void incrementAndReport() {
        //System.out.print((++sheepCount) + " ");
        System.out.print((sheepCount++) + " ");
        //sheepCount = sheepCount + 1;
        //System.out.print(sheepCount + " ");
    }
    
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        
        try {
        
        } finally {
        
        }
        
        //usingThreadPool(20);
    }
    
    private static void usingThreadPool(int numberOfThreads) {
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        
        try {
            SheepManager sheepManager = new SheepManager();
            
            for (int i = 0; i < 10; i++) {
                service.submit(() -> sheepManager.incrementAndReport());
            }
        } finally {
            service.shutdown();
        }
    }
}
