package exceptionhandling;

import java.io.IOError;
import java.io.IOException;

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
