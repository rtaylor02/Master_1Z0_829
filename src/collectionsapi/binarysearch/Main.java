package collectionsapi.binarysearch;

import java.util.Arrays;

/**
 * Binary search is performed by splitting a SORTED array into 2 parts and decides where the element would be.
 * This is repeated until either the element is found, or not found but we know where it should be.
 * Thus, it's important that the array is sorted.
 */
public class Main {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie", "Denise", "Frank", "Eve", "Grace", "Heidi", "Ivan"};
        System.out.println(Arrays.binarySearch(names, "Charlie")); // Charlie at index 2
        System.out.println(Arrays.binarySearch(names, "Eve")); // Eve, not found, should be at index 4.
                                                                // -1 ==> index 0, etc
    }
}
