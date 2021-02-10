import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyThirdServlet implements Servlet{
	ServletConfig config=null;
	public void init(ServletConfig config) {
		this.config=config;
	}
	
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name="klu";
		out.println("<h1>Hello "+name+"</h1><br>");
		out.println("Servlet Interface Demo");
		out.println(getServletInfo());
		out.println("<br>");
		out.println(getServletConfig());
	}
	
	public ServletConfig getServletConfig() {
		return config;
	}
	
	public String getServletInfo() {
		return "KLCSE : COPYRIGHTS 2020";
	}

	public void destroy() {
		System.out.println("Destory Method");
	}
}