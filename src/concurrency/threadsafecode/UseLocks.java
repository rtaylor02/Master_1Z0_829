package concurrency.threadsafecode;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Lesson 26.6 on Simon Roberts' OCP 1z0-829 OReilly course
 *
 * This code demonstrates the mechanism and sequence of acquiring and releasing a lock shared between 2 threads.
 */
public class UseLocks {
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        var writeLock = reentrantReadWriteLock.writeLock();
        var condition = writeLock.newCondition();
        
        new Thread(() -> {
            System.out.println("t1 - started, taking lock");
            writeLock.lock(); // Once a thread request lock, start a try-catch block
            try {
                System.out.println("t1 - sleeping");
                Thread.sleep(1000);
                System.out.println("t1 - starting await");
                condition.await(); // Awaits the other thread to get the lock, so it temporarily release the lock. Will not continue until lock is regained from the other thread.
                System.out.println("t1 - restarted from await");
            } catch (InterruptedException e) {
                System.out.println("t1 - that shouldn't have happened...");
            } finally {
                System.out.println("t1 - releasing lock");
                writeLock.unlock();
            }
        }).start();
        
        new Thread(() -> {
            System.out.println("t2 - starting, about to sleep");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("t2 - that shouldn't have happened...");
            }
            System.out.println("t2 - attempting to get lock");
            writeLock.lock(); // Once a thread requests lock, start a try-catch block
            try {
                System.out.println("t2 - sleeping");
                Thread.sleep(1000);
                condition.signal(); // signal() does not release the lock. So execution continues.
                System.out.println("t2 - condition has been signaled");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                writeLock.unlock();
            }
        }).start();
    }
}

