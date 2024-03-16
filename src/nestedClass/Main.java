package nestedClass;

//import nestedClass.Outer.Inner; // To be able to use it with the name Inner, not Outer.Inner.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Inner inner = new Outer(1).new Inner(11); // Outer.Inner needs to be imported to refer to it with only Inner.
        System.out.println("=================");
        Outer.Inner inner2 = new Outer(2).new Inner(21); // If you don't import Outer.Inner, refer to it by Outer.Inner.
        System.out.println("=================");
        Outer.StaticInner staticInner = new Outer.StaticInner(3);

        var index = 1;
        try {
            getArray()[index = 2]++;
        } catch (Exception e) {

        }
        System.out.println("index = " + index);

        int[] a = {1, 2, 3};
        int[] b = {10, 20, 30};
        //a[0] += (a = b)[0]; //a[0] = 11
        //a[0] = a[0] + (a = b)[0];
        System.out.println(a[0] += (a = b)[0]); // 11
        //a = b;
        System.out.println(Arrays.toString(a));
    }

    private static int[] getArray() {
        return null;
    }
}

class Outer {
    public Outer() {
        System.out.println("Outer instance");
    }

    public Outer(int id) {
        System.out.println("Outer instance-id: " + id);
    }

    class Inner {
        public Inner() {
            System.out.println("Inner instance");
        }

        public Inner(int id) {
            System.out.println("Inner instance-id: " + id);
        }
    }

    static class StaticInner {
        public StaticInner() {
            System.out.println("static Inner instance");
        }

        public StaticInner(int id) {
            System.out.println("static Inner instance-id: " + id);
        }
    }
}
