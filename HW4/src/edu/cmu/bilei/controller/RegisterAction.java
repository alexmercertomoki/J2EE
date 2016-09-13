package edu.cmu.bilei.controller;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cmu.bilei.beans.UserBean;
import edu.cmu.bilei.model.UserDAO;
/**
 * Servlet implementation class AddServlet
 */

public class RegisterAction{

   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * registration servlet 
	 */
	 public String performAction(HttpServletRequest request){		
			// getting the info
			String email = request.getParameter("email");
			String firstname = request.getParameter("fname");
			String lastname = request.getParameter("lname");
			String password = request.getParameter("password");
			//if not filled send back an error 
			if(email == "" || firstname == "" || lastname == "" || password == ""){
				request.setAttribute("errormessage","please complete the registration info ! ");
				
				return "register.jsp";
				
			}
			// getting the info and store in database 
			UserBean ub = new UserBean();
			ub.setEmail(email);
			ub.setFirstName(firstname);
			ub.setLastName(lastname);
			ub.setPassword(password);
			
			UserDAO ud = new UserDAO();
			ud.create(ub);
			// send back success info 
			request.setAttribute("errormessage","Success!");
			
			return "index.jsp";
			
	 }

}
