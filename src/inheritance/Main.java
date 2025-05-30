package inheritance;

/**
 * This code demonstrates:
 * - only protected and public members are inherited by a subclass of a class
 * - constructors and static initialisers are not members and therefore not inherited
 * - polymorphism only applies to instance method:
 */
public class Main {
    public static void main(String[] args) {
        A a = new B(); // Polymorphism applies here (NOTE: only to instance methods)
        System.out.println(a.getaNumber()); // 100
        System.out.println(a.anotherNumber); // 111 - REMEMBER: polymorphism only applies to instance methods. Thus, it's A's member that is accessed.
        System.out.println(a.staticNumber); // 11

        B b = new B();
        System.out.println(b.anotherNumber); // 222
        System.out.println(b.staticNumber); // 22
        System.out.println(b.getaNumber()); // 100
        b.incrementNumber();
        System.out.println(b.getaNumber()); // 101
        System.out.println("");
        b.printMe(); // static method in class A
        B.printMe(); // static method in class A
        System.out.println("==================");

        Foo foo = new Foo();
        foo.bar(); // print: Foo bar
        foo.printMe(); // print: Foobase\n In static bar

        System.out.println("==================");
        House myHouse = new MyHouse();
        System.out.println(myHouse.getAddress()); // print: 101 Smart Str
    }
}

class A {
    protected int aNumber = 100; // CE in class B.incrementNumber() if private. OK when package-private
    int anotherNumber = 111;
    static int staticNumber = 11;
    int definedInA = 111111; // Inherited

    public int getaNumber() {
        return aNumber;
    }

    public static void printMe() {
        System.out.println("static method in class A");
    }
}

class B extends A {
    private int aNumber = 200;
    int anotherNumber = 222;
    static int staticNumber = 22;
    int copyFromA = definedInA;
    
    public void incrementNumber() {
        aNumber++; // equivalent to this.aNumber++
        super.aNumber++;
    }

    // static method printMe() from A is NOT inherited but since B is A, then by definition, B.printMe() is legit.
}

// Bar, FooBase, and Foo: Taken from Enthuware
interface Bar {
    void bar();
}

// Bar, FooBase, and Foo: Taken from Enthuware
abstract class FooBase {
    // Not visible to Foo and therefore not inherited
    private static void bar() {
        System.out.println("In static bar");
    }

    void printMe() {
        System.out.println("FooBase");
        bar(); // Calling FooBase's static ==> closest.
    }
}

// Bar, FooBase, and Foo: Taken from Enthuware
class Foo extends FooBase implements Bar {
    // bar() does not conflict with bar() of FooBase as it's private
    public void bar() {
        System.out.println("Foo bar");
    }

    // If FooBase's printMe() is overriden, then bar() is calling Foo's bar() ==> closest
    // @Override
    // public void printMe() {
    //     System.out.println("Foo");
    //     bar(); // Calling Foo's instance method bar() ==> closest
    // }
}

// House, Bungalow, MyHouse: taken from Enthuware
interface House {
    public default String getAddress() {
        return "101 Main Str";
    }
}

interface Bungalow extends House {
    // @Override // Not compulsory
    public default String getAddress() {
        return "101 Smart Str";
    }
}

class MyHouse implements House, Bungalow {
    // MyHouse will get the implementation of Bungalow's getAddress() ==> closest (by inheritance)
}
