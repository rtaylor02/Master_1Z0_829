package concurrency;

public class CheckResultWithSleep {
    private static int count = 0;
    private static final int TARGET = 1_000;
    public static void main(String[] args) {
        // Start a new thread
        new Thread(() -> {
            for (int i = 0; i < TARGET; i++) {
                count++;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ie) {
                    System.out.println("thread interrupted");
                }
            }
        }).start();

        while (count < TARGET) {
            System.out.println("Not reached yet");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                System.out.println("main thread interrupted");
            }
        }
        System.out.println("TARGET reached");
    }
}
