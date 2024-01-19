package concurrency.threadsafecode;

/**
 * Lesson 26.3 on Simon Roberts' OCP 1z0-829 OReilly course
 *
 * This method is to demonstrate visibility guarantee with the use of 'volatile'. It technically makes sure
 * that a 'happens-before' relationship is established when 'stop' is being read in the thread.
 * When used with 'volatile', it guarantees that the writing of 'stop' is visible to the thread.
 * Hence, the thread will print 'Worker stopped' and JVM will terminate.
 * When without 'volatile', JVM will still run because the thread has not finished the task.
 */
public class Stopper {
    private static volatile boolean stop = false; // toggle 'volatile' to see effects of the result
    
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!stop) {}
            System.out.println("Worker stopped");
        }).start();
        System.out.println("Worker started");
        Thread.sleep(1000);
        stop = true;
        System.out.println("Signal set, main exiting");
    }
}
