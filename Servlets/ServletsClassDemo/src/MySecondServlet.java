import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MySecondServlet extends GenericServlet{
	public void init() {
		System.out.println("Servlet Initialized");
	}
	
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException{
		System.out.println("Service Method");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name="klu";
		out.println("<h1>Hello "+name+"</h1><br>");
		out.println("GenericServlet Demo");
	}
	
	public void destory(){
		System.out.println("Destory Method");
	}
}