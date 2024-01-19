package fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * @author Rodney Taylor (u228616)
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        var f = new File("x");
        var bfr1 = new BufferedReader(new FileReader(f));
        var bfr2 = new BufferedReader(bfr1);
        //var pw = new PrintWriter(new FileReader(f)); // CE: cannot convert a reader to a writer
    }
}
