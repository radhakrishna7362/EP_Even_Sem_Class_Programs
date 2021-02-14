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

@WebServlet("/logincheck")
public class LoginCheckServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		
		if(uname.equals("klu") && pwd.equals("klu")) {
//			out.println("Login Valid");
			Cookie ck1 = new Cookie("uname",uname);
			Cookie ck2 = new Cookie("pwd",pwd);
			
			ck1.setMaxAge(15); //15 seconds
			ck2.setMaxAge(15); //15 seconds
			
			res.addCookie(ck1);
			res.addCookie(ck2);
			
			res.sendRedirect("userhome");
		}
		else {
//			out.println("Login Invalid");
//			res.sendRedirect("login.html");
			
			out.println("<h2 align='center'>Login Invalid<h2>");
			
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}
}