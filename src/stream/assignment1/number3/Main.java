package stream.assignment1.number3;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Invoking predicate():");
        predicate();

        System.out.println("Using Predicate functional interface:");
        Predicate<Integer> predicate = i -> i < 0;
        System.out.println(predicate.test(-1));
        System.out.println(predicate.test(1));
    }

    private static void predicate() {
        Evaluate<Integer> evaluate = i -> i < 0;
        System.out.println(evaluate.test(-1));
        System.out.println(evaluate.test(1));
    }

    interface Evaluate<T> {
        boolean test(T t);
    }
}
