package concurrency;

/**
 * This code demonstrate the use of Thread:
 * 1. Thread started only when start() method is invoked
 * 2. ...
 */
public class Main {
    public static void main(String[] args) {
        //trial1();
        
        trial2();
    }
    
    private static void trial2() {
        Incrementor incrementor = new Incrementor();
        Decrementor decrementor = new Decrementor();
        decrementor.start();
        incrementor.start();
    }
    
    private static void trial1() {
        Incrementor incrementor = new Incrementor();
        incrementor.increment();
        System.out.println(Incrementor.k);
        
        Decrementor decrementor = new Decrementor();
        decrementor.decrement();
        decrementor.decrement();
        System.out.println(Decrementor.k);
    }
}

class Base extends Thread {
    static volatile int k = 10;
}

class Incrementor extends Base {
    @Override
    public void run() {
        for (; k < 15; k++) {
            System.out.println("Incrementing...k = " + k);
        }
    }
    
    public void increment() {
        System.out.println("incrementing k");
        k++;
    }
}

class Decrementor extends Base {
    @Override
    public void run() {
        for (; k > 0; k--) {
            System.out.println("Decrementing...k = " + k);
        }
    }
    public void decrement() {
        System.out.println("decrementing k");
        k--;
    }
}



