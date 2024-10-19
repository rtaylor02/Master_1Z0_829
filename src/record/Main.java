package record;

/**
 * @author Rodney Taylor (u228616)
 */
public class Main {
    public static void main(String[] args) {
        //method1();

        A a = new A(20);
        System.out.println("a.b = " + a.b()); // 120, NOT 20

        B b = new B(20, 30);
        System.out.println("b.b = " + b.b()); // 50, NOT 10050
    }

    private static void method1() {
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


/**
 * Demo on overloading long constructor for transformation of record components.
 * @param b
 */
record A(int b) {
    // Modify b via long constructor - this is the only place where this.<field> is allowed!
    public A(int b) {
        this.b = b + 100;
    }

    public A(int a, int b) {
        this(a + b);
    }
}

/**
 * Demo on overloading long constructor for transformation of record components.
 * @param b
 */
record B(int b) {
    private static String name = "B";
    //private int bb = 3; // CE - instance field (other than defined at declaration) is NOT allowed

    // Define new constructor - you MUST call cannonical constructor on 1st line
    public B(int a, int b) {
        //b = a + b; // CE - call to this() must be the 1st line!
        this(a + b);
        b = b + 10000; // OK but simply ignored!
        //this.b = 12; // CE - Any ref to 'this' is not allowed
    }
}
