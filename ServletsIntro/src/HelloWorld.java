import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L; // when marshaling... here comes a problem, version control java 1.6 can do java 1.1's work
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <title>Hello World!</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1>Hello World!</h1>");
        out.println("    </body>");
        out.println("</html>");
    }
}
