package concurrency.threadsafecode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  Lesson 26.6 on Simon Roberts' OCP 1z0-829 OReilly course
 *
 *  This code is to demonstrate that atomic types provide undivided read-modify-write operations.
 *  Only when it's using AtomicInteger that the count can reach 4_000_000 as intended.
 */
public class UseAtomicInt {
    //private static int anInt = 0;
    //private static volatile int anInt = 0;
    private static final AtomicInteger anInt = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        int WORKERS = 4;
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < WORKERS; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1_000_000; j++) {
                    anInt.incrementAndGet();
                    //anInt++;
                }
            } );
            list.add(thread);
            thread.start();
        }
        for (Thread thread : list) {
            thread.join();
        }
        //System.out.println("Total: " + anInt);
        System.out.println("Total: " + anInt.get());
    }
}