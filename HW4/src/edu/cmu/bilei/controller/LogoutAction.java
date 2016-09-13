package edu.cmu.bilei.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet to log out 
 */
public class LogoutAction {
       
  
	/**
	 * log out : setting session to null 
	 */
	
	public String performAction(HttpServletRequest request){

		HttpSession session = request.getSession(false);
		
		if(session != null) session.invalidate();
		
		return "index.jsp";
	}
		



}
