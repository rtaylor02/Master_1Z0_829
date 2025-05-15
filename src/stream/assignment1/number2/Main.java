package stream.assignment1.number2;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("Invoking supplier():");
        supplier();

        System.out.println("Using Supplier functional interface:");
        Supplier<Integer> supplier = () -> 77;
        System.out.println(supplier.get());
    }

    private static void supplier() {
        Retrievable<Integer> retrievableLambda = () -> 77;
        System.out.println(retrievableLambda.get());
    }

    interface Retrievable<T> {
        T get();
    }
}
