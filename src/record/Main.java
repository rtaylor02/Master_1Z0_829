package record;

/**
 * @author Rodney Taylor (u228616)
 */
public class Main {
    public static void main(String[] args) {
        Named n1 = new Named(new StringBuilder("Fred"));
        Named n2 = new Named(new StringBuilder("Fred"));
        System.out.println(n1.equals(n2));
        n2.name().append("dy");
        System.out.println(n2);
    }
    
    record Named(StringBuilder name) {}
}
interface FirstNameable { String first(); String other(); }
interface LastNameable { String last(); }
record NamePair(String first, String last) implements FirstNameable, LastNameable {
    @Override
    public String other() {
        return null;
    }

}
