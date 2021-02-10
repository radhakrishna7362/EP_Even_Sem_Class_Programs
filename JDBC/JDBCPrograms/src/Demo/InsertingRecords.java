package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertingRecords {

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
			System.out.println("Enter no of records that you want to insert?");
			int n=s.nextInt();
			int i=0;
			while(i<n) {
				System.out.println("-------------------");
				System.out.println("Enter Employee-"+(i+1)+"Details");
				System.out.println("Enter Employee Id:");
				eid=s.nextInt();
				System.out.println("Enter Employee Name:");
				ename=s.next();
				System.out.println("Enter Employee Salary:");
				salary=s.nextDouble();
				System.out.println("Enter Employee Gender:");
				gender=s.next();
				String qry= "insert into employee values("+eid+", '"+ename+"', "+salary+", '"+gender+"')";
				stmt.executeUpdate(qry);
				System.out.println("Record is Inserted");
				System.out.println("-------------------");
				i++;
			}
			s.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}