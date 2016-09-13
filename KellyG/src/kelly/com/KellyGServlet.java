package kelly.com;


/**
 * Author: Kaili Gu Last Modified: Jan 30, 2015
 * 
* This program creates a web application to determine if a string entered into
 * a browser is a palindrome. It allows a user input a text for palindrome
 * judgment. A string is confirmed to be a palindrome if it is empty, has one
 * single character, or reads the same when reading from left to right or from
 * right to left. This servlet also make the appropriate doctype for an Android
 * mobile.
 */
// imports required
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KellyGServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Palin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // determine what type of device our user is 
        String ua = request.getHeader("User-Agent");

        boolean mobile;
        // prepare the appropriate DOCTYPE for the view pages
        //if mobile
        if (ua != null && ((ua.indexOf("Android") != -1) || (ua.indexOf("iPhone") != -1))) {
            mobile = true;
            /*
             * This is the latest XHTML Mobile doctype. To see the difference it
             * makes, comment it out so that a default desktop doctype is used
             * and view on an Android or iPhone.
             */
            request.setAttribute("doctype", "<!DOCTYPE html PUBLIC \"-//WAPFORUM//DTD XHTML Mobile 1.2//EN\" \"http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd\">");
        } //if not mobile
        else {
            mobile = false;
            request.setAttribute("doctype", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        }
        //conversion from string input by the user
        String s = request.getParameter("txt");

        String nextView;
//start to check if the string is a palindrome
        if (s != null) {

            PrintWriter out = response.getWriter();
//a string is a palindrome if it is enpty or has a single character            
            if (s.length() == 0 || s.length() == 1) {
//output the decision            
                response.setContentType("text/html");
                out = response.getWriter();

                String docType = "<!DOCTYPE HTML PUBLIC \"//W3C//DTD HTML 4.0 ";
                docType += "Transitional//EN\">\n";

                out.println("<HTML>\n"
                        + "<HEAD><TITLE>Results</TITLE></HEAD>\n"
                        + "<BODY>\n"
                        + "<h1>" + " Yes, \"" + s + "\" is a palindrome."
                        + "</h1>"
                        + "</BODY></HTML>");
            } else {
                try {
//eliminate all other characters except letters, such as puctuations and white spaces
                    String ss = s.replaceAll("[^a-zA-Z]+", "");
//unify all the letters into lowercase                  
                    String string1 = ss.toLowerCase();
//store this whole string into a StringBuilder sb
                    StringBuilder sb = new StringBuilder(string1);
//get a new string from reversing the orders of letters in the original string                        
                    sb = sb.reverse();
//store this new string into string2                        
                    String string2 = sb.toString();
//a string is a palindrome if it reads the same when reading from left to right or form right to left                        
                    if (string1.equals(string2)) {
//output the decision                          
                        response.setContentType("text/html");
                        out = response.getWriter();

                        String docType = "<!DOCTYPE HTML PUBLIC \"//W3C//DTD HTML 4.0 ";
                        docType += "Transitional//EN\">\n";

                        out.println("<HTML>\n"
                                + "<HEAD><TITLE>Results</TITLE></HEAD>\n"
                                + "<BODY>\n"
                                + "<h1>" + " Yes, \"" + s + "\" is a palindrome."
                                + "</h1>" + "</BODY></HTML>");
                    } //a string is not a palindrome if it reads different when reading from left to right or form right to left
                    else {
//output the decision
                        out.println("<HTML>\n"
                                + "<HEAD><TITLE>Results</TITLE></HEAD>\n"
                                + "<BODY>\n"
                                + "<h1>" + " No, \"" + s + "\" is not a palindrome."
                                + "</h1>" + "</BODY></HTML>");
                    }

                } //handle general exception and return the error message to inform user to input
                //valid values
                catch (Exception e) {
                    out.println("<HTML>\n"
                            + "<HEAD><TITLE>Results</TITLE></HEAD>\n"
                            + "<BODY>\n"
                            + "<h1>" + " Error occurs."
                            + "</h1>" + "</BODY></HTML>");
                }
            }
            // use model to do the search and choose the result view
        } //start a new palindrome judgement
        else {
            // no search parameter so choose the prompt view
            nextView = "index.jsp";
            // Transfer control over the the correct "view"
            RequestDispatcher view = request.getRequestDispatcher(nextView);
            view.forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
