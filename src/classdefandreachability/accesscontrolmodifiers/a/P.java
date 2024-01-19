package classdefandreachability.accesscontrolmodifiers.a;

import classdefandreachability.accesscontrolmodifiers.b.Q;

/**
 * @author Rodney Taylor (u228616)
 */
public class P {
    // Static fields
    private static String privateStaticName = "private static"; // accessible inside P including nested and inner class
    static String defaultStaticName = "default static"; // accessible from the same package
    protected static String protectedStaticName = "protected static"; // accessible from the same package & subclass from within static context
    public static String publicStaticName = "public static"; // accessible from the same module
    
    // Instance fields
    private String privateName = "private"; // accessible inside P including nested and inner class
    String defaultName = "default"; // accessible from the same package
    protected String protectedName = "protected"; // accessible from the same package & subclass reference
    public String publicName = "public"; // accessible from the same module
    
    static class NestedClass {
        // Static class can access private static of enclosing class, but NOT non-static members.
        String enclosingClassPrivateStaticName = privateStaticName;
        //String enclosingClassPrivateName = privateName; // CE
        
        void show(P p) {
            System.out.println(P.privateStaticName); // CE
            System.out.println(P.defaultStaticName);
            System.out.println(P.protectedStaticName);
            System.out.println(P.publicStaticName);
            
            System.out.println(p.privateName); // CE
            System.out.println(p.defaultName);
            System.out.println(p.protectedName);
            System.out.println(p.publicName);
        }
        
        void show(Qq qq) {
            //System.out.println(Qq.privateStaticName); // CE
            System.out.println(Qq.defaultStaticName);
            System.out.println(Qq.protectedStaticName);
            System.out.println(Qq.publicStaticName);
            
            //System.out.println(qq.privateName); // CE
            System.out.println(qq.defaultName);
            System.out.println(qq.protectedName);
            System.out.println(qq.publicName);
        }
    }
    
    class InnerClass {
        // Inner class can access static and non-static private members of enclosing class.
        String enclosingClassPrivateStaticName = privateStaticName;
        String enclosingClassPrivateName = privateName;
        
        void show(P p) {
            System.out.println(P.privateStaticName); // CE
            System.out.println(P.defaultStaticName);
            System.out.println(P.protectedStaticName);
            System.out.println(P.publicStaticName);
            
            System.out.println(p.privateName); // CE
            System.out.println(p.defaultName);
            System.out.println(p.protectedName);
            System.out.println(p.publicName);
        }
        
        void show(Qq qq) {
            //System.out.println(Qq.privateStaticName); // CE
            System.out.println(Qq.defaultStaticName);
            System.out.println(Qq.protectedStaticName);
            System.out.println(Qq.publicStaticName);
            
            //System.out.println(qq.privateName); // CE
            System.out.println(qq.defaultName);
            System.out.println(qq.protectedName);
            System.out.println(qq.publicName);
        }
    }
}

class Qq extends P {
    void show(P p) {
        //System.out.println(P.privateStaticName); // CE
        System.out.println(P.defaultStaticName);
        System.out.println(P.protectedStaticName);
        System.out.println(P.publicStaticName);
        
        //System.out.println(p.privateName); // CE
        System.out.println(p.defaultName);
        System.out.println(p.protectedName);
        System.out.println(p.publicName);
    }
    
    void show(Qq q) {
        //System.out.println(Qq.privateStaticName); // CE
        System.out.println(Qq.defaultStaticName);
        System.out.println(Qq.protectedStaticName);
        System.out.println(Qq.publicStaticName);
        
        //System.out.println(q.privateName); // CE
        System.out.println(q.defaultName);
        System.out.println(q.protectedName);
        System.out.println(q.publicName);
    }
}

