package library;
import java.sql.*;


public class jdbc {
	public static Connection con;

    public static Connection getConnection() {
	try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost/shantanu_118","root","tiger");
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        
        return con;

    }
}
