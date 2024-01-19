package concurrency;

public class CheckResultWithSleepAndInterrupt {
    private static int count = 0;
    private static final int TARGET = 1_000;
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();

        // Start a new thread
        new Thread(() -> {
            boolean interrupted = false;
            for (int i = 0; i < TARGET; i++) {
                count++;
                try {
                    Thread.sleep(1);
                    if (!interrupted && count > 300) {
                        mainThread.interrupt();
                        interrupted = true;
                    }
                } catch (InterruptedException ie) {
                    System.out.println("thread interrupted");
                }
            }
        }).start();

        while (count < TARGET) {
            System.out.println("Not reached yet");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println("main thread interrupted");
            }
        }
        System.out.println("TARGET reached");
    }
}
