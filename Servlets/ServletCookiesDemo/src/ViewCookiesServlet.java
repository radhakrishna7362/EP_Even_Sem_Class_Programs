import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewcookies")
public class ViewCookiesServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		Cookie[] cks = req.getCookies();
		if(cks!=null) {
			for(Cookie ck:cks) {
				out.println(ck.getName()+" "+ck.getValue()+" "+ck.getMaxAge()+"<br>");
			}
		}
		else {
			out.println("Cookies Expired!!!<br>");
			RequestDispatcher rd=req.getRequestDispatcher("employee.html");
			rd.include(req, res);
		}
		out.close();
	}
}