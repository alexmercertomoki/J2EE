package edu.cmu.bilei.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.cmu.bilei.beans.FavoriteBean;
import edu.cmu.bilei.model.FavoriteDAO;
import edu.cmu.bilei.model.UserDAO;


/**
 *  changing password 
 */
public class PasswordChangeAction {
	/**
	 * 
	 * @param request has password and id 
	 * @return the next page 
	 * change the password according to id 
	 * 
	 */
	
	public String performAction(HttpServletRequest request){
			
		String password = request.getParameter("password");
		int userId = Integer.parseInt(request.getParameter("userId"));
		UserDAO ud = new UserDAO();
		ud.changePass(password, userId);
		
		
		HttpSession hs = request.getSession();
		
		// getting favourites and forward to favourites.jsp page 
		FavoriteDAO fdao = new FavoriteDAO();
		List<FavoriteBean> fvblist = fdao.read((int)hs.getAttribute("user_id"));;
		
		request.setAttribute("favourites", fvblist);
		request.setAttribute("info", "password changed successfully");
		
		
		return "manage.jsp";
		
	}

}
