package concurrency;

/**
 * @author Rodney Taylor (u228616)
 */
public class DaemonThreads {
    public static void main(String[] args) {
        System.out.println("Streams thread starts!");
        
        var job = new Thread(() -> pause());
        job.setDaemon(true);
        job.start();
        
        System.out.println("Streams thread finishes!");
    }
    
    private static void pause() {
        try {
            System.out.println("job thread starts!");
            Thread.sleep(3_000); // job thread is asleep for 3 sec
        } catch (InterruptedException e) {
        }
        
        System.out.println("job thread finishes!");
    }
}
