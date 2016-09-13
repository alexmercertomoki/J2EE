package edu.cmu.cs.webapp.threads;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todo-synchronized")
public class ToDoListServletSynchronized extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // The Data Access Objects
    private ItemDAO itemDAO = new ItemDAO();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");

        // Generate the HTML <head>
        out.println("<head>");
        out.println("    <title>To Do List</title>");
        out.println(" </head>");

        out.println("<body>");
        out.println("<h2>Web App To Do List</h2>");

        // Generate an HTML <form> to get data from the user
        out.println("<form method=\"POST\">");
        out.println("  <table>");
        out.println("  <tr><td colspan=\"3\"><hr/></td></tr>");
        out.println("  <tr>");
        out.println("    <td>Item to Add:</td>");
        out.println("    <td colspan=\"2\"><input type=\"text\" size=\"40\" name=\"addText\"/></td>");
        out.println("  </tr>");
        out.println("  <tr>");
        out.println("    <td/>");
        out.println("    <td><input type=\"submit\" name=\"action\" value=\"Add to Top\"></td>");
        out.println("    <td><input type=\"submit\" name=\"action\" value=\"Add to Bottom\"></td>");
        out.println("  </tr>");
        out.println("  <tr><td colspan=\"3\"><hr/></td></tr>");
        out.println("  <tr>");
        out.println("    <td>Item Unique ID Number:</td>");
        out.println("    <td><input type=\"text\" size=\"10\" name=\"deleteNum\"></td>");
        out.println("    <td><input type=\"submit\" name=\"action\" value=\"Delete\"></td>");
        out.println("  </tr>");
        out.println("  <tr><td colspan=\"3\"><hr/></td></tr>");
        out.println("  </table>");
        out.println("</form>");

        // Look at the parameters. Add or data item as requested
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("Add to Top")) {
                Item newItem = new Item();
                newItem.text = request.getParameter("addText");
                newItem.ipAddress = request.getRemoteAddr();
                itemDAO.addToTop(newItem);
                out.println("<p>Added item in position 1</p>");
            } else if (action.equals("Add to Bottom")) {
                Item newItem = new Item();
                newItem.text = request.getParameter("addText");
                newItem.ipAddress = request.getRemoteAddr();
                int position = itemDAO.addToBottom(newItem);
                out.println("<p>Added item in position " + position + "</p>");
            } else if (action.equals("Delete")) {
                itemDAO.delete(Integer.parseInt(request.getParameter("deleteNum")));
                out.println("<p>Deleted item with ID Number = "
                        + request.getParameter("deleteNum") + "</p>");
            }
        }

        Item[] items = itemDAO.getItems();
        out.println("<p>The list now has " + items.length + " items.</p>");
        out.println("<table>");
        for (int i = 0; i < items.length; i++) {
            out.println("<tr>");
            Item item = items[i];
            out.println("<td><span style=\"font-size: x-large\">" + (i + 1)
                    + ".</span></td>");
            out.println("<td><span style=\"font-size: x-large\">"
                    + sanitize(item.text) + "</span> (uniqueId="
                    + item.uniqueId + ", ipAddr=" + item.ipAddress + ")</td>");
            out.println("</tr>");
        }
        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }

    private String sanitize(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;")
                .replace(">", "&gt;").replace("\"", "&quot;");
    }
}
