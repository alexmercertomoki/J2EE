

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cmu.bilei.beans.FavoriteBean;

/**
 * Servlet implementation class AddServlet
 */

public class AddFavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *  getting favourite urls and add to the the database 
	 *  
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// getting the urls and comment 
			String url = request.getParameter("url");
			String comment = request.getParameter("comment");
			// getting session and beans and dao for future use 
			HttpSession hs =  request.getSession();
			FavoriteBean favb = new FavoriteBean();
			FavoriteDAO fdao = new FavoriteDAO();
			
			// if you haven't entered a url it displays error message 
			if(url == ""){
				// set the error message 
				request.setAttribute("errormessage","please complete URL info ! ");
				// get the list of favourites  and dispatcher to the JSP 
				List<FavoriteBean> fvblist = fdao.read((Integer)hs.getAttribute("user_id"));
				
				request.setAttribute("firstname", hs.getAttribute("firstname"));
				request.setAttribute("lastname", hs.getAttribute("lastname"));
				request.setAttribute("favourites", fvblist);
				
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("favourites.jsp");
				dispatcher.forward(request, response);
				return ;
				
			}
			
			
			// adding the favourites if there is one 
			favb.setClick_count(0);
			favb.setComment(comment);
			favb.setURL(url);
			favb.setUser_id((Integer)hs.getAttribute("user_id"));
			
			
			fdao.create(favb);
			
			
			
			// showing back the favourites.jsp page 
			List<FavoriteBean> fvblist = fdao.read((Integer)hs.getAttribute("user_id"));
			
			request.setAttribute("firstname", hs.getAttribute("firstname"));
			request.setAttribute("lastname", hs.getAttribute("lastname"));
			request.setAttribute("favourites", fvblist);
			
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("favourites.jsp");
			dispatcher.forward(request, response);
			return ;
	
	}

}
