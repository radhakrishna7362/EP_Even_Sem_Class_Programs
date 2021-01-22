package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AlterTable {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drive Class Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "190031187");
			System.out.println("Connection Established");
			
			PreparedStatement pstmt = con.prepareStatement("alter table employee add (dept varchar(20) default 'CSE')");
			pstmt.execute();
			System.out.println("Table is altered");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}