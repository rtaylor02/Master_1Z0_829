package concurrency;

/**
 * @author Rodney Taylor (u228616)
 */
public class Counter {
    private int counter = 0;
    
    public int increment() {
    //public synchronized int increment() {
        return counter = counter + 1;
    }
    
    public int getCounter() {
        return counter;
    }
    
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        final int REPEAT = 10_000_000;
        
        Runnable runnable = () -> {
            for (int i = 0; i < REPEAT; i++) {
                counter1.increment();
            }
        };
        
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        int anomaly = (2 * REPEAT) - counter1.getCounter();
        double percentage = ((double)anomaly * 100) / (2 * REPEAT);
        System.out.println("Lost updates: " + anomaly + "; % = " + percentage);
        
    }
}
