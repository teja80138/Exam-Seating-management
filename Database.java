import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Database
{

    static String username;
    
    public static void main(String[] args) 
    {
        System.out.println(username);
        String url = "jdbc:mysql://localhost:3305/examseating";
        String username = "root";
        String password = "Manu@1315";
        System.out.println("Connecting to the database...");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected successfully!");
        } catch (SQLException e) {
            System.out.println("Unable to connect to the database.");
            e.printStackTrace();
        }
    }
}