package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class ViewRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drive Class Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "190031187");
			System.out.println("Connection Established");

//			String qry= "select * from employee";
			String qry= "select empid,ename from employee";
			PreparedStatement pstmt = con.prepareStatement(qry);
			int count=1;
			ResultSet rs = pstmt.executeQuery();

//			System.out.println("------------------");
//			while(rs.next()) {
//				System.out.println("Employee Record-"+count);
//				System.out.println("Employee Id:"+ rs.getInt("empid"));
//				System.out.println("Employee Name:"+ rs.getString("ename"));
//				System.out.println("Employee Salary:"+ rs.getDouble("salary"));
//				System.out.println("Employee Gender:"+ rs.getString("gender"));
//				count+=1;
//				System.out.println("------------------");
//			}
			
			System.out.println("------------------");
			while(rs.next()) {
				System.out.println("Employee Record-"+count);
				System.out.println("Employee Id:"+ rs.getInt("empid"));
				System.out.println("Employee Name:"+ rs.getString("ename"));
				count+=1;
				System.out.println("------------------");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
