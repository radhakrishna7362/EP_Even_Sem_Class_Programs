import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userhome")
public class UserHomeServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		Cookie[] cks = req.getCookies();
		if(cks!=null) {
			String uname = cks[0].getValue();
			
			out.println("<h2 align='center'>User Home Page</h2><br>");
			out.println("<b>Welcome </b>"+uname+"<br><br>");
			
			RequestDispatcher rd= req.getRequestDispatcher("userhome.html");
			rd.include(req, res);
		}
		else {
			out.println("<h2 align='center'>Cookies Expired!!!<br></h2>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}
}