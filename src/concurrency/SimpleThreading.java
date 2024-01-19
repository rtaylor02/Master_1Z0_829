package concurrency;

/**
 * @author Rodney Taylor (u228616)
 */
public class SimpleThreading {
    public static void main(String[] args) {
        System.out.println("Streams thread begins");
        
        // Creating a thread by passing lambda expression of an anonymous Runnable object
        new Thread(() -> System.out.println("Thread A starts!")).start();
        
        // Creating a thread by passing a Runnable object
        Runnable runnable = () -> System.out.println("Thread B starts!");
        new Thread(runnable).start();
        
        // Creating a thread via an instance of a class extending Thread
        // and override its run() method
        ThreadChild threadChild = new ThreadChild();
        threadChild.start();

        // Creating a thread via an instanca of an anonymous class extending Thread
        // and overridden run() method
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Anonymous thread is started!");
            }
        };
        thread.start();
        
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }
        System.out.println("Streams thread ends");
    }
    
    private static class ThreadChild extends Thread {
        @Override
        public void run() {
            System.out.println("ThreadChild thread starts!");
        }
    }
}
