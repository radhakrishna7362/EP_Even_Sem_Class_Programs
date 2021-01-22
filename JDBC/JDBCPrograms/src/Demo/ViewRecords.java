package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Drive Class Loaded");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "190031187");
			System.out.println("Connection Established");
			
			Statement stmt = con.createStatement();

//			String qry= "select * from employee";
			String qry= "select empid,ename from employee";
			int count=1;
			ResultSet rs = stmt.executeQuery(qry);

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