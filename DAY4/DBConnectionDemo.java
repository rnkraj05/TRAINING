import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionDemo {
    public static void main(String[] args) {
        try {
            // Step 1: Load MySQL Driver (optional in latest versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3386/studentdb" , "root" , "password");
            
            System.out.println("Database connected successfully");

            // Step 3: Close connection
            con.close();
        } catch (Exception e) {
            System.out.println("DB Connection error: " + e.getMessage());
        }
    }
}
