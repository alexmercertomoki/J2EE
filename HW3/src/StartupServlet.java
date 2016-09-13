import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;




public class StartupServlet extends HttpServlet { 

	/**
	 * on start --- create two tables: bhuang_user bhuang_favourite
	 */
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException{
		UserDAO ud = new UserDAO();
		FavoriteDAO fdao = new FavoriteDAO();
		ud.createUserTable();
		fdao.createFavouriteTable();
		
	}

}
