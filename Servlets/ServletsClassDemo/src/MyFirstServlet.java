import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyFirstServlet extends HttpServlet{
	
	public void init() {
		System.out.println("Service intialized");
	}
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		System.out.println("Service Method");
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		
		String name="klu";
		
		out.println("<h1>Hello "+name+"</h1><br>");
		out.println("HttpServlet Demo");
	}
	
	public void destroy() {
		System.out.println("Service Destroyed");
	}
	
}