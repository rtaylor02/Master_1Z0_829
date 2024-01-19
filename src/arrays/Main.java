package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        //trial1();
        //showParallelPrefix();
        showFibonacci();
    }
    
    
    private static void trial1() {
        var a = new int[]{1, 2, 3, 4};
        int[] b = {3, 2, 1, 0};
        System.out.println(a[(a = b)[3]]); // a[0] = 1
    }
    
    private static void showParallelPrefix() {
        int[] base = {0, 1, 2, 3, 4, 5};
        Arrays.parallelPrefix(base, (a, b) -> a + b);
        System.out.println(Arrays.toString(base));
    }
    
    private static void showFibonacci() {
        List<Integer> fib = new ArrayList<>(Arrays.asList(0, 1));
        for (int i = 0; i < 10; i++) {
            int first = fib.get(i);
            int second = fib.get(i + 1);
            fib.add((i + 2), (first + second));
        }
        
        System.out.println(fib);
    }
    
    
}



