import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookiesdemo")
public class CookiesDemoServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String empid = req.getParameter("eid");
		String empname = req.getParameter("ename");
		
		Cookie ck1 = new Cookie("empid",empid);
		Cookie ck2 = new Cookie("empname",empname);
		
		ck1.setMaxAge(10); //10 seconds
		ck2.setMaxAge(10); //10 seconds
		
		res.addCookie(ck1);
		res.addCookie(ck2);
		
		res.sendRedirect("viewcookies");
		out.close();
	}
}