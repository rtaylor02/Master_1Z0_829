package interfaces;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import static java.lang.Double.parseDouble;

public class Main {


    public static void main(String[] args) {
        C c = new C();
        c.method1();
        I.method2();
        //c.method3(); // CE
        //I.method4(); // CE

        C2 c2 = new C2();
        C1.staticM1();
        C2.staticM1();
        c2.c2Method();

    }
}

interface I {
    public static int g = 10; // Implicitly final
    public int ii = 3; // Implicitly static final
    //private int i = 3; // No private - CE
    //private static final int FIELD1 = 1; // No private - CE
    //private static int h = 1; // No private - CE



    // public non-static is allowed in interface ==> must use 'default' as not to conflict with interface
    // public abstract non-static methods that should not have a body ({})
    //
    // 'default' methods:
    // Before Java 8, interface methods are implicitly public and abstract. Abstract methods CANNOT have a body.
    // Hence, keyword 'default' is to allow normal methods and avoid CE. Without 'default', compiler will think
    // it's an abstract method with body, which is a CE.
    // Default methods are inheritable.
    public default void method1() {
        System.out.println("public default");
        //ii++;
    }

    public static void method2() {
        System.out.println("public static");
        System.out.println(ii); // This proves that ii is static. Otherwise it cannot be referenced in static method.
    }

    // private non-static methods are allowed in interface.
    private void method3() {
        System.out.println("private instance");
    }

    // private static methods are allowed in interface. However, it cannot be inherited.
    private static void method4() {
        System.out.println("private static");
    }


}

class C implements I {


}

interface I1 {
    void m1() throws IOException;
}

interface I2 {
    void m1() throws SQLException;
}

class C1 implements I1, I2 {
    public static void staticM1() {
        System.out.println("staticM1()");
    }

    @Override
    public void m1() {
        System.out.println("Overridden m1");
    }
}

class C2 extends C1 {
    public void c2Method() {
        staticM1();
        m1();

        double d = 1/0.0;
        System.out.println("d = " + d);
        d = 0/0.0;
        System.out.println("d = " + d);
        d = parseDouble("INFINITY");
        System.out.println("d = " + d);
        d = parseDouble("+Infinity");
        System.out.println("d = " + d);
    }
}

class SwitchExpressionExample {

    enum Season {
        SPRING, SUMMER, AUTUMN, WINTER
    }

    public static void main(String[] args) {
        Season currentSeason = Season.SUMMER;

        String seasonDescription = switch (currentSeason) {
            case SPRING, AUTUMN -> "Mild weather"; // No 'yield' needed, directly returning a string
            case SUMMER -> {
                yield "Hot weather"; // 'yield' enclosed in curly braces
            }
            case WINTER -> "Cold weather";
        };

        System.out.println("Season description for " + currentSeason + ": " + seasonDescription);
    }
}



class FileWordProcessor {

