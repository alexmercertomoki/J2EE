package edu.cmu.bilei.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.cmu.bilei.beans.FavoriteBean;
import edu.cmu.bilei.model.FavoriteDAO;

/**
 * Servlet implementation class JumpCountServlet
 */
public class JumpCountAction {
       
		/**
		 * update the numbers of count : plus one ! 
		 */

		public void performAction(HttpServletRequest request){
			
			String url = request.getParameter("url");
			String preClick = request.getParameter("click");
			int click = Integer.parseInt(preClick) + 1;
			
			FavoriteDAO fdao = new FavoriteDAO();
			fdao.update(url, click);
			
			HttpSession hs =  request.getSession();
			List<FavoriteBean> fvblist = fdao.read((Integer)hs.getAttribute("user_id"));
			
			request.setAttribute("firstname", hs.getAttribute("firstname"));
			request.setAttribute("lastname", hs.getAttribute("lastname"));
			request.setAttribute("favourites", fvblist);
			
		}
		




}
