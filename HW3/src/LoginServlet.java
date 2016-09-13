import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cmu.bilei.beans.FavoriteBean;
import edu.cmu.bilei.beans.UserBean;


/**
 * Servlet implementation class login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * the servlet for login in : check error store info in session 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//get email and password and check 
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			PrintWriter out = response.getWriter();
			
			UserDAO ud = new UserDAO();
			UserBean ub = ud.read(email);
			
			String message = "";
			if(ub.getEmail() == null){
				message = "UserNotFound";
				
			} else if(ub.getPassword() != null){
				if(!ub.getPassword().equals(password)){
					message = "Wrong Password ";	
				} else{
					// put info in session 
					HttpSession hs =  request.getSession();
					hs.setAttribute("email", ub.getEmail()); // setting email
					hs.setAttribute("user_id", ub.getUserId()); // setting user id 
					hs.setAttribute("firstname", ub.getFirstName());
					hs.setAttribute("lastname", ub.getLastName());
					
					// getting favourites and forward to favourites.jsp page 
					FavoriteDAO fdao = new FavoriteDAO();
					List<FavoriteBean> fvblist = fdao.read(ub.getUserId());
					
					request.setAttribute("firstname", ub.getFirstName());
					request.setAttribute("lastname", ub.getLastName());
					request.setAttribute("favourites", fvblist);
					
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("favourites.jsp");
					dispatcher.forward(request, response);
					return ;
					
					
				}
				
			}else{
				out.print("Error");
			}
			// if info not correct forward back with error message 
			request.setAttribute("errormessage", message);
			
			
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			return ;
			
			
	}

}
