package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateTable {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drive Class Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "190031187");
			System.out.println("Connection Established");
			
			PreparedStatement pstmt = con.prepareStatement("create table employee(empid integer primary key, ename varchar(30) not null, salary decimal(10,4) not null, gender varchar(10))");
			pstmt.execute();
			System.out.println("Table Created");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
