package collectionsapi.map;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map:
 * - key,value pairs
 *
 * Commonly used methods:
 * - adding elements  : put(), putAll()
 * - removing elements: remove(), removeAll(), retainAll(), clear()
 * - querying         : get(), containsKey(), containsValue()
 */
public class Main {
    public static void main(String[] args) {
        //HashMaps.basicHashMapOps();

        //LinkedHashMaps.basicLinkedHashMapOps();

        //TreeMaps.basicTreeMapOps();

        EnumMaps.basicEnumMapOps();
    }

    private static class HashMaps {
        private static void basicHashMapOps() {
            // Create a HashMap (keys: String, values: Integer)
            Map<String, Integer> scores = new HashMap<>();

            // 1. put() – add elements
            scores.put("Alice", 85);
            scores.put("Bob", 92);
            scores.put("Charlie", 78);

            // 2. get() – retrieve a value by key
            System.out.println("Alice's score: " + scores.get("Alice"));

            // 3. containsKey() – check if a key exists
            if (scores.containsKey("Bob")) {
                System.out.println("Bob is in the map.");
            }

            // 4. containsValue() – check if a value exists
            if (scores.containsValue(92)) {
                System.out.println("Someone scored 92.");
            }

            // 5. remove() – remove an entry
            scores.remove("Charlie");

            // 6. replace() – update a value
            scores.replace("Alice", 90);

            // 7. putIfAbsent() – only put if key not already present
            scores.putIfAbsent("Diana", 88);

            // 8. forEach() – iterate over key-value pairs (Java 8+)
            scores.forEach((name, score) ->
                    System.out.println(name + " scored " + score)
            );

            // 9. keySet(), values(), entrySet()
            System.out.println("All students: " + scores.keySet());
            System.out.println("All scores: " + scores.values());
            System.out.println("Entries: " + scores.entrySet());

            // 10. getOrDefault() – fetch with a fallback
            int eveScore = scores.getOrDefault("Eve", 0);
            System.out.println("Eve's score: " + eveScore);

            // 11. size() and isEmpty()
            System.out.println("Map size: " + scores.size());
            System.out.println("Is map empty? " + scores.isEmpty());

            // 12. clear() – remove everything
            scores.clear();
            System.out.println("Map cleared. Is empty? " + scores.isEmpty());
        }
    }

    private static class LinkedHashMaps {
        private static void basicLinkedHashMapOps() {
            // Create a LinkedHashMap with insertion order
            Map<String, String> capitals = new LinkedHashMap<>();

            // 1. put() – add entries
            capitals.put("UK", "London");
            capitals.put("France", "Paris");
            capitals.put("Germany", "Berlin");

            // 2. get() – retrieve a value
            System.out.println("Capital of France: " + capitals.get("France"));

            // 3. containsKey() / containsValue()
            System.out.println("Contains Germany? " + capitals.containsKey("Germany"));
            System.out.println("Contains Rome? " + capitals.containsValue("Rome"));

            // 4. remove()
            capitals.remove("UK");

            // 5. replace()
            capitals.replace("Germany", "Munich"); // Now Berlin → Munich

            // 6. putIfAbsent()
            capitals.putIfAbsent("Spain", "Madrid");

            // 7. getOrDefault()
            String italy = capitals.getOrDefault("Italy", "Not Found");
            System.out.println("Capital of Italy: " + italy);

            // 8. keySet(), values(), entrySet() – iteration
            System.out.println("Countries: " + capitals.keySet());
            System.out.println("Capitals: " + capitals.values());
            System.out.println("Entries: " + capitals.entrySet());

            // 9. forEach() – iterate in insertion order
            capitals.forEach((country, capital) ->
                    System.out.println(country + " → " + capital)
            );

            // 10. size() / isEmpty()
            System.out.println("Map size: " + capitals.size());
            System.out.println("Is empty? " + capitals.isEmpty());

            // 11. clear()
            capitals.clear();
            System.out.println("Cleared. Is empty? " + capitals.isEmpty());

            // Bonus: LinkedHashMap with access order = true
            // Acts like an LRU (Least Recently Used) cache
            LinkedHashMap<Integer, String> lruCache = new LinkedHashMap<>(3, 0.75f, true);
            lruCache.put(1, "A");
            lruCache.put(2, "B");
            lruCache.put(3, "C");
            lruCache.put(4, "D");
            lruCache.put(5, "E");

            // Access key 1 (moves it to end)
            lruCache.get(1);

            // Access key 3 (moves it to end)
            lruCache.get(3);

            System.out.println("Access-order iteration: " + lruCache);
        }
    }

