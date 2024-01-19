package classdefandreachability;

/**
 * @author Rodney Taylor (u228616)
 */
public class Outer {
    private int outerX;
    
    class Nester1 {
        private int nester1X;
        
        void show() {
            outerX = 3;
            nester1X = 4;
            
            Outer outer = new Outer();
            Nester1 nester1 = new Nester1();
            Nester2 nester2 = new Nester2();
            outer.outerX = 1;
            nester1.nester1X = 1;
            nester2.nester2X = 1;
        }
        
        private void otherMethodNester1() {
            otherMethodOuter();
        }
    }
    
    class Nester2 {
        
        private int nester2X;
        
        void show() {
            outerX = 2;
            nester2X = 1;
            
            Outer outer = new Outer();
            Nester1 nester1 = new Nester1();
            Nester2 nester2 = new Nester2();
            outer.outerX = 1;
            nester1.nester1X = 1;
            nester2.nester2X = 1;
        }
        
        private void otherMethodNester2() {
            otherMethodOuter();
        }
    }
    
    void show() {
        //nester1X = 1; // CE, not in the scope
        //nester2X = 1; // CE, not in the scope
        outerX = 5;
        
        Outer outer = new Outer();
        Nester1 nester1 = new Nester1();
        Nester2 nester2 = new Nester2();
        outer.outerX = 1;
        nester1.nester1X = 1;
        nester2.nester2X = 1;
    }
    
    private void otherMethodOuter() {
        //otherMethodNester1(); // CE, not in scope
    }
}
