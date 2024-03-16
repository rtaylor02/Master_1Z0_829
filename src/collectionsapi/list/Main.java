package collectionsapi.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * List:
 * - ordered
 * - allow duplicates
 * - 'expandable array'
 *
 * Commonly used methods:
 * - adding elements  : add(), addAll()
 * - removing elements: remove(), removeAll(), retainAll(), clear()
 * - querying         : get(), indexOf()
 */
public class Main {
    public static void main(String[] args) {
        unmodifiableList();
    }

    private static void unmodifiableList() {
        var numA = new Integer[]{1, 2};
        var list1 = new ArrayList<>(List.of(numA));
        list1.add(null);
        System.out.println(list1);

        var list2 = List.of(1,2,3); // of(E...) & copyOf(Collection) creates unmodifiable List
        //list2.add(null); // RE - UnsupportedOperationException because it's an unmodifiable List
        System.out.println(list2);

        var set1 = Set.of(1, 2); // of(E...) & copyOf(Collection) creates unmodifiable Set
        //set1.add(3); // RE - UnsupportedOperationException because it's an unmodifiable set
        System.out.println(set1);

        Integer[] array = new Integer[] {1, 2, 3, null};
        var list3 = List.of(array); // RE - NullPointerException: of() creates unmodifiable List whose elements are non-null
        System.out.println(list3);

    }
}
