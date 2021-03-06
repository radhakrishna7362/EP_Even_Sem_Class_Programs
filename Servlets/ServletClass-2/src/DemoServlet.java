import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		out.println("Init Parameters Demo"+"<br>");
		
		ServletConfig sc=getServletConfig();
		out.println(sc.getInitParameter("id")+"<br>"); //null
		out.println(sc.getInitParameter("name")+"<br>"); //null
		out.println(sc.getInitParameter("gender")+"<br>"); //null
		
		out.println(sc.getInitParameter("designation")+"<br>"); //professor
		
		out.println("Context Parameters Demo"+"<br>");
		
		ServletContext sc1 = getServletContext();
		out.println(sc1.getInitParameter("dept")+"<br>");
		out.println(sc1.getInitParameter("university")+"<br>");
	}
}