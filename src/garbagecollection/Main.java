package garbagecollection;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        infiniteLoop();
    }

    // Sample code taken from LinkedIn course Marike van Putten
    private static void infiniteLoop() {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(Integer.valueOf(3));
            if (i > 1000) {
                list = new ArrayList<>();
                i = 0;
            }
            i++;
        }
    }
}

class OutOfMemorySample {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        int i = 0;
        while (true) {
            Person person = new Person("Joe");
            personList.add(person);
            if (i > 1000) {
                personList = new ArrayList<>();
                i = 0;
            }
        }
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
}

class OutOfMemorySample_Solved {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        int i = 0;
        while (true) {
            Person person = new Person("Joe");
            personList.add(person);
            if (i > 1000) {
                personList = new ArrayList<>();
                i = 0;
            }
            i++;
        }
    }
}
