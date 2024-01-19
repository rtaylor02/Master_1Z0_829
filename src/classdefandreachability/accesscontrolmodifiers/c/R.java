package classdefandreachability.accesscontrolmodifiers.c;

import classdefandreachability.accesscontrolmodifiers.a.P;
import classdefandreachability.accesscontrolmodifiers.b.Q;

/**
 * @author Rodney Taylor (u228616)
 */
public class R {
    void show(P p) {
        //System.out.println(P.privateStaticName); // CE
        //System.out.println(P.defaultStaticName); // CE - different package
        //System.out.println(P.protectedStaticName); // CE - Type R is not a subclass of P
        System.out.println(P.publicStaticName);
        
        //System.out.println(p.privateName); // CE
        //System.out.println(p.defaultName); //
        //System.out.println(p.protectedName); // CE - Type R is not a subclass of P
        System.out.println(p.publicName);
    }
    void show(Q q) {
        //System.out.println(Q.privateStaticName); // CE
        //System.out.println(Q.defaultStaticName); // CE - different package
        //System.out.println(Q.protectedStaticName); // CE - Type R is not a subclass of P
        System.out.println(Q.publicStaticName);
        
        //System.out.println(q.privateName); // CE
        //System.out.println(q.defaultName); // CE - different package
        //System.out.println(q.protectedName); // CE - q is of type Q and type R has not relation to P
        System.out.println(q.publicName);
    }
}
