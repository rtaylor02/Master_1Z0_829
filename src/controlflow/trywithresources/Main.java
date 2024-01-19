package controlflow.trywithresources;

import java.sql.SQLException;

/**
 * @author Rodney Taylor (u228616)
 */
public class Main {
    public static void main(String[] args) {
        //new Streams().multiResources();
        new Main().suppressedExceptions();
    }
    
    void multiResources() {
        System.out.println("starting");
        MyResources mr0 = new MyResources();
        try (MyResources mr1 = new MyResources();
             mr0;
             MyResources mr2 = new MyResources()) {
            System.out.println("using resources");
        } catch (SQLException e) {
            System.out.println("Problem closing");
            System.out.println(e.getMessage());
        }
        //mr0 = null; // CE, mr0 must be final or effectively final since it's used as resources in try-with-resources
        System.out.println("ending");
    }
    
    void suppressedExceptions() {
        System.out.println("starting");
        MyResources mr0 = new MyResources();
        try (MyResources mr1 = new MyResources();
             mr0;
             MyResources mr2 = new MyResources()) {
            System.out.println("using resources");
        } catch (Throwable t) {
            System.out.println("primary problem: " + t.getMessage());
            for (Throwable others : t.getSuppressed()) {
                System.out.println("suppressed: " + others.getMessage());
            }
        }
        //mr0 = null; // CE, mr0 must be final or effectively final since it's used as resources in try-with-resources
        System.out.println("ending");
    }
    
    
}


class MyResources implements AutoCloseable {
    private static int nextId = 0;
    private final int id = nextId++;
    
    {
        System.out.println("initialising id: " + id);
    }
    
    @Override
    public void close() throws SQLException {
        if (Math.random() > 0.5) {
            System.out.println("--Failing to close--id: " + id);
            throw new SQLException("Closing failed for id: " + id);
        }
        System.out.println("closing id: " + id);
    }
}
