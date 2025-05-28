package lambdaexpression.seankennedy.assignment1.number2;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        supplier();
    }

    private static void supplier() {
        // 2a - Using custom functional interface - Retrievable
        Retrievable<Integer> retrievableLambda = () -> 77;
        System.out.println(retrievableLambda.get());

        // 2b - Using Supplier functional interface
        Supplier<Integer> supplier = () -> 77;
        System.out.println(supplier.get());
    }

    interface Retrievable<Integer> {
        Integer get();
    }
}
