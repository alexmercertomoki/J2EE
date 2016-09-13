package edu.cmu.bilei.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import edu.cmu.bilei.beans.FavoriteBean;
import edu.cmu.bilei.model.FavoriteDAO;

public class ViewAllUserFavAction {
	/**
	 * @param request has userId
	 * @return the next page 
	 * a user's favourites for a not logged in visitor 
	 * 
	 */
	public String performAction(HttpServletRequest request){
		 //request.getParameter("userId")
		int userId = Integer.parseInt(request.getParameter("userId"));
		FavoriteDAO fav = new FavoriteDAO();
		
		List<FavoriteBean> list = fav.read(userId);
		
		request.setAttribute("allfavlist", list);
		
		return "alluserfavs.jsp";
		
	}

}
