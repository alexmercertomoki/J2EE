

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cmu.bilei.beans.FavouriteBean;

/**
 * Servlet implementation class AddServlet
 */

public class AddFavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = request.getParameter("url");
			String comment = request.getParameter("comment");
			HttpSession hs =  request.getSession();
			
			FavouriteBean favb = new FavouriteBean();
			favb.setClick_count(0);
			favb.setComment(comment);
			favb.setURL(url);
			favb.setUser_id((Integer)hs.getAttribute("user_id"));
			
			FavouriteDAO fdao = new FavouriteDAO();
			fdao.create(favb);
			
			
			
			
			List<FavouriteBean> fvblist = fdao.read((Integer)hs.getAttribute("user_id"));
			
			request.setAttribute("firstname", hs.getAttribute("firstname"));
			request.setAttribute("lastname", hs.getAttribute("lastname"));
			request.setAttribute("favourites", fvblist);
			
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("favourites.jsp");
			dispatcher.forward(request, response);
			return ;
	
	}

}
