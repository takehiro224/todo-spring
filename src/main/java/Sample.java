import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;

public class Sample {

    @Value("${spring.datasource.url}")
    static private String JDBCURL;

    private static final String jdbcUrl = "jdbc:postgresql://postgresql-container:5432/todo_db";
    private static final String username = "root";
    private static final String password = "root";
    public static void main(String[] args) {
        String SQL = "SELECT * FROM users";
        executeSelectQuery(SQL);
        System.out.println(JDBCURL);
    }

    private static void executeSelectQuery(String sql) {
        
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}