package polymorphism.instanceofexamples;

import com.sun.jdi.Value;
import java.time.temporal.ValueRange;

public final class Main {
    public static void main(String[] args) {
        Thing oneThing = new Thing(1, 2);
        Thing aThing = new Thing(1, 2);
        Thing onotherThing = new Thing(1, 3);
        System.out.println("oneThing == aTthing ==> " + oneThing.equals(aThing));
        System.out.println("oneThing == onotherThing ==> " + oneThing.equals(onotherThing));
    }
}

class Thing {
    private int x, y;
    
    Thing(int x, int y) {
        if (isValidInitValues(x, y)) {
            this.x = x;
            this.y = y;
        } else {
            this.x = 1;
            this.y = 1;
        }
    }
    
    Thing() { this(0, 0); }
    
    @Override
    public boolean equals(Object o) {
        return (o instanceof Thing otherThing &&
                otherThing.x == this.x &&
                otherThing.y == this.y);
    }
    
    private boolean isValidInitValues(int x, int y) {
        final ValueRange xLimits = ValueRange.of(1, 100);
        final ValueRange yLimits = ValueRange.of(1, 100);
        return xLimits.isValidIntValue(x) && yLimits.isValidIntValue(y);
    }
}
