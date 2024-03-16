package fileio;

import java.io.*;

/**
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //extracted();
        createAFile();
    }

    private static void extracted() throws FileNotFoundException {
        var f = new File("x");
        var bfr1 = new BufferedReader(new FileReader(f));
        var bfr2 = new BufferedReader(bfr1);
        //var pw = new PrintWriter(new FileReader(f)); // CE: cannot convert a reader to a writer
    }

    private static void createAFile() throws IOException {
        String parent = "C:\\Users\\mailb\\OneDrive\\My Java\\1Z0_829\\prep\\Master_1Z0_829\\src\\fileio\\test";
        String child = "\\test.txt";

        var file = new File(parent, child);
        System.out.println(file);
        boolean done = file.createNewFile();
        System.out.println(done);
    }
}
