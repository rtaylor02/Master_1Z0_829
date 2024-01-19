package controlflow.trycatch;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Rodney Taylor (u228616)
 */
public class Main {
    public static void main(String[] args) {

    }
    
    void io() throws IOException, SQLException {
        try {
            if (Math.random() > 0.5) throw new IOException();
            if (Math.random() > 0.5) throw new SQLException();
        } catch (IOException | SQLException e) {
            throw e;
        }
    }
}