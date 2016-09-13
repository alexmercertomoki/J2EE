package edu.cmu.cs.webapp.todolist3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cmu.cs.webapp.todolist3.dao.ItemDAO;
import edu.cmu.cs.webapp.todolist3.dao.MyDAOException;
import edu.cmu.cs.webapp.todolist3.dao.UserDAO;
import edu.cmu.cs.webapp.todolist3.databean.ItemBean;
import edu.cmu.cs.webapp.todolist3.databean.User;
import edu.cmu.cs.webapp.todolist3.formbean.IdForm;
import edu.cmu.cs.webapp.todolist3.formbean.ItemForm;
import edu.cmu.cs.webapp.todolist3.formbean.LoginForm;

public class ToDoList3 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ItemDAO itemDAO;
    private UserDAO userDAO;

    public void init() throws ServletException {
        String jdbcDriverName = getInitParameter("jdbcDriver");
        String jdbcURL = getInitParameter("jdbcURL");

        try {
            userDAO = new UserDAO(jdbcDriverName, jdbcURL, "user");
            itemDAO = new ItemDAO(jdbcDriverName, jdbcURL, "todolist");
        } catch (MyDAOException e) {
            throw new ServletException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            login(request, response);
        } else {
            manageList(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> errors = new ArrayList<String>();

        LoginForm form = new LoginForm(request);

        if (!form.isPresent()) {
            outputLoginPage(response, form, null);
            return;
        }

        errors.addAll(form.getValidationErrors());
        if (errors.size() != 0) {
            outputLoginPage(response, form, errors);
            return;
        }

        try {
            User user;

            if (form.getButton().equals("Register")) {
                user = new User();
                user.setUserName(form.getUserName());
                user.setPassword(form.getPassword());
                userDAO.create(user);
            } else {
                user = userDAO.read(form.getUserName());
                if (user == null) {
                    errors.add("No such user");
                    outputLoginPage(response, form, errors);
                    return;
                }

                if (!form.getPassword().equals(user.getPassword())) {
                    errors.add("Incorrect password");
                    outputLoginPage(response, form, errors);
                    return;
                }
            }

            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            manageList(request, response);
        } catch (MyDAOException e) {
            errors.add(e.getMessage());
            outputLoginPage(response, form, errors);
        }
    }

    private void manageList(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // Look at the action parameter to see what we're doing to the list
        String action = request.getParameter("action");

        if (action == null) {
            // No change to list requested
            outputToDoList(response);
            return;
        }

        if (action.equals("X")) {
            processDelete(request, response);
            return;
        }

        if (action.equals("Add to Top")) {
            processAdd(request, response, true);
            return;
        }

        if (action.equals("Add to Bottom")) {
            processAdd(request, response, false);
            return;
        }

        outputToDoList(response, "No such operation: " + action);
    }

    private void processAdd(HttpServletRequest request,
            HttpServletResponse response, boolean addToTop)
            throws ServletException, IOException {
        List<String> errors = new ArrayList<String>();

        ItemForm form = new ItemForm(request);

        errors.addAll(form.getValidationErrors());
        if (errors.size() > 0) {
            outputToDoList(response, errors);
            return;
        }

        try {
            ItemBean bean = new ItemBean();
            bean.setItem(form.getItem());
            bean.setIpAddress(request.getRemoteAddr());
            User u = (User) request.getSession().getAttribute("user");
            bean.setUserName(u.getUserName());
            if (addToTop) {
                itemDAO.addToTop(bean);
            } else {
                itemDAO.addToBottom(bean);
            }
            outputToDoList(response, "Item Added");
        } catch (MyDAOException e) {
            errors.add(e.getMessage());
            outputToDoList(response, errors);
        }
    }

    private void processDelete(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        List<String> errors = new ArrayList<String>();

        IdForm form = new IdForm(request);
        errors.addAll(form.getValidationErrors());
        if (errors.size() > 0) {
            outputToDoList(response, errors);
            return;
        }

        try {
            itemDAO.delete(form.getIdAsInt());
            outputToDoList(response, "Item Deleted");
        } catch (MyDAOException e) {
            errors.add(e.getMessage());
            outputToDoList(response, errors);
        }
    }

    // Methods that generate & output HTML

    private void generateHead(PrintWriter out) {
        out.println("  <head>");
        out.println("    <meta charset=\"utf-8\"/>");
        out.println("    <title>To Do List Login</title>");
        out.println("  </head>");
    }

    private void outputLoginPage(HttpServletResponse response, LoginForm form,
            List<String> errors) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");

        generateHead(out);

        out.println("<body>");
        out.println("<h2>To Do List Login</h2>");

        if (errors != null && errors.size() > 0) {
            for (String error : errors) {
                out.println("<p style=\"font-size: large; color: red\">");
                out.println(error);
                out.println("</p>");
            }
        }

        // Generate an HTML <form> to get data from the user
        out.println("<form method=\"POST\">");
        out.println("    <table>");
        out.println("        <tr>");
        out.println("            <td style=\"font-size: x-large\">User Name:</td>");
        out.println("            <td>");
        out.println("                <input type=\"text\" name=\"userName\"");
        if (form != null && form.getUserName() != null) {
            out.println("                    value=\"" + form.getUserName()
                    + "\"");
        }
        out.println("                />");
        out.println("            </td>");
        out.println("        </tr>");
        out.println("        <tr>");
        out.println("            <td style=\"font-size: x-large\">Password:</td>");
        out.println("            <td><input type=\"password\" name=\"password\" /></td>");
        out.println("        </tr>");
        out.println("        <tr>");
        out.println("            <td colspan=\"2\" style=\"text-align: center;\">");
        out.println("                <input type=\"submit\" name=\"button\" value=\"Login\" />");
        out.println("                <input type=\"submit\" name=\"button\" value=\"Register\" />");
        out.println("            </td>");
        out.println("        </tr>");
        out.println("    </table>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    private void outputToDoList(HttpServletResponse response)
            throws IOException {
        // Just call the version that takes a List passing an empty List
        List<String> list = new ArrayList<String>();
        outputToDoList(response, list);
    }

    private void outputToDoList(HttpServletResponse response, String message)
            throws IOException
    {
        // Just put the message into a List and call the version that takes a
        // List
        List<String> list = new ArrayList<String>();
        list.add(message);
        outputToDoList(response, list);
    }

    private void outputToDoList(HttpServletResponse response,
            List<String> messages) throws IOException
    {
        // Get the list of items to display at the end
        ItemBean[] beans;
        try {
            beans = itemDAO.getItems();

            Arrays.sort(beans,
                    (ItemBean i1, ItemBean i2) -> i1.getPosition() - i2.getPosition());

        } catch (MyDAOException e) {
            // If there's an access error, add the message to our list of
            // messages
            messages.add(e.getMessage());
            beans = new ItemBean[0];
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");

        generateHead(out);

        out.println("<body>");
        out.println("<h2>Web App To Do List</h2>");

        // Generate an HTML <form> to get data from the user
        out.println("<form method=\"POST\">");
        out.println("    <table>");
        out.println("        <tr><td colspan=\"3\"><hr/></td></tr>");
        out.println("        <tr>");
        out.println("            <td style=\"font-size: large\">Item to Add:</td>");
        out.println("            <td colspan=\"2\"><input type=\"text\" size=\"40\" name=\"item\"/></td>");
        out.println("        </tr>");
        out.println("        <tr>");
        out.println("            <td></td>");
        out.println("            <td><input type=\"submit\" name=\"action\" value=\"Add to Top\"/></td>");
        out.println("            <td><input type=\"submit\" name=\"action\" value=\"Add to Bottom\"/></td>");
        out.println("        </tr>");
        out.println("        <tr><td colspan=\"3\"><hr/></td></tr>");
        out.println("    </table>");
        out.println("</form>");

        for (String message : messages) {
            out.println("<p style=\"font-size: large; color: red\">");
            out.println(message);
            out.println("</p>");
        }

        out.println("<p style=\"font-size: x-large\">The list now has "
                + beans.length + " items.</p>");
        out.println("<table>");
        for (int i = 0; i < beans.length; i++) {
            out.println("    <tr>");
            out.println("        <td>");
            out.println("            <form method=\"POST\">");
            out.println("                <input type=\"hidden\" name=\"id\" value=\""
                    + beans[i].getId() + "\" />");
            out.println("                <input type=\"submit\" name=\"action\" value=\"X\" />");
            out.println("            </form>");
            out.println("        </td>");
            out.println("        <td><span style=\"font-size: x-large\">"
                    + (i + 1) + ".</span></td>");
            out.println("        <td><span style=\"font-size: x-large\">"
                    + beans[i].getItem() + "</span> (uniqueId="
                    + beans[i].getId() + ", user =" + beans[i].getUserName()
                    + ", ipAddr = " + beans[i].getIpAddress() + ")</td>");
            out.println("    </tr>");
        }
        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }
}
