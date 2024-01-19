package classdefandreachability.accesscontrolmodifiers.b;

import classdefandreachability.accesscontrolmodifiers.a.P;

/**
 * @author Rodney Taylor (u228616)
 */
public class Q extends P {
    void show(P p) {
        //System.out.println(P.privateStaticName); // CE
        //System.out.println(P.defaultStaticName); // CE - different package
        System.out.println(P.protectedStaticName); // Type Q is subclass of P, so it's accessible from static context
        System.out.println(P.publicStaticName);
        
        //System.out.println(p.privateName); // CE
        //System.out.println(p.defaultName); //
        //System.out.println(p.protectedName); // CE p is of type P. It is type Q that is a subclass of P!
        System.out.println(p.publicName);
    }
    
    void show(Q q) {
        //System.out.println(Q.privateStaticName); // CE
        //System.out.println(Q.defaultStaticName); // CE - different package
        System.out.println(Q.protectedStaticName); // Type Q is subclass of P, so it's accessible from static context
        System.out.println(Q.publicStaticName);
        
        //System.out.println(q.privateName); // CE
        //System.out.println(q.defaultName); // CE - different package
        System.out.println(q.protectedName); // q is an instance of type Q which is a subclass of P
        System.out.println(q.publicName);
    }
    
}
