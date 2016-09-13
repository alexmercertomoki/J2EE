package edu.cmu.bilei.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import edu.cmu.bilei.beans.FavoriteBean;
import edu.cmu.bilei.beans.UserBean;
import edu.cmu.bilei.model.FavoriteDAO;
import edu.cmu.bilei.model.UserDAO;

public class ManageAction {
	
	/**
	 * 
	 * @param request has id in it 
	 * return a string with next page 
	 * 
	 */
	public String performAction(HttpServletRequest request){

		int userId = Integer.parseInt(request.getParameter("userId"));
		
		UserDAO ud = new UserDAO();
		UserBean ub = ud.readWithId(userId);
		
		// getting favourites and forward to favourites.jsp page 
		FavoriteDAO fdao = new FavoriteDAO();
		List<FavoriteBean> fvblist = fdao.read(ub.getUserId());
		
		request.setAttribute("userId", ub.getUserId()); 
		request.setAttribute("firstname", ub.getFirstName());
	
		request.setAttribute("lastname", ub.getLastName());
		request.setAttribute("favourites", fvblist);
		
		return  "manage.jsp";
				
	}
	
	
}
