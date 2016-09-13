

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
 * Servlet implementation class JumpCountServlet
 */
public class JumpCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getParameter("url");
		String preClick = request.getParameter("click");
		int click = Integer.parseInt(preClick) + 1;
		
		FavouriteDAO fdao = new FavouriteDAO();
		fdao.update(url, click);
		
		
		HttpSession hs =  request.getSession();
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
