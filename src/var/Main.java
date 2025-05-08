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

        var x = args.length > 1 ? "99" : 99; // OK. x is inferred to be any common type between Integer and String, i.e. Object
        System.out.println(x.getClass().getName());
        x = args.length < 1 ? "99" : 99; // because x is a be common type between Integer and String, this is not CE.
        System.out.println(x.getClass().getName());
    }
}
