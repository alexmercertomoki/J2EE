import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Time")
public class Time extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Time Example</title>");
		out.println("</head>");
		out.println("<body>");
		DecimalFormat df = new DecimalFormat("#,###");
		out.println("  <h1>Current time in milliseconds is " +
				           df.format(System.currentTimeMillis()) + "</h1>");
		out.println("  <hr>");
		java.util.Date d = new java.util.Date();
		out.println("  <h1>The local time is "+d+"</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