    public static String findLongestWord(String filePath) {
        try {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(Path.of(filePath), StandardCharsets.UTF_8);

            // Combine lines into a single string
            String content = String.join(" ", lines);

            // Split the content into words
            String[] words = content.split("\\s+");

            // Find the longest word using Streams and Comparator
            return List.of(words)
                    .stream()
                    .max(Comparator.comparingInt(String::length))
                    .orElse(null);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public class A {
        public List<Number> getList(int id) { return null; }
    }

    public class B extends A {
        @Override
        public ArrayList<Number> getList(int id) { return null; }
    }

    public class AA<K, V> {
        public <K, V> AA<K, V> getAA(K k, V v) {
            return new AA<K, V>(k, v);
        }

         <T, U> void getget(T t, U u) {

        }

        public AA(K k, V v) {}
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\mailb\\OneDrive\\one.txt"; // Replace with the actual file path

        String longestWord = findLongestWord(filePath);

        if (longestWord != null) {
            System.out.println("Longest word in the file: " + longestWord);
        } else {
            System.out.println("An error occurred while processing the file.");
        }

        System.out.println(10%3);

        Map<?, ?> m = Map.of(1, 2);

        // Unmodifiable List: List.of() or List.copyOf()
        Integer[] array = new Integer[]{1, 2, 3};
        List<Integer> list = List.of(array); // Unmodifiable list via array - cannot have null and deep copy, i.e. separate from original array
        //List<Integer> list = List.of(1, 2, 3); // Unmodifiable list direct assignment
        //List<Integer> list = List.of(1, null, 3); // NullPointerException: Unmodifiable list - cannot have null
        System.out.println(list);
        list.forEach(a -> a = a * 2);
        System.out.println("List: " + list);
        //list.replaceAll(a -> a * 2); // java.lang.UnsupportedOperationException since it's unmodifiable list.
        //System.out.println("List after replaceAll(): " + list);
        array[1] = 22;
        System.out.println("list after array is modified = " + list);

        // Unmodifiable List:  Collections.unmodifiableList()
        List<Integer> list1 = Collections.unmodifiableList(Arrays.asList(array)); // Unmodifiable list with shallow copy and can include null
        System.out.println("list1 before array is modified = " + list1);
        array[1] = 2222;
        System.out.println("list1 after array is modified = " + list1);


        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        System.out.println(list2);
        list.forEach(b -> b *= 2);
        System.out.println(list2);
        list2.replaceAll(c -> c * 2);
        System.out.println(list2);
        list2.forEach(System.out::println);
        m2(list2.get(0));

        Integer i = 300;
        System.out.println(i);
        i++;
        System.out.println(i);

        List listList = new ArrayList();
        listList.add(LocalDate.now());
        System.out.println(listList.get(0));
        List<String> ls = listList;
        //String s = ls.get(0);

        String[] arrayString = {"a", "b"};
        covariant(arrayString);

        List<String> stringList = Arrays.asList(arrayString);
        //invariant(stringList); // CE
    }

    static void covariant(Object[] objects) {}
    static void invariant(List<Object> objects) {}

    static void m2(Integer i) {
        i = i * 20;
    }

    class C1{}
    interface I1{}
    interface I2{}
    interface I3{}
    class C2<E extends C1 & I1 & I2 & I3>{}


}

class Baap {
    public int h = 4;
    public int getH() {
        System.out.println("Baap " + h);
        return h;
    }
}

class Beta extends Baap {
    public int h = 44;
    public int getH() {
        System.out.println("Beta " + h);
        return h;
    }

    public static void main(String[] args) {
        Baap b = new Beta();
        System.out.println(b.h + " " + b.getH());
        Beta bb = (Beta)b;
        System.out.println(bb.h + " " + bb.getH());

        StringBuilder stringBuilder = new StringBuilder("Hallo");
        System.out.println(stringBuilder);
        stringBuilder = stringBuilder.delete(5,5);
        System.out.println(stringBuilder);

        LocalDate date = LocalDate.now();
        System.out.println(date);
        date = date.plusYears(1);
        System.out.println(date);
        date = date.minusYears(1).plusDays(1);
        System.out.println(date);

        Boolean b1 = true;
        Boolean b2 = false;
    }


}

abstract class AbstractClass {
    abstract void abstractMethod();

    public static void main(String[] args) {
        System.out.println("Checking...");
        AbstractClass abstractClass = null;
        //abstractClass.abstractMethod(); // NPE
    }
}

class E1 extends Exception {}
class E2 extends E1{}
class E3 extends Exception {}
class MultiThrow {
    public static void main(String[] args) {
        try {
            multiThrow();
        } catch (Exception e) {
            for (Throwable t : e.getSuppressed()) {
                System.out.println("Printing suppressed: " + t);
            }
            throw new RuntimeException(e);
        }
    }

    private static void multiThrow() throws Exception {
        int i = (Math.random() > 0.4) ? 1 : 2;
        try {
            if (i == 1) {
                throw new E1();
            } else if (i == 2) {
                throw new E3();
            } else {
                throw new E2();
            }
        } catch (E1 | E3 e) {
            System.out.println("Catching E1 or E3");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Catching Exception");
        } finally {
            System.out.println("Finally");
        }
    }
}

class CollectionTest {
    public static void main(String[] args) {
        // Modifying array whilst iterating
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println("array before: " + Arrays.toString(array));
        int counter = 0;
        for (int i : array) {
            System.out.println(i);
            if (i > 3) {
                counter++;
                array[counter] *= 2; // Array mods during iteration: OK
            }
        }
        System.out.println("array now: " + Arrays.toString(array));

        // Modifying List whilst iterating
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        for (var value : list) {
            System.out.println(value);
            list.add(value); // List mods during iteration: ConcurrentModificationException
        }

    }
}


