package controlflow;

/**
 * @author Rodney Taylor (u228616)
 */
public class Main {
    public static void main(String[] args) {
        mylabel:
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        
        mylabel: // it's ok to have the same label name as its scope is only within 1 statement that follows it.
        for (int i = 0; i < 5; i++) {
            if (i == 3) break mylabel;
            System.out.println(i);
        }
        
        int x = 97;
        switch (x) {
            case 97 -> System.out.println("97");
            case 98 -> {
                break;
            }
        }
    }
}
