package edu.cmu.bilei.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.cmu.bilei.beans.FavoriteBean;
import edu.cmu.bilei.model.FavoriteDAO;

public class DeleteAction {
	
		// delete the favourite item 
		public String performAction(HttpServletRequest request){
			
			int favId = Integer.parseInt(request.getParameter("favId"));
			// call delete in the DAO 
			FavoriteDAO fd = new FavoriteDAO();
			fd.delete(favId);
			// get  session 
			HttpSession hs = request.getSession();
			
			// getting favourites and forward to favourites.jsp page 
			FavoriteDAO fdao = new FavoriteDAO();
			List<FavoriteBean> fvblist = fdao.read((int)hs.getAttribute("user_id"));;
			
			request.setAttribute("favourites", fvblist);
			
			return "manage.jsp";
			
		}
}
