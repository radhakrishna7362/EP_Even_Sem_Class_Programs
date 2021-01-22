package Demo;
import java.sql.*;

public class OracleDBConnection {
	public static void main(String[] args) {
		try {
			Connection con = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Drive Class Loaded");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "190031187");
			System.out.println("Connection Established");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}