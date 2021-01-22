package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Drive Class Loaded");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "190031187");
			System.out.println("Connection Established");
			
			Statement stmt = con.createStatement();
			
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
			String qry= "insert into employee values("+eid+", '"+ename+"', "+salary+", '"+gender+"')";
			stmt.executeUpdate(qry);
			System.out.println("Record is Inserted");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