    private static class TreeMaps {
        private static void basicTreeMapOps() {
            // Create a TreeMap (keys are sorted in natural order by default)
            Map<String, Integer> scores = new TreeMap<>();

            // 1. put() – add entries
            scores.put("Diana", 88);
            scores.put("Bob", 92);
            scores.put("Alice", 85);
            scores.put("Charlie", 78);

            // 2. get() – retrieve a value
            System.out.println("Bob's score: " + scores.get("Bob"));

            // 3. containsKey() / containsValue()
            System.out.println("Contains Alice? " + scores.containsKey("Alice"));
            System.out.println("Contains score 100? " + scores.containsValue(100));

            // 4. remove() – remove entry
            scores.remove("Charlie");

            // 5. replace() – update value
            scores.replace("Diana", 90);

            // 6. putIfAbsent()
            scores.putIfAbsent("Eve", 75);

            // 7. getOrDefault()
            int frankScore = scores.getOrDefault("Frank", 0);
            System.out.println("Frank's score: " + frankScore);

            // 8. keySet(), values(), entrySet()
            System.out.println("All names (sorted): " + scores.keySet());
            System.out.println("All scores: " + scores.values());
            System.out.println("Entries: " + scores.entrySet());

            // 9. forEach() – iteration in sorted key order
            scores.forEach((name, score) ->
                    System.out.println(name + " → " + score)
            );

            // 10. NavigableMap features
            TreeMap<String, Integer> treeMap = new TreeMap<>(scores);

            System.out.println("First entry: " + treeMap.firstEntry());
            System.out.println("Last entry: " + treeMap.lastEntry());
            System.out.println("Entry lower than Bob: " + treeMap.lowerEntry("Bob"));
            System.out.println("Entry higher than Bob: " + treeMap.higherEntry("Bob"));

            // 11. size() / isEmpty()
            System.out.println("Size: " + treeMap.size());
            System.out.println("Is empty? " + treeMap.isEmpty());

            // 12. clear()
            treeMap.clear();
            System.out.println("Cleared. Is empty now? " + treeMap.isEmpty());
        }
    }

    private static class EnumMaps {
        private static enum Day {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
        }
        private static void basicEnumMapOps() {
            // Create an EnumMap with Day enum as the key type
            Map<Day, String> activities = new EnumMap<>(Day.class);

            // 1. put() – add entries
            activities.put(Day.TUESDAY, "Swimming");
            activities.put(Day.FRIDAY, "Movie Night");
            activities.put(Day.MONDAY, "Gym");

            // 2. get() – retrieve value
            System.out.println("Friday activity: " + activities.get(Day.FRIDAY));

            // 3. containsKey() / containsValue()
            System.out.println("Has Wednesday? " + activities.containsKey(Day.WEDNESDAY));
            System.out.println("Has 'Gym'? " + activities.containsValue("Gym"));

            // 4. putIfAbsent()
            activities.putIfAbsent(Day.WEDNESDAY, "Work from Home");

            // 5. replace()
            activities.replace(Day.FRIDAY, "Concert");

            // 6. getOrDefault()
            String sunday = activities.getOrDefault(Day.SUNDAY, "No plan");
            System.out.println("Sunday: " + sunday);

            // 7. remove()
            activities.remove(Day.TUESDAY);

            // 8. Iteration (keys follow enum natural order)
            System.out.println("Weekly activities:");
            activities.forEach((day, activity) -> System.out.println(day + " → " + activity)
            );

            // 9. keySet(), values(), entrySet()
            System.out.println("Days: " + activities.keySet());
            System.out.println("Plans: " + activities.values());
            System.out.println("Entries: " + activities.entrySet());

            // 10. size() / isEmpty()
            System.out.println("Size: " + activities.size());
            System.out.println("Is empty? " + activities.isEmpty());

            // 11. clear()
            activities.clear();
            System.out.println("Cleared. Is empty now? " + activities.isEmpty());
        }
    }
}
