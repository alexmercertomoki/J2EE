import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;




public class StartupServlet extends HttpServlet { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException{
		// TODO Auto-generated method stub
		UserDAO ud = new UserDAO();
		FavouriteDAO fdao = new FavouriteDAO();
		ud.createUserTable();
		fdao.createFavouriteTable();
		
	}

}
