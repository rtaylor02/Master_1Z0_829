package datatypes;

/**
 * @author Rodney Taylor (u228616)
 */
public class Main {
    public static void main(String[] args) {
        
        
        if (true && false || false) {
            System.out.println("section 1");
        }
        
        if (true || true && false) {
            System.out.println("section 2");
        }
    }
    
}

