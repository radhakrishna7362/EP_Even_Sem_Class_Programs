package Demo;

import java.sql.*;

public class ResultSetMetaDataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Drive Class Loaded");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "190031187");
			System.out.println("Connection Established");
			
			ResultSet rs=con.createStatement().executeQuery("select * from employee");
			ResultSetMetaData rsmd=rs.getMetaData();
			int count=rsmd.getColumnCount();
			System.out.println("Number of Columns= "+count);
			for(int i=1;i<=count;i++) {
				System.out.println(rsmd.getColumnClassName(i));
				System.out.println(rsmd.getColumnDisplaySize(i));
				System.out.println(rsmd.getColumnName(i));
				System.out.println(rsmd.getColumnLabel(i));
				System.out.println(rsmd.getColumnType(i));
				System.out.println(rsmd.getColumnTypeName(i));
				System.out.println(rsmd.getPrecision(i));
				System.out.println(rsmd.getScale(i)+"\n");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
