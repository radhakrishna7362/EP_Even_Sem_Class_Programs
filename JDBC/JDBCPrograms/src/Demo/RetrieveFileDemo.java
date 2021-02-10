package Demo;

import java.io.FileWriter;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetrieveFileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con=null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Class Loaded");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","190031187");
			System.out.println("Connection Established");
			PreparedStatement pstmt= con.prepareStatement("select * from test where id=102");
			ResultSet rs=pstmt.executeQuery();
			Clob c = null;
			Reader r=null;
			if(rs.next()) {
				c=rs.getClob(3);
				r=c.getCharacterStream();
			}
			FileWriter fw = new FileWriter("D:\\ep.txt");
			int i;
			while((i=r.read())!=-1) {
				fw.write((char)i);
			}
			fw.close();
			System.out.println("done");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}