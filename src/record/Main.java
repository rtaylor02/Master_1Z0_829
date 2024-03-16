package record;

/**
 * @author Rodney Taylor (u228616)
 */
public class Main {
    public static void main(String[] args) {
        Named n1 = new Named(new StringBuilder("Fred"));
        Named n2 = new Named(new StringBuilder("Fred"));
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
        System.out.println("n1.equals(n2) =  " + n1.equals(n2));
        n2.name().append("dy"); // Does not do anything as String is immutable, i.e. needs re-assignment to take effect
        System.out.println("n2 ==> " + n2);
        System.out.println(n2.name());
    }
    
    record Named(StringBuilder name) {
        public StringBuilder name() {
            return new StringBuilder(name + "la");
        }
    }
}
interface FirstNameable { String first(); String other(); }
interface LastNameable { String last(); }
record NamePair(String first, String last) implements FirstNameable, LastNameable {
    @Override
    public String other() {
        return null;
    }

}
