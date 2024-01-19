package polymorphism;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        var o = new Onion();
        System.out.println(o.getData()); // Calling Layer's instance method
        
        A a = new A();
        B b = new B();
        Object o1 = a;
        Runnable runnable = (Runnable) o1; // OK
        Object o2 = b;
        Observer observer = (Observer) o2; // OK
        Object o3 = a;
        Observer observer1 = (Observer) o3; // OK - RE (Runtime Error)
        
        //int j = 0;
        for (int i = 0, j = 10; i < 10; j++) {
            
        }
    }
}

class Onion {
    private String data = "skin";
    
    private class Layer extends Onion {
        String data = "the good part";
        
        @Override
        public String getData() {
            return data; // this.data ==> Layer's instance data, not Onion's
        }
    }
    
    public String getData() {
        return new Layer().getData();
    }
}

class A implements Runnable {
    @Override
    public void run() { }
}

class B extends A implements Observer { }

interface Observer { }
interface ObserverX { }

