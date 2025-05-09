package operators;

public class Main {
    public static void main(String[] args) {
        long l = 10L;
        float f = 2.2F;
        float fl = f + l;
        int ii = 2;
        long iil = ii + l; // operations among long, float, double result in the widest type, in this case long.
        System.out.println();

        char cc = 'a';
        byte bb = 10;
        int cb = cc + bb; // char, byte, short, int operation result in int
    }
}
