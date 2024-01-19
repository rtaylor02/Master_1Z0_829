package concurrency.threadsafecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Lesson 26.3 on Simon Roberts' OCP 1z0-829 OReilly course
 *
 * This code is to demonstrate the use of java.util.concurrent data structure in making an ArrayList thread safe.
 */
public class StopperOnList {
    private static List<Boolean> stop;
    
    static {
        //stop = new ArrayList<>();
        //stop = Collections.synchronizedList(stop);
        stop = new CopyOnWriteArrayList<>();
    }
    
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while ((stop.size() == 0) || !(stop.remove(0))) {}
            System.out.println("Worker stopped!");
        }).start();
        System.out.println("Worker started");
        Thread.sleep(1000);
        stop.add(true);
        System.out.println("Signal set, main exiting");
    }
}
