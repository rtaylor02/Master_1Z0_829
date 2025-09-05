package collectionsapi.set;

import java.util.*;

/**
 * Set:
 * - does not allow duplicates
 * - contains() has O(1) or O(log n)
 *
 * Commonly used methods:
 *
 */
public class Main {
    public static void main(String[] args) {
        //HashSets.basicHashSetOps();

        //LinkedHashSets.basicLinkedHashSetOps();

        //TreeSets.basicTreeSetOps();

        EnumSets.basicEnumSetOps();
    }

    private static class HashSets {
        private static void basicHashSetOps() {
            // Create a HashSet of Strings
            Set<String> fruits = new HashSet<>();

            // 1. add() – add elements
            fruits.add("Apple");
            fruits.add("Banana");
            fruits.add("Orange");

            // Duplicate element (ignored, no error)
            fruits.add("Apple");

            // 2. contains() – check existence
            System.out.println("Contains Banana? " + fruits.contains("Banana"));
            System.out.println("Contains Mango? " + fruits.contains("Mango"));

            // 3. remove() – remove an element
            fruits.remove("Orange");

            // 4. isEmpty() / size()
            System.out.println("Is empty? " + fruits.isEmpty());
            System.out.println("Size: " + fruits.size());

            // 5. iteration – order is not guaranteed
            System.out.println("All fruits:");
            for (String fruit : fruits) {
                System.out.println(fruit);
            }

            // 6. forEach() – using lambda
            fruits.forEach(f -> System.out.println("Fruit: " + f));

            // 7. addAll() – union with another set
            Set<String> tropical = new HashSet<>();
            tropical.add("Mango");
            tropical.add("Pineapple");
            fruits.addAll(tropical);

            System.out.println("After addAll: " + fruits);

            // 8. retainAll() – intersection
            Set<String> favorites = new HashSet<>();
            favorites.add("Apple");
            favorites.add("Mango");
            fruits.retainAll(favorites);

            System.out.println("After retainAll (only favorites): " + fruits);

            // 9. removeAll() – difference
            fruits.removeAll(favorites);
            System.out.println("After removeAll (cleared favorites): " + fruits);

            // 10. clear() – remove everything
            fruits.clear();
            System.out.println("Cleared. Is empty? " + fruits.isEmpty());
        }
    }

    private static class LinkedHashSets {
        private static void basicLinkedHashSetOps() {
            // Create a LinkedHashSet of Strings
            Set<String> cities = new LinkedHashSet<>();

            // 1. add() – add elements (insertion order preserved)
            cities.add("London");
            cities.add("Paris");
            cities.add("Berlin");

            // Duplicate element (ignored, no error)
            cities.add("London");

            // 2. contains() – check existence
            System.out.println("Contains Paris? " + cities.contains("Paris"));
            System.out.println("Contains Rome? " + cities.contains("Rome"));

            // 3. remove() – remove an element
            cities.remove("Berlin");

            // 4. isEmpty() / size()
            System.out.println("Is empty? " + cities.isEmpty());
            System.out.println("Size: " + cities.size());

            // 5. Iteration – insertion order guaranteed
            System.out.println("All cities in insertion order:");
            for (String city : cities) {
                System.out.println(city);
            }

            // 6. forEach() – using lambda
            cities.forEach(c -> System.out.println("City: " + c));

            // 7. addAll() – union with another set
            Set<String> extras = new LinkedHashSet<>();
            extras.add("Rome");
            extras.add("Madrid");
            cities.addAll(extras);
            System.out.println("After addAll: " + cities);

            // 8. retainAll() – intersection
            Set<String> favorites = new LinkedHashSet<>();
            favorites.add("London");
            favorites.add("Rome");
            cities.retainAll(favorites);
            System.out.println("After retainAll (favorites only): " + cities);

            // 9. removeAll() – difference
            cities.removeAll(favorites);
            System.out.println("After removeAll (favorites removed): " + cities);

            // 10. clear() – remove everything
            cities.clear();
            System.out.println("Cleared. Is empty? " + cities.isEmpty());
        }
    }

