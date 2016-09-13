

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Show
 */
@WebServlet("/Show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!doctype html>");
		out.println("<html>");
		out.println("    <head>");
		out.println("        <title>Show Information in Request</title>");
		out.println("    </head>");
		out.println("    <body>");
		out.println("        <table>");
		out.println(tableRow("Query String", request.getQueryString()));
		out.println(tableRow("Remote Host Address", request.getRemoteAddr()));
		out.println(tableRow("Remote Host Name", request.getRemoteHost()));
		out.println(tableRow("Remote Port", String.valueOf(request
				.getRemotePort())));
		out.println(tableRow("Request Method", request.getMethod()));
		out.println(tableRow("Server Name", request.getServerName()));
		out.println(tableRow("Server Port", String.valueOf(request
				.getServerPort())));
		out.println(tableRow("Servlet Path", request.getServletPath()));
		out.println("        </table>");

		out.println("        <br>");
		out.println("        <h2>Headers</h2>");
		out.println("        <table>");
		
		Enumeration<String> headerEnum = request.getHeaderNames();  // Returns raw enumeration
		
		while (headerEnum.hasMoreElements()) {
			String name = headerEnum.nextElement();
			out.println(tableRow(name, request.getHeader(name)));
		}
		out.println("        </table>");

		out.println("        <h2>Attributes</h2>");
		out.println("        <table>");

		Enumeration<String> attributeEnum = getServletContext().getAttributeNames();   // Returns raw enumeration
		
		while (attributeEnum.hasMoreElements()) {
			String name = attributeEnum.nextElement();
			out.println(tableRow(name, getServletContext().getAttribute(name)
					.toString()));
		}
		out.println("        </table>");

                out.println("    </body>");
                out.println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}

	private String tableRow(String description, String value) {
		StringBuffer b = new StringBuffer();
		b.append("<tr><td><h3>");
		b.append(description);
		b.append("</h3></td><td><h3>");
		b.append(value);
		b.append("</h3></td></tr>\n");
		return b.toString();
	}
}
