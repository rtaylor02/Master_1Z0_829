package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * To run, you need to specify the class path in java command:
 * $ java -cp "../../lib/hsqldb.jar" Main.java
 */
public class Main {
    public static void main(String[] args) {
        //getConnection();
        getConnectionWithPostgresql();
    }

    private static void getConnection() {
        try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:zoo")) {
            System.out.println(connection);
        } catch (SQLException e) {
            System.out.println("ERROR: \nSQLException - " + e.getMessage());
        }
    }

    /**
     * SQLException - FATAL: password authentication failed for user "username"
     */
    private static void getConnectionWithPostgresql() {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ocp-book",
                "username", "password")) {
            System.out.println(connection);
        } catch (SQLException e) {
            System.out.println("ERROR: \nSQLException - " + e.getMessage());
        }
    }


}
