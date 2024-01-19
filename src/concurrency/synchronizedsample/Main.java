package concurrency.synchronizedsample;

/**
 * This code demonstrates the use of keyword synchronized in concurrency.
 */
public class Main extends Thread {
    static Object lock1 = new Object();
    static Object lock2 = new Object();
    static volatile int i1, i2, j1, j2, k1, k2;
    
    @Override
    public void run() {
        while (true) {
            workWithLocks();
            workWithoutLocks();
        }
    }
    
    private void workWithoutLocks() {
        if (i1 != i2) {
            System.out.println("i");
        }
        
        if (j1 != j2) {
            System.out.println("j");
        }
        
        if (k1 != k2) {
            System.out.println("k");
        }
    }
    
    private void workWithLocks() {
        synchronized(lock1) {
            i1++;
            i2++;
        }
        
        synchronized(lock2) {
            k1++;
            k2++;
        }
        
        //j1++;
        //j2++;
    }
    
    public static void main(String[] args) {
        new Main().start();
        new Main().start();
    }
}
