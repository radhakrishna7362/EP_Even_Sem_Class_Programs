import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		Cookie[] cks=req.getCookies();
		
		cks[0].setMaxAge(0);
		cks[1].setMaxAge(0);
		
		res.addCookie(cks[0]);
		res.addCookie(cks[1]);
		
		out.println("<h2 align='center'>Logout Successfully</h2><br>");
		
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.include(req,res);
	}
}