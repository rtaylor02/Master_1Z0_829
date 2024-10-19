package var;

import java.util.ArrayList;

/**
 * @author Rodney Taylor
 */
public class Main {
    public static void main(String[] args) {
        var b = 1;
        
        var values = new ArrayList<String>();
        values.forEach((var k) -> System.out.println(k.length()));
        
        var a = 1;
        var c = 2;
        //var i = 10, j = 9; // CE: var not allowed in compound declaration
    }
}
