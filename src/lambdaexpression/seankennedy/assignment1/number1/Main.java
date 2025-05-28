package lambdaexpression.seankennedy.assignment1.number1;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        consumer();
    }

    private static void consumer() {
        // 1a - Using custom functional interface - Printable
        Printable<String> printableLambda = text -> System.out.println(text);
        printableLambda.print("Printable lambda");

        // 1b - Using Consumer with lambda
        Consumer<String> consumerLambda = text -> System.out.println(text);
        consumerLambda.accept("Printable lambda");

        // 1b - Using Consumer with method reference
        Consumer<String> consumerMethodRef = System.out::println;
        consumerMethodRef.accept("Printable lambda");
    }

    interface Printable<String> {
        void print(String text);
    }
}
