package datatypes;

/**
 * @author Rodney Taylor (u228616)
 */
public class Main {
    public static void main(String[] args) {
        byte i = 0x007F; // As long as it fits (-32768, 32767), integer literal assignment to short is ok
        short s = 0x7FFF; // As long as it fits (-32768, 32767), integer literal assignment to short is ok
        char c = (char)s; // CE without casting as char has bigger positive value range (0-65535) than byte (-128, 127)
        byte b = (byte)c; // CE without casting as char has bigger positive value range (0-65535) than byte (-128, 127)
        short ss = (short)c; // CE without casting as char has bigger positive value range (0-65535) than short (-32768, 32767)
        short sss = b;
        int ii = b;
        int iii = s;
        int iiii = c;

        float f = 1234567891; // Integer literal will always fit into float primitive
        double d = 1234567891; // Integer literal will always fit into float primitive

        // With wrapper
        Character cw = 65535; // As long as it fits, integer literal assignment to Byte is ok
        Byte bw = 127; // As long as it fits (-128, 127), integer literal assignment to Byte is ok
        Short sw = 32767; // As long as it fits (-32768, 32767), integer literal assignment to Short is ok
        Long lw = 12345678910L; // CE without L or casting. Cannot use integer literal for wrapper Long.
        Float fw = 1234567891F; // CE without F or casting. Cannot use integer literal for wrapper Float.
        Double dw = 12345678910D; // CE without D  or casting. Cannot use integer literal for wrapper Double.

        
        if (true && false || false) {
            System.out.println("section 1");
        }
        
        if (true || true && false) {
            System.out.println("section 2");
        }
    }
    
}

