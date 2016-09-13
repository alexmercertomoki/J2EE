package edu.cmu.bilei.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.cmu.bilei.beans.FavoriteBean;
import edu.cmu.bilei.beans.UserBean;
import edu.cmu.bilei.model.FavoriteDAO;
import edu.cmu.bilei.model.UserDAO;


/**
 * Servlet TO login and set session with id and other info 
 */
public class LoginAction{
       
		
		public String performAction(HttpServletRequest request){

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			
			UserDAO ud = new UserDAO();
			// read with email get the user bean 
			UserBean ub = ud.read(email);
			
			String message = "";
			if(ub.getEmail() == null){
				message = "UserNotFound or form is empty";
			} else if(ub.getPassword() != null){
				if(!ub.getPassword().equals(password)){
					message = "Wrong Password or you haven't entered ";	
				} else{
					// put info in session 
					HttpSession hs =  request.getSession();
					hs.setAttribute("email", ub.getEmail()); // setting email
					hs.setAttribute("user_id", ub.getUserId()); // setting user id 
					hs.setAttribute("firstname", ub.getFirstName());
					hs.setAttribute("lastname", ub.getLastName());
					
					// getting favourites and forward to favourites.jsp page 
					FavoriteDAO fdao = new FavoriteDAO();
					List<FavoriteBean> fvblist = fdao.read(ub.getUserId());
					
					
					request.setAttribute("userId", ub.getUserId());
					request.setAttribute("firstname", ub.getFirstName());
					request.setAttribute("lastname", ub.getLastName());
					request.setAttribute("favourites", fvblist);
					
					return  "favourites.jsp";
					
					
				}
				
			}
			
			// if info not correct forward back with error message 
			request.setAttribute("errormessage", message);
			
			return "index.jsp";
		}
		

}
