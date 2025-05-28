package lambdaexpression.seankennedy.assignment1.number5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var listPeople = getPeople();
        listPeople.forEach(System.out::println);
        System.out.println("=====sorted by age:======");
        sortAge(listPeople);
        listPeople.forEach(System.out::println);
        System.out.println("=====sorted by name:======");
        sortName(listPeople);
        listPeople.forEach(System.out::println);
        System.out.println("=====sorted by height:======");
        sortHeight(listPeople);
        listPeople.forEach(System.out::println);
    }

    private static void sortName(List<Person> listPeople) {
        //listPeople.sort(Comparator.comparing(p -> p.name));
        listPeople.sort(Comparator.comparing(Person::name));
    }

    private static void sortHeight(List<Person> listPeople) {
        //listPeople.sort(Comparator.comparing(p -> p.height));
        listPeople.sort(Comparator.comparing(Person::height));
    }

    private static void sortAge(List<Person> listPeople) {
        //listPeople.sort(Comparator.comparing(p -> p.age));
        listPeople.sort(Comparator.comparing(Person::age));
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }

    private record Person(String name, int age, double height) {}
}
