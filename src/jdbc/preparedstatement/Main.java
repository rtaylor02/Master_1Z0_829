package jdbc.preparedstatement;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String query = "SELECT * FROM public.user;";
        //try (var connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/master_1z0_829");
        //     var preparedStatement = connection.prepareStatement(query);) {
        //
        //}

        // Use executeUpdate() for Create, Update, Delete
        var insertSql = "INSERT INTO zoo.exhibits VALUES (10, 'DEER', 3);";
        var updateSql = "UPDATE zoo.exhibits SET name = '' WHERE name = 'None';";
        var deleteSql = "DELETE FROM zoo.exhibits WHERE id = 10;";
        try (var connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/master_1z0_829", "postgres", "root");
                var preparedStatement = connection.prepareStatement(insertSql)) {
            int result = preparedStatement.executeUpdate();
            System.out.println("Effected table: " + result); // 1
        }

        String select_query = "SELECT * FROM zoo.exhibits;";

    }
}
