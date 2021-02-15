import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewemployees")
public class ViewEmployeeServlet extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		try {
			Connection con=null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","190031187");
			
			PreparedStatement pstmt=con.prepareStatement("select * from employee");
			
			ResultSet rs=pstmt.executeQuery();
			out.println("<h2 align='center'>View Employee Records</h2>");
			
			out.println("<table align=center border='2'>");
			out.println("<tr bgcolor='lightblue'>");
			out.println("<th>ID</th>");
			out.println("<th>NAME</th>");
			out.println("<th>GENDER</th>");
			out.println("<th>EMAIL</th>");
			out.println("<th>PASSWORD</th>");
			out.println("<th>MOBILE NO</th>");
			out.println("<th>DEPARTMENT</th>");
			out.println("<th>LOCATION</th>");
			out.println("</tr>");
			
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("<td>"+rs.getString(6)+"</td>");
				out.println("<td>"+rs.getString(7)+"</td>");
				out.println("<td>"+rs.getString(8)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}
		catch(Exception e) {
			out.println(e);
		}
	}

}
