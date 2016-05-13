
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class DataBase {
    public Connection dataBase(){
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
String USER1 = "AYE";
String PASS1 = "aye";

 Connection connection = null;
 try {
 
 Class.forName("oracle.jdbc.driver.OracleDriver");
 
 } catch (ClassNotFoundException e) {
 e.printStackTrace();
 }
 
 try {
 
 connection = DriverManager.getConnection(URL, USER1, PASS1);
 } catch (SQLException e) {
 
 e.printStackTrace();
 }
 return connection;
    }
}
