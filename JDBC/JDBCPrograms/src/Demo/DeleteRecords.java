package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteRecords {
	public static void main(String[] args) {
		try {
			Connection con = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Drive Class Loaded");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "190031187");
			System.out.println("Connection Established");
			
			Statement stmt = con.createStatement();
			
			int eid;
			Scanner s=new Scanner(System.in);
			System.out.println("Enter Employee Id which you want to delete:");
			eid=s.nextInt();
			s.close();
			String qry= "delete from employee where empid="+eid+"";
			int n = stmt.executeUpdate(qry);
			System.out.println(n+" Record(s) are deleted");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
