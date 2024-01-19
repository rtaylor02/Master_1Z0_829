package collectionsapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Structure of Java Collections API:
 *
 *                        *Collection                              *Map
 *    |------------------------|----------------------|              |---------------|-----------------|--------------|
 *  *List                   *Queue                  *Set          *SortedMap      WeakHashMap      Hashtable     HashMap
 *    |                                               |              |
 *  AbstractList                                  *SortedSet       TreeMap
 *    |--------------|------------|                   |
 *  LinkedList    ArrayList     Vector             TreeSet
 *
 *  * ==> interface
 *
 *  Collection interface ==> grouping of objects
 *  Map interface        ==> mapping of objects
 *
 *  SortedXX ==> elements are stored in a sorted order.
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        //showListContents(getLinkedList());
        
        showCollectionOperations();
    }
    
    private static void showCollectionOperations() {
        // Create collections
        Collection<String> strings = new HashSet<>();
        System.out.println("strings: " + strings);
        Collection<String> integers = Arrays.asList("1", "2", "3");
        System.out.println("integers: " + integers);
        
        // Add elements. Return value is boolean - true if collection changes
        System.out.println("adding 'hello' to strings: " + strings.add("hello"));
        System.out.println("adding integers to strings: " + strings.addAll(integers));
        System.out.println("strings: " + strings);
        
        // Copy collection using copy constructor and into array
        Collection<String> strings_copy = new ArrayList<>(strings);
        System.out.println("strings_copy: " + strings_copy);
        String[] stringArray = strings.toArray(new String[strings.size()]);
        System.out.println("stringArray: " + stringArray);
        
        // Remove elements. Return value is boolean - true if collection changes. Except clear()
        System.out.println("removing \"2\": " + strings.remove("2"));
        System.out.println("strings: " + strings);
        System.out.println("removing all of integers: " + strings.removeAll(integers));
        System.out.println("strings: " + strings);
        System.out.println("copying integers back into strings:" + strings.addAll(integers));
        System.out.println("strings: " + strings);
        System.out.println("clearing strings: ");
        strings.clear();
        System.out.println("strings: " + strings);
        
        
        // Querying collection
        System.out.println("strings size: " + strings.size());
        System.out.println("strings contains 'hello': " + strings.contains("hello"));
        System.out.println("strings contains all integers: " + strings.containsAll(integers));
        System.out.println("strings empty: " + strings.isEmpty());
        
    }
    
    private static LinkedList getLinkedList() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("one");
        linkedList.add("two");
        linkedList.add("three");
        return linkedList;
    }
    
    private static void showListContents(List list) {
        for (Object o : list) {
            System.out.println("> " + o);
        }
    }
}
