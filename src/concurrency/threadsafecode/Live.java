package concurrency.threadsafecode;

import java.util.concurrent.Semaphore;

/**
 * Lesson 26.1 on Simon Roberts' OCP 1z0-829 OReilly course
 *
 * This code is to demonstrate sharing resources between threads.
 */
public class Live {
    private static Semaphore resources = new Semaphore(14); // Try different number of resources: 9, 10, 14, 20, etc. 9==>guaranteed failed
    
    private static int obtainResources(int count) {
        if (resources.tryAcquire(count)) {
            return count;
        } else {
            return 0;
        }
    }
    
    private static void returnResources(int count) {
        resources.release(count);
    }
    
    private static void delay(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Runnable task = () -> {
            while (true) {
                if (obtainResources(4) == 4) {
                    delay(100);
                    if (obtainResources(6) == 6) {
                        System.out.println("success");
                        System.exit(0);
                        delay(200);
                        returnResources(6);
                    } else {
                        System.out.println("failed");
                    }
                }
                returnResources(4);
            }
        };
        
        new Thread(task).start();
        new Thread(task).start();
    }
}
