package datastructures.iterable.collection.common;

import classdefandreachability.accesscontrolmodifiers.c.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * This class demonstrates how to use all the methods common to interface Collection<E> in class: List, Set, Queue.
 *
 * These methods are:
 * - boolean add(E e)
 * - boolean addAll(Collection<? extends E> c)
 * - void clear()
 * - boolean contains(Object o)
 * - boolean containsAll(Collection<?> c)
 * - boolean equals(Object o)
 * - int hashCode()
 * - boolean isEmpty()
 * - Iterator iterator()
 * - default Stream<E> parallelStream()
 * - boolean remove(Object o)
 * - boolean removeAll(Collection<?> c)
 * - boolean removeIf(Predicate<? super E> filter)
 * - boolean retainAll(Collection<?> c)
 * - int size()
 * - default Spliterator<E> spliterator()
 * - default Stream<E> stream()
 * - Object[] toArray()
 * - default<T> T[] toArray(IntFunction<T[]> generator)
 * - <T> T[] toArray(T[] a)
 *
 * From interface Iterable<E>:
 * - forEach
 */
public class Main {
    public static void main(String[] args) {
        //ArrayList.main(null);

        long time = System.nanoTime();
        Map<Integer, String> map = new HashMap<>();
        try {
            Random random = new Random();
            while (true) {
                String s = Integer.toString(random.nextInt());
                map.put(random.nextInt(), s);
                System.out.println(s);
            }
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("Map size: %d%n", map.size());
            System.out.printf("Elapsed: %d%n", time / 1_000_000);
        }
    }
}

class ArrayList {
    static java.util.ArrayList<String> arrayList = new java.util.ArrayList<>();

    public static void main(String[] args) {
        arrayList.add(new String("Hello"));
        arrayList.add("World");

        arrayList.forEach(System.out::println);
    }
}
