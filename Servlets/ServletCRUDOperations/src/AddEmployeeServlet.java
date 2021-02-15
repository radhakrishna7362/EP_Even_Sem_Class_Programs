import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addemployee")
public class AddEmployeeServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String mob = req.getParameter("mob");
		String dept = req.getParameter("dept");
		String loc = req.getParameter("loc");
		
		int id = (int)(Math.random()*99999)+1;
		try {
			Connection con=null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","190031187");
			
			PreparedStatement pstmt=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, gender);
			pstmt.setString(4, email);
			pstmt.setString(5, pwd);
			pstmt.setString(6, mob);
			pstmt.setString(7, dept);
			pstmt.setString(8, loc);
			int n=pstmt.executeUpdate();
			if(n>0) {
				out.println("<h2 align=center>Employee Record Added Successfully</h2>");
				RequestDispatcher rd= req.getRequestDispatcher("viewemployees");
				rd.forward(req, res);
			}
			else {
				out.println("Unable To Insert Employee Record");
			}
		}
		catch(Exception e) {
			out.println(e);
		}
	}

}
