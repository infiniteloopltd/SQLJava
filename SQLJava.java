import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// javac SQLJava.java
// java -cp ".;sqljdbc42.jar" SQLJava

public class SQLJava {
    public static void main(String[] args) {
		String dsn = "jdbc:sqlserver://localhost;databaseName=Library;integratedsecurity=true";
        try {
            Connection conn = DriverManager.getConnection(dsn);
            Statement stmt = conn.createStatement();      
            ResultSet result = stmt.executeQuery("select * from students");
            while (result.next()) {
                String firstname = result.getString("Firstname");
                String surname = result.getString("Surname");              
                System.out.println(firstname + "  " + surname);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
