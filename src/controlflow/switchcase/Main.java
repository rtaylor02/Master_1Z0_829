package controlflow.switchcase;

public class Main {
    private enum Season {
        SPRING, SUMMER, AUTUMN, WINTER
    }

    public static void main(String[] args) {
        Season currentSeason = Season.SUMMER;

        String seasonDescription = switch (currentSeason) {
            case SPRING, AUTUMN -> "Mild weather"; // No 'yield' needed, directly returning a string
            case SUMMER -> { yield "Hot weather"; } // Only 'yield' in this case block
            case WINTER -> "Cold weather";
        };

        System.out.println("Season description for " + currentSeason + ": " + seasonDescription);
    }
}

class AnotherMain {
    public static void main(String[] args) {
        int a = 3;
        final int b = getInt(); // This is NOT compile-time constant
        final int c = 1; // This is compile-time constant
        int i = b;
        switch (i) {
            case 1 -> System.out.println("1");
            case 2 -> System.out.println("2");
            case 'a' -> System.out.println("'a'");
            //case a -> System.out.println("a"); // CE - constant expression required
            //case b -> System.out.println("b"); // CE - constant expression required
            //case getInt() -> System.out.println("getInt"); // CE - cannot resolve getInt()
        }
    }

    static int getInt() {
        return 1;
    }
}

