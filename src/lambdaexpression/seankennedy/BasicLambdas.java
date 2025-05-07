package lambdaexpression.seankennedy;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BasicLambdas {
    public static void main(String[] args) {
        //new BasicLambdas().consumer();
        new BasicLambdas().supplier();
    }

    public void consumer() {
        // Using our own version of Consumer
        Printable<String> printable = toBePrinted -> System.out.println(toBePrinted);
        printable.print("Printable lambda");

        // Using Consumer with lambda
        Consumer<String> consumer = (toBePrinted) -> System.out.println(toBePrinted);
        consumer.accept("Printable lambda");

        // Using Consumer with (static) method reference
        consumer = System.out::print;
        consumer.accept("Printable lambda");
    }

    public void supplier() {
        // Using our own version of Supplier
        Retrievable<Integer> retrievable = () -> 77;
        System.out.println(retrievable.retrieve());

        // Using Supplier with lambda
        Supplier<Integer> supplier = () -> 77;
        System.out.println(supplier.get());
    }

    public void predicate() {

    }

    public void function() {

    }

    private static void sortName(List<Person> personList) {

    }

    private static void sortAge(List<Person> personList) {

    }

    private static void sortHeight(List<Person> personList) {

    }

    private static List<Person> getPeople() {
        return null;
    }


}

@FunctionalInterface
interface Printable<T> {
    void print(T somethingToPrint);
}

@FunctionalInterface
interface Retrievable<T> {
    T retrieve();
}

@FunctionalInterface
interface Evaluate<T> {
    boolean isNegative(T input);
}

@FunctionalInterface
interface Functionable<T, R> {
    R applyThis(T input);
}

class Person {
    private Integer age;
    private String name;
    private Double height;

    public Person(Integer age, String name, Double height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    Integer getAge() {
        return age;
    }

    String getName() {
        return name;
    }

    Double getHeight() {
        return height;
    }
}

