package concurrency.threadsafecode;

import java.util.concurrent.Exchanger;

/**
 * Lesson 26.7 on Simon Roberts' OCP 1z0-829 OReilly course
 *
 * This code demonstrate how to use Exchanger in creating a handshake between 2 threads.
 */
public class UsingExchanger {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Exchanger<String> exchanger1 = new Exchanger<>();
        
        new Thread(() -> {
            try {
                System.out.println("T1 received: " + exchanger.exchange("Message for T2"));
                Thread.sleep(1000);
                System.out.println("T1 got: " + exchanger1.exchange("Another message for T2"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        
        new Thread(() -> {
            try {
                System.out.println("T2 received: " + exchanger.exchange("Message for T1"));
                System.out.println("T2 got: " + exchanger1.exchange("Another message for T1"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
