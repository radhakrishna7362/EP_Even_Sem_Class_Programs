package CallableStatementDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Drive Class Loaded");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "190031187");
			System.out.println("Connection Established");
			
//			CallableStatement cstmt= con.prepareCall("{call insertrecord(?,?,?)}");
//			cstmt.setInt(1, 3);
//			cstmt.setString(2, "Prasad");
//			cstmt.setString(3, "male");
//			System.out.println("Record is inserted");

//			CallableStatement cstmt= con.prepareCall("{call empcount(?)}");
//			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
//			cstmt.execute();
//			System.out.println("Total Count= "+cstmt.getInt(1));
			
//			CallableStatement cstmt= con.prepareCall("{call displayname(?,?)}");
//			cstmt.setInt(1, 1);
//			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
//			cstmt.execute();
//			System.out.println("Name= "+cstmt.getString(2));
			
//			CallableStatement cstmt= con.prepareCall("{call updaterecord(?,?)}");
//			cstmt.setInt(1, 1);
//			cstmt.setString(2, "krishna");
//			cstmt.execute();
//			System.out.println("Record is Updated");
			
			CallableStatement cstmt= con.prepareCall("{call deleterecord(?)}");
			cstmt.setInt(1, 2);
			cstmt.execute();
			System.out.println("Record is Deleted");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
