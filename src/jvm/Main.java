package jvm;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //stackOverflowErrorSample();
        outOfMemoryError();
    }

    public Main() {
        new Main();
    }

    private static void stackOverflowErrorSample() {
        Main main = new Main();
    }

    private static void outOfMemoryError() {
        Random random = new Random();
        while (true) {
            String s = new String(Integer.valueOf(random.nextInt()).toString());
            System.out.printf("Number: %s%n", s);
        }
    }
}
