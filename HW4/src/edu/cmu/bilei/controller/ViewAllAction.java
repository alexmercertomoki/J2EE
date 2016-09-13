package edu.cmu.bilei.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import edu.cmu.bilei.beans.UserBean;
import edu.cmu.bilei.model.UserDAO;

public class ViewAllAction {
	/**
	 * 
	 * @param session using the session to get the list of user info 
	 * @return the next page 
	 * getting all the users for visitors to view 
	 */
	public String performAction(HttpSession session){
			
		UserDAO ud = new UserDAO();
		List<UserBean> list = ud.userInfo();
		
		session.setAttribute("userinfo", list);
		
		return "alluserfavs.jsp";
		
	}
}
