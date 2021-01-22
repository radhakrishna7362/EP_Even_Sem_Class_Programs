package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drive Class Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "190031187");
			System.out.println("Connection Established");
			
			int eid;
			Scanner s=new Scanner(System.in);
			System.out.println("Enter Employee Id which you want to delete:");
			eid=s.nextInt();
			s.close();
			
			PreparedStatement pstmt = con.prepareStatement("delete from employee where empid=?");
			pstmt.setInt(1, eid);
			pstmt.execute();
			System.out.println("Record(s) are deleted");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
