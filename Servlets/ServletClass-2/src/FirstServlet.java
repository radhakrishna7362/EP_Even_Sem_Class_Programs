import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		out.println("I am in First Servlet<br>");
		
		/*RequestDispatcher rd=req.getRequestDispatcher("display.html");
		rd.forward(req, res);*/
		
		/*RequestDispatcher rd=req.getRequestDispatcher("second");
		rd.include(req, res);*/
		
		/*RequestDispatcher rd=req.getRequestDispatcher("second");
		rd.forward(req, res);*/
		
//		res.sendRedirect("second");
		
		res.sendRedirect("https://www.kluniversity.in/");
	}
}