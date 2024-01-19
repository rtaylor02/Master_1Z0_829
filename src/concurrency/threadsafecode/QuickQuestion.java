package concurrency.threadsafecode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Lesson 26.6 on Simon Roberts' OCP 1z0-829 OReilly course
 */
public class QuickQuestion {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                System.out.println(atomicInteger.get() + ", " + atomicInteger.incrementAndGet());
            }).start();
        }
    }
}
