package lambdaexpression.seankennedy.assignment1.number4;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        function();
    }

    private static void function() {
        // 4a - Using custom functional interface - Functionable
        Functionable<Integer, String> functionable = i -> "Number is: " + i;
        System.out.println(functionable.apply(25));

        // 4b - Using Function with lambda
        Function<Integer, String> function = i -> "Number is: " + i;
        System.out.println(function.apply(25));
    }

    private interface Functionable<Integer, String> {
        String apply(Integer i);
    }
}
