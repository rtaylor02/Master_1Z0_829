package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //lazyEvaluation();

        //printingFromFile();

        generateInfiniteStream();

        generateFiniteStream();

        //printingFromStream();

        //grouping();

        //partitioning();

        //mapping();

        //teeing();
    }

    private static void lazyEvaluation() {
        System.out.println("Lazy evaluation = nothing happens until terminal ops occurs");

        System.out.println("======== Sample 1 ========");
        Stream.of("Andy", "David", "April", "Edward")
                .filter(name -> {
                    System.out.println("filter: " + name + " - intermediate ops");
                    return true;
                })
                .forEach(name -> System.out.println("forEach: " + name + " - terminal ops"));

        System.out.println("======== Sample 2 ========");
        Stream.of("Andy", "David", "April", "Edward")
                .map(name -> {
                    System.out.println("map: " + name + " - intermediate ops");
                    return name.toUpperCase();
                })
                .anyMatch(upperCaseName -> {
                    System.out.println("anyMatch: " + upperCaseName + " - terminal ops");
                    return upperCaseName.startsWith("D");
                });

        System.out.println("======== Sample 3 ========");
        List<String> names = Arrays.asList("Andy", "David", "April", "Edward", "Ben", "Charlie", "Benedict", "Barry", "Dominic");
        names.stream()
                .peek(System.out::println)
                .filter(name -> {
                    System.out.println("filter1: " + name + " - intermediate ops");
                    return name.startsWith("B") || name.startsWith("C");
                })
                .filter(name -> {
                    System.out.println("filter2: " + name + " - intermediate ops");
                    return name.length() > 3;
                })
                .limit(1)
                .forEach(System.out::println);
    }

    private static void printingFromStream() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println(list.stream().mapToInt(x -> x).sum()); // 6 - Stream to IntStream and sum it
        System.out.println(list.stream().reduce(0, (a, b) -> a + b));
        System.out.println(list.stream().collect(Collectors.summarizingInt(x -> x)).getSum()); // 6 - Stream to IntSummaryStatistics and sum it
        System.out.println(list.stream().collect(Collectors.mapping(x -> x, Collectors.summarizingInt(x -> x))).getSum());
    }

    private static void printingFromFile() {
        List<Cat> cats = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\mailb\\OneDrive\\My Java\\1Z0_829\\prep\\Master_1Z0_829\\src\\stream\\Cats.txt"))) {
            stream.forEach(line -> {
                String[] data = line.split("/");
                cats.add(new Cat(data[0], data[1]));
            });
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }

        cats.forEach(System.out::println);
    }

    private static void generateFiniteStream() {
        // Equivalent to for (T index=seed; hasNext.test(index); index = next.apply(index))
        Stream<Integer> stream = Stream.iterate(1, n -> n < 10, n -> n + 1);
        stream.forEach(System.out::println);
    }

    private static void generateInfiniteStream() {
        Stream<Integer> stream = Stream.iterate(1,  n -> n + 1);
        stream.forEach(System.out::println);
    }

    private static void grouping() {
        // Using no supplier and no downstream collector
        class Item{
            private String name;
            private String category;
            private double price;
            
            public Item(String name, String category, double price){
                this.name = name;
                this.category = category;
                this.price = price;
            }

            public String getCategory() {
                return this.category;
            }
        }

        List<Item> items = Arrays.asList(
                new Item("Pen", "Stationery", 3.0),
                new Item("Pencil", "Stationery", 2.0),
                new Item("Eraser", "Stationery", 1.0),
                new Item("Milk", "Food", 2.0),
                new Item("Eggs", "Food", 3.0)
        );

        Map<String, List<Item>> map = items.stream().collect(Collectors.groupingBy(
            Item::getCategory
        ));
        System.out.println(map); // {Stationery=[stream.Main$1Item@6eb2384f, stream.Main$1Item@3c9c0d96, stream.Main$1Item@3a4621bd], Food=[stream.Main$1Item@31dadd46, stream.Main$1Item@4ed5eb72]}



        // ***********************************************
        var a = Stream.of("a", "b", "ab", "b");

        // Using downstream collector by Collectors.toSet()
        TreeMap<Integer, Set<String>> treeMap = a.collect (
                                                Collectors.groupingBy(
                                                    String::length,
                                                    TreeMap::new,
                                                    Collectors.toSet()
                                                )
        );
        System.out.println(treeMap); // {1=[a, b], 2=[ab]}

        // Using downstream collector by Collectors.toList()
        var a1 = Stream.of("a", "b", "ab", "b");
        TreeMap<Integer, List<String>> treeMap1 = a1.collect (
                                                Collectors.groupingBy(
                                                    String::length,
                                                    TreeMap::new,
                                                    Collectors.toList()
                                                )
        );
        System.out.println(treeMap1); // {1=[a, b, b], 2=[ab]}

        // Using downstream collector by Collectors.counting()
        var a2 = Stream.of("a", "b", "ab", "b");
        TreeMap<Integer, Long> treeMap2 = a2.collect (
                                                Collectors.groupingBy(
                                                    String::length,
                                                    TreeMap::new,
                                                    Collectors.counting()
                                                )
        );
        System.out.println(treeMap2); // {1=3, 2=1}        
    }

    private static void partitioning() {
        // Using no downstream collector
        var a = Stream.of("a", "b", "ab", "b");
        Map<Boolean, List<String>> map = a.collect(
                                        Collectors.partitioningBy(s -> s.length() >= 2));
        System.out.println(map); // {false=[a, b, b], true=[ab]}

        // Using downstream collector by Collectors.toSet()
        var a1 = Stream.of("a", "b", "ab", "b");
        Map<Boolean, Set<String>> map1 = a1.collect(
                                        Collectors.partitioningBy(
                                            s -> s.length() >= 2,
                                            Collectors.toSet()
                                            )
        );
        System.out.println(map1); // {false=[a, b], true=[ab]}

        // Using downstream collector by Collectors.counting()
        var a2 = Stream.of("a", "b", "ab", "b");
        Map<Boolean, Long> map2 = a2.collect(
                                        Collectors.partitioningBy(
                                            s -> s.length() >= 2,
                                            Collectors.counting()
                                            )
        );
        System.out.println(map2); // {false=3, true=1}
    }

    private static void mapping() {
        var a = Stream.of("aaa", "bbb", "cccc", "bbb");
        Map<Integer, Optional<Character>> map = a.collect(
                                        Collectors.groupingBy(
                                            String::length, 
                                            Collectors.mapping(
                                                s -> s.charAt(0), 
                                                Collectors.minBy((x, y) -> x - y))));
        System.out.println(map); // {3=Optional[a], 4=Optional[c]} 
    }

    private static void teeing() {
        record Names(String spaceSeparated, String commaSeparated) {};
        
        List<String> a = List.of("Alex", "Florence", "Tommy", "Jonathan");
        Names names = a.stream().collect(
                                Collectors.teeing(
                                    Collectors.joining(" "), 
                                    Collectors.joining(", "), 
                                    (s, t) -> new Names(s, t))
        );
        System.out.println(names); // Names[spaceSeparated=Alex Florence Tommy Jonathan, commaSeparated=Alex, Florence, Tommy, Jonathan]
        System.out.println(names.commaSeparated); // Alex, Florence, Tommy, Jonathan
        System.out.println(names.spaceSeparated); // Alex Florence Tommy Jonathan        
    }
}

record Cat(String name, String colour) {}
