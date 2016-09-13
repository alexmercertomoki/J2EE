

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cmu.bilei.beans.UserBean;

/**
 * Servlet implementation class AddServlet
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String email = request.getParameter("email");
			String firstname = request.getParameter("fname");
			String lastname = request.getParameter("lname");
			String password = request.getParameter("password");
			
			UserBean ub = new UserBean();
			ub.setEmail(email);
			ub.setFirstName(firstname);
			ub.setLastName(lastname);
			ub.setPassword(password);
			
			UserDAO ud = new UserDAO();
			ud.create(ub);
			
			request.setAttribute("errormessage","Success!");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
			return;
			
	
	}

}
