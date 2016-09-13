package edu.cmu.bilei.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.cmu.bilei.beans.FavoriteBean;
import edu.cmu.bilei.model.FavoriteDAO;

/**
 * add favourites action class 
 */

public class AddFavAction {

	public String performAction(HttpServletRequest request){
		
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
			
			return "favourites.jsp";
			
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
		
		return "manage.jsp";
		
		
	}
   
	
}
