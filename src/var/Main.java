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

        System.out.println("======= In combination with Integer methods =======");
        var aa = Integer.parseInt("11");
        var bb = Integer.valueOf("c", 16);
        var cc = 0Xa;
        System.out.println("cc: " + cc);
        System.out.println(bb);
        System.out.println(Integer.max(aa, bb));

        /*
        + (plus) operator:
        - if any operand is a String, then L-value is a String
        - with char, byte, short, int, then L-value is int, unless cast to any of the 4
        - with long, float, double, then L-value is the biggest
         */
        var sum = (byte) 7 + (short)10 + 20 + 0Xff + 34L + 'A' + 2.5 + 0b10101;
        System.out.println(sum); // sum is of type double
    }
}