    private static class TreeSets {
        public static void basicTreeSetOps() {
            // Create a TreeSet of Strings (natural ordering)
            Set<String> fruits = new TreeSet<>();

            // 1. add() – add elements
            fruits.add("Apple");
            fruits.add("Banana");
            fruits.add("Orange");
            fruits.add("Mango");

            // Duplicate element (ignored)
            fruits.add("Apple");

            // 2. contains() – check existence
            System.out.println("Contains Banana? " + fruits.contains("Banana"));
            System.out.println("Contains Grapes? " + fruits.contains("Grapes"));

            // 3. remove() – remove an element
            fruits.remove("Mango");

            // 4. isEmpty() / size()
            System.out.println("Is empty? " + fruits.isEmpty());
            System.out.println("Size: " + fruits.size());

            // 5. Iteration – sorted order guaranteed
            System.out.println("All fruits in sorted order:");
            for (String fruit : fruits) {
                System.out.println(fruit);
            }

            // 6. forEach() – using lambda
            fruits.forEach(f -> System.out.println("Fruit: " + f));

            // 7. first() / last() – get smallest/largest elements
            TreeSet<String> treeSet = new TreeSet<>(fruits);
            System.out.println("First (smallest) element: " + treeSet.first());
            System.out.println("Last (largest) element: " + treeSet.last());

            // 8. headSet() / tailSet() – subset views
            System.out.println("Elements less than 'Orange': " + treeSet.headSet("Orange"));
            System.out.println("Elements greater or equal 'Banana': " + treeSet.tailSet("Banana"));

            // 9. ceiling() / floor() – nearest elements
            System.out.println("Ceiling of 'Blueberry': " + treeSet.ceiling("Blueberry"));
            System.out.println("Floor of 'Blueberry': " + treeSet.floor("Blueberry"));

            // 10. clear() – remove everything
            treeSet.clear();
            System.out.println("Cleared. Is empty? " + treeSet.isEmpty());
        }
    }

    private static class EnumSets {
        private enum Day {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
        }

        private static void basicEnumSetOps() {
            // 1. allOf() – create a set with all enum constants
            Set<Day> allDays = EnumSet.allOf(Day.class);
            System.out.println("All days: " + allDays);

            // 2. noneOf() – create an empty set
            Set<Day> noDays = EnumSet.noneOf(Day.class);
            System.out.println("No days: " + noDays);

            // 3. of() – create a set with specific enum constants
            Set<Day> weekdays = EnumSet.of(Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY);
            System.out.println("Weekdays: " + weekdays);

            // 4. add() – add an element
            weekdays.add(Day.SATURDAY); // adding a weekend day
            System.out.println("Weekdays after adding Saturday: " + weekdays);

            // 5. remove() – remove an element
            weekdays.remove(Day.FRIDAY);
            System.out.println("Weekdays after removing Friday: " + weekdays);

            // 6. contains() – check if element exists
            System.out.println("Contains Monday? " + weekdays.contains(Day.MONDAY));
            System.out.println("Contains Friday? " + weekdays.contains(Day.FRIDAY));

            // 7. addAll() – union with another EnumSet
            Set<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
            weekdays.addAll(weekend);
            System.out.println("After adding weekend: " + weekdays);

            // 8. removeAll() – difference
            weekdays.removeAll(EnumSet.of(Day.SATURDAY, Day.SUNDAY));
            System.out.println("After removing weekend: " + weekdays);

            // 9. retainAll() – intersection
            weekdays.retainAll(EnumSet.of(Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY));
            System.out.println("After retaining first 3 days: " + weekdays);

            // 10. iteration
            System.out.println("Iterating over days:");
            for (Day day : weekdays) {
                System.out.println(day);
            }

            // 11. clear() – remove all
            weekdays.clear();
            System.out.println("Cleared weekdays: " + weekdays.isEmpty());
        }
    }
}
