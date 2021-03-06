package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertRecords {
	public static void main(String[] args) {
		try {
			Connection con = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drive Class Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "190031187");
			System.out.println("Connection Established");
			
			int eid;
			String ename=null;
			Double salary;
			String gender=null;
			Scanner s=new Scanner(System.in);
			System.out.println("Enter Employee Id:");
			eid=s.nextInt();
			System.out.println("Enter Employee Name:");
			ename=s.next();
			System.out.println("Enter Employee Salary:");
			salary=s.nextDouble();
			System.out.println("Enter Employee Gender:");
			gender=s.next();
			s.close();
			PreparedStatement pstmt= con.prepareStatement("insert into employee values(?,?,?,?)");
			pstmt.setInt(1, eid);
			pstmt.setString(2, ename);
			pstmt.setDouble(3, salary);
			pstmt.setString(4, gender);
			pstmt.execute();
			System.out.println("Record is Inserted");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
