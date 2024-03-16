package concurrency.synchronizedsample;

/**
 * This code demonstrates the use of keyword synchronized in concurrency.
 */
public class Main extends Thread {
    static Object lock1 = new Object();
    static Object lock2 = new Object();
    static volatile int i1, i2, j1, j2, k1, k2;
    
    @Override
    public void run() {
        while (true) {
            workWithLocks();
            workWithoutLocks();
        }
    }
    
    private void workWithoutLocks() {
        if (i1 != i2) {
            System.out.println("i");
        }
        
        if (j1 != j2) {
            System.out.println("j");
        }
        
        if (k1 != k2) {
            System.out.println("k");
        }
    }
    
    private void workWithLocks() {
        synchronized(lock1) {
            i1++;
            i2++;
        }
        
        synchronized(lock2) {
            k1++;
            k2++;
        }
        
        //j1++;
        //j2++;
    }
    
    public static void main(String[] args) {
        new Main().start();
        new Main().start();
    }
}

/**
 * Bard:
 * The main method creates a Counter object and two threads. Each thread calls increment 1000 times.
 * If we didn't use synchronized, it's possible that the final value would be incorrect due to race conditions
 * (where multiple threads access the same data at the same time). However, since increment is synchronized,
 * only one thread can update the value at a time, ensuring a final value of 2000.
 *
 * This is a very simple example, but it demonstrates how the synchronized keyword can be used to protect
 * shared data from race conditions in multi-threaded applications.
 */
class Counter {
    private int value = 0;

    public synchronized void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                counter.increment();
                System.out.println("thread1 counter: " + counter.getValue());
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                counter.increment();
                System.out.println("thread2 counter: " + counter.getValue());
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final counter value: " + counter.getValue());
    }
}

/**
 * Bard:
 * This code defines a NumberGenerator class with a static integer nextNumber and a static method getNextNumber.
 * This method returns the next available number and increments the nextNumber variable.
 * Since the method is marked as synchronized, only one thread can access it at a time, ensuring that
 * each thread gets a unique, sequential number, even if they call the method concurrently.
 *
 */
class NumberGenerator {

    private static int nextNumber = 0;

    public static synchronized int getNextNumber() {
        nextNumber++;
        return nextNumber;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + NumberGenerator.getNextNumber());
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + NumberGenerator.getNextNumber());
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

/**
 * Bard:
 * In this example, the updateData method only needs to be synchronized for the data modification part.
 * Reading the data in the getData method is assumed to be atomic (a single, indivisible operation),
 * so it doesn't need synchronization. This approach uses less overhead compared to synchronizing the entire method.
 *
 * Remember that synchronizing only specific blocks requires careful consideration to ensure
 * all potential access points to shared data are protected, preventing race conditions.
 */
class SharedResource {
    private int data = 0;

    public void updateData(int value) {
        synchronized (this) { // Synchronize only this specific block
            System.out.println(Thread.currentThread().getName() + ": " + data);
            data = data + value;
        }
    }

    public int getData() {
        // No synchronization needed for reading, assuming it's atomic
        return data;
    }

    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                resource.updateData(1);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                resource.updateData(-1);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final data value: " + resource.getData());
    }
}



