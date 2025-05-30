package stream.assignment1.number1;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // 1a - Using custom functional interface - Printable
        consumer();

        // 1b - Using Consumer with lambda
        Consumer<String> consumerLambda = text -> System.out.println(text);
        consumerLambda.accept("Using Consumer with lambda");

        // 1c - Using Consumer with method reference
        Consumer<String> consumerMethodRef = System.out::println;
        consumerMethodRef.accept("Using Consumer with method reference");
    }

    private static void consumer() {
        Printable<String> printableLambda = text -> System.out.println(text);
        printableLambda.print("Printable lambda");
    }

    interface Printable<T> {
        void print(T text);
    }
}
