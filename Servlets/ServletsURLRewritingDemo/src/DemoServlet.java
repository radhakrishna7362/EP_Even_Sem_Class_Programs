import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String eid=req.getParameter("eid");
		String ename=req.getParameter("ename");
		
		
//		res.sendRedirect("getvalues?id="+eid+"+&ename="+ename);
		res.sendRedirect("getvalues?ename="+ename);
	}
}