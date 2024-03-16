package overloading;

public class Main {
    public static void main(String[] args) {

        probe(Integer.valueOf(3));
    }

    // 3rd preference if probe(Integer) and probe(long) not available
    private static void probe(int... x) {
        System.out.println("in varargs");
    }

    // 2nd preference if probe(Integer) not available
    private static void probe(long x) {
        System.out.println("in long");
    }

    // 1st preference
    private static void probe(Integer x) {
        System.out.println("in Integer");
    }

    // Never chosen
    private static void probe(Long x) {
        System.out.println("in Long");
    }
}
