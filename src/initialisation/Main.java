package initialisation;

public class Main {
    {
        System.out.println("Streams: instance block 1");
        //System.out.println(instanceString); // CE: forward referencing
        instanceMethod();
    }
    public static void main(String[] args) {
        System.out.println("inside main()");

        finalVarCheck();
        
        //Streams main = new Streams();
        B b = new B();
    }

    private static void finalVarCheck() {
        final boolean bool = true;
        int someNumber;
        if (bool) {
            someNumber = 1;
            int i = someNumber + 3;
        }
        System.out.println(someNumber); // CE if bool is not final
    }

    static {
        System.out.println("Streams: static block 1");
        //System.out.println(staticString); // CE: forward referencing
        //instanceMethod(); // CE: non-static method cannot be referenced from static context
    }
    
    {
        System.out.println("Streams: instance block 2");
    }
    
    static {
        System.out.println("Streams: static block 2");
        staticMethod();
    }
    
    public Main() {
        System.out.println("Streams: inside constructor");
    }
    String instanceString = "Streams: instance String";
    static String staticString = "Streams: static String";
    public void instanceMethod() {
        System.out.println("Streams: instance method");
    }
    public static void staticMethod() {
        System.out.println("Streams: static method");
    }
}

class A {
    {
        System.out.println("A: instance block 1");
        //System.out.println(instanceString); // CE: forward referencing
        instanceMethod();
    }
    
    static {
        System.out.println("A: static block 1");
        //System.out.println(staticString); // CE: forward referencing
        //instanceMethod(); // CE: non-static method cannot be referenced from static context
    }
    
    {
        System.out.println("A: instance block 2");
    }
    
    static {
        System.out.println("A: static block 2");
        staticMethod();
    }
    
    public A() {
        System.out.println("A: inside constructor");
    }
    
    String instanceString = "A: instance String";
    static String staticString = "A: static String";
    public void instanceMethod() {
        System.out.println("A: instance method");
    }
    public static void staticMethod() {
        System.out.println("A: static method");
    }
}

class B extends A {
    {
        System.out.println("B: instance block 1");
        //System.out.println(instanceString); // CE: forward referencing - unqualified
        System.out.println(this.instanceString); // OK: forward referencing - qualified
        instanceMethod();
    }
    
    static {
        System.out.println("B: static block 1");
        //System.out.println(staticString); // CE: forward referencing - unqualified
        System.out.println(B.staticString); // OK: forward referencing - qualified
        //instanceMethod(); // CE: non-static method cannot be referenced from static context
    }
    
    {
        System.out.println("B: instance block 2");
    }
    
    static {
        System.out.println("B: static block 2");
        staticMethod();
    }
    
    public B() {
        System.out.println("B: inside constructor");
    }
    
    String instanceString = "B: instance String";
    static String staticString = "B: static String";
    public void instanceMethod() {
        System.out.println("B: instance method");
    }
    public static void staticMethod() {
        System.out.println("B: static method");
    }
}
