package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecords {
	public static void main(String[] args) {
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
			Scanner s=new Scanner(System.in);
			System.out.println("Enter Employee Id for which you want to change the name and salary:");
			eid=s.nextInt();
			System.out.println("Enter Employee Name:");
			ename=s.next();
			System.out.println("Enter Employee Salary:");
			salary=s.nextDouble();
			s.close();
			String qry= "update employee set ename='"+ename+"' , salary="+salary+" where empid= "+eid+"";
			int n = stmt.executeUpdate(qry);
			System.out.println(n+" Record(s) are updated");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
