package stream.assignment1.number4;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // 4a - Using custom functional interface - Functionable
        function();

        // 4b - Using Function with lambda
        Function<Integer, String> function = i -> "Number is: " + i;
        System.out.println(function.apply(25));
    }

    private static void function() {
        Functionable<Integer, String> functionable = i -> "Number is: " + i;
        System.out.println(functionable.apply(25));
    }

    private interface Functionable<T, R> {
        R apply(T t);
    }
}
