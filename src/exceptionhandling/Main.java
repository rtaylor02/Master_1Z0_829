package exceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Rodney Taylor (u228616)
 */
public class Main {
    public static void main(String[] args) {
        trial1(); // Order in closing: 3, 2, 1. Followed by message in catch block
    }
    
    private static void trial1() {
        Device d1 = new Device(1);
        
        try (d1;
             Device d2 = new Device(2);
             Device d3 = new Device(3)) {
            d2.write();
            d1.close(); // Never gets executed - not CE though
        } catch (Exception e) {
            System.out.println("Got exception: " + e.getMessage());
        }
    }
}

class Device implements AutoCloseable {
    boolean open; // default value = false
    int index; // default value = 0
    
    public Device(int index) {
        this.index = index;
        this.open = true;
    }
    
    public void write() throws IOException {
        throw new RuntimeException("Cannot write!");
    }
    
    @Override
    public void close() throws Exception {
        open = false;
        System.out.println("Device closed: " + index);
    }
}

class RethrowAtCatch {
    public static void main(String[] args) throws Exception {
        main();
    }

    // main() must declare all possible rethrown exceptions, or one common ancestor of them all.
    private static void main() throws Exception {
        try {
            if (Math.random() > 0.5) throw new FileNotFoundException();
            if (Math.random() > 0.5) throw new SQLException();
        } catch (FileNotFoundException | SQLException e) {
            throw e;
        }
    }
}

class UnhandledMultiThrow {
    public static void main(String[] args) throws Exception {
        try (A a1 = new A();
            A a2 = new A();) {
        } catch (FileNotFoundException f) {
            System.out.println("catching from " + f.getMessage());
        } finally {
            System.out.println("finally...");
        }
        System.out.println("ending");
    }

    private static class A implements AutoCloseable {
        private static int nextId = 0;
        private final int id = ++nextId;

        @Override
        public void close() throws FileNotFoundException, SQLException{
            String msg = "A.id = " + id;
            if (id == 1) {
                System.out.println("closing 1");
                throw new FileNotFoundException(msg);
            } else if (id == 2) {
                System.out.println("closing 2");
                throw  new SQLException(msg);
            }

        }
    }
}
