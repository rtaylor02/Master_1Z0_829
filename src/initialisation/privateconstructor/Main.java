package initialisation.privateconstructor;

public class Main {}

class A {
    private A() {}
    
    class SubA extends A {}
    static class StaticSubA extends A {}
}

// class B extends A {} // CE - Class A is 'almost' final. Can only be extended by inner class

