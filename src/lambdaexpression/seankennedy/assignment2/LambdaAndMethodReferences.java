package lambdaexpression.seankennedy.assignment2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class LambdaAndMethodReferences {
    public static void main(String[] args) {
        AssigmentNumber1.staticMR();
    }
    private class AssigmentNumber1 {
        private static void staticMR() {
            List<Integer> integers = Arrays.asList(1, 2, 7, 4, 5);
            System.out.println(integers);
            System.out.println("============");
            Consumer<List<Integer>> consumer = list -> Collections.sort(list);
            consumer.accept(integers);
            System.out.println(integers);

            integers = Arrays.asList(1, 2, 7, 4, 5);
            System.out.println(integers);
            System.out.println("============");
            consumer = Collections::sort;
            consumer.accept(integers);
            System.out.println(integers);

        }
    }
}
