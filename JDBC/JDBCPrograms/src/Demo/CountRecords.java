package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CountRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Drive Class Loaded");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "190031187");
			System.out.println("Connection Established");
			
			PreparedStatement pstmt = con.prepareStatement("select count(*) as total from emp");
			ResultSet c=pstmt.executeQuery();
			while(c.next()) {
				System.out.println("No Of Records = "+c.getInt("total"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
