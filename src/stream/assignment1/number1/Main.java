package stream.assignment1.number1;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Invoking consumer():");
        consumer();

        System.out.println("Using Consumer functional interface:");
        Consumer<String> methodInference = System.out::println;
        methodInference.accept("Printable lambda");
    }

    private static void consumer() {
        Printable<String> printableLambda = text -> System.out.println(text);
        printableLambda.print("Printable lambda");
    }

    interface Printable<T> {
        void print(T text);
    }
}
