package lambdaexpression;

import java.util.function.BiFunction;

/**
 * @author Rodney Taylor (u228616)
 */
public class Main {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x * y;
        
        System.out.println("3 * 4 = " + biFunction.apply(3, 4));
    }
}
