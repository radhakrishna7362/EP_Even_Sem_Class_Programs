import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitContextParamsDemo extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		out.println("Init Parameters Demo"+"<br>");
		
		ServletConfig sc=getServletConfig();
		out.println(sc.getInitParameter("id")+"<br>");
		out.println(sc.getInitParameter("name")+"<br>");
		out.println(sc.getInitParameter("gender")+"<br>");
		
		out.println(sc.getInitParameter("designation")+"<br>"); //null
		
		out.println("Context Parameters Demo"+"<br>");
		
		ServletContext sc1 = getServletContext();
		out.println(sc1.getInitParameter("dept")+"<br>");
		out.println(sc1.getInitParameter("university")+"<br>");
		
		/*out.println("Init Parameters Demo"+"<br>");
		
		ServletConfig sc=getServletConfig();
		Enumeration<String> params=sc.getInitParameterNames();
		
		while(params.hasMoreElements()) {
			out.println(sc.getInitParameter(params.nextElement())+"<br>");
		}*/
		
		/*out.println("Context Parameters Demo"+"<br>");
		
		ServletContext sc1 = getServletContext();
		Enumeration<String> params=sc1.getInitParameterNames();
		
		while(params.hasMoreElements()) {
			out.println(sc1.getInitParameter(params.nextElement())+"<br>");
		}*/
	}
}