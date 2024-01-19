package polymorphism.instanceofexamples.scopeofinstanceof;

/**
 * @author Rodney Taylor (u228616)
 */
public class Main {
    public static void main(String[] args) {
        Object o = "";
        
        if (o instanceof String s) {
            System.out.println(s);
        } else {
            //System.out.println(s); // CE
        }
        
        if (!(o instanceof String s)) {
            //System.out.println(s); // CE
        } else {
            System.out.println(s);
        }
        
        if (o instanceof String s || true) {
            //System.out.println(s); // CE
        } else {
            //System.out.println(s); // CE
        }
        
        if ((!(o instanceof String s)) || s.length() >= 0) {
            //System.out.println(s); // CE
        } else {
            System.out.println(s);
        }
        
        if ((!(o instanceof String s)) || s.length() >= 0) {
            //System.out.println(s); // CE
        }
    }
}
