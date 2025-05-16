package stream.assignment1.number3;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // 3a - Using custom functional interface - Evaluate
        predicate();

        // 3b - Using Predicate functional interface with lambda
        Predicate<Integer> predicate = i -> i < 0;
        System.out.println(predicate.test(-1));
        System.out.println(predicate.test(1));

        // 3c - Using generically-typed method
        System.out.println(check(4, x -> x % 2 == 0));
        System.out.println(check(7, x -> x % 2 == 0));
        System.out.println(check("Mr.Joe Bloggs", s -> s.startsWith("Mr.")));
        System.out.println(check("Ms.Ann Bloggs", s -> s.startsWith("Mr.")));
        System.out.println(check(new Person("Mike", 33, 1.8), person -> person.age >= 18));
        System.out.println(check(new Person("Ann", 13, 1.4), person -> person.age >= 18));
    }

    private static <T> boolean check(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

    private record Person(String name, int age, double height) {}

    private static void predicate() {
        Evaluate<Integer> evaluate = i -> i < 0;
        System.out.println(evaluate.test(-1));
        System.out.println(evaluate.test(1));
    }

    interface Evaluate<T> {
        boolean test(T t);
    }
}
