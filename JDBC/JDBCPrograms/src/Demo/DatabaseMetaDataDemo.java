package Demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DatabaseMetaDataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Drive Class Loaded");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "190031187");
			System.out.println("Connection Established");
			
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDatabaseProductVersion());
			System.out.println(dbmd.getUserName());
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getDriverMinorVersion());
			System.out.println(dbmd.getDriverMajorVersion());
			System.out.println(dbmd.getJDBCMinorVersion());
			System.out.println(dbmd.getJDBCMajorVersion());
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
