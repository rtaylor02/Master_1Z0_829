package cloneable;

/**
 * @author Rodney Taylor (u228616)
 */
public class Main {
    public static void main(String[] args) {
        B b = new B();
        try {
            b.clone();
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            System.out.println("Caught!");
            cloneNotSupportedException.printStackTrace();
        }
    }
}

class A implements Cloneable { // If A does not implement Cloneable, runtime error CloneNotSupportedException
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (A) super.clone();
    }
}

class B extends A {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (B) super.clone();
    }
}