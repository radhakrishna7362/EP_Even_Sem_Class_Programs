package Demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class MYSQLDBConnection {
	public static void main(String[] args) {
		try {
			Connection con = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drive Class Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "190031187");
			System.out.println("Connection Established");
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
