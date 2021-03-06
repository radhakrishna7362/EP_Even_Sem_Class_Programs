package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class UpdateRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drive Class Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "190031187");
			System.out.println("Connection Established");

			int eid;
			String ename=null;
			Scanner s=new Scanner(System.in);
			System.out.println("Enter Employee Id for which you want to change the name and salary:");
			eid=s.nextInt();
			System.out.println("Enter Employee Name:");
			ename=s.next();
			s.close();
			
			PreparedStatement pstmt = con.prepareStatement("update employee set ename=? where empid=?");
			pstmt.setString(1, ename);
			pstmt.setInt(2, eid);
			pstmt.execute();
			System.out.println("Record(s) are updated");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
