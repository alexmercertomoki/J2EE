package edu.cmu.cs.webapp.todolist8.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.DuplicateKeyException;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.todolist8.databean.User;
import edu.cmu.cs.webapp.todolist8.formbean.LoginForm;
import edu.cmu.cs.webapp.todolist8.model.Model;
import edu.cmu.cs.webapp.todolist8.model.UserDAO;

public class LoginAction extends Action {
	private FormBeanFactory<LoginForm> formBeanFactory = FormBeanFactory.getInstance(LoginForm.class);
	
	private UserDAO userDAO;

	public LoginAction(Model model) {
		userDAO = model.getUserDAO();
	}

	public String getName() { return "login.do"; }
    
    public String perform(HttpServletRequest request) {
        HttpSession session = request.getSession();
            	
    	// If user is already logged in, redirect to todolist.do
        if (session.getAttribute("user") != null) {
        	return "todolist.do";
        }
        
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        try {
	    	LoginForm form = formBeanFactory.create(request);
	        request.setAttribute("form",form);

	        // If no params were passed, return with no errors so that the form will be
	        // presented (we assume for the first time).
	        if (!form.isPresent()) {
	            return "login.jsp";
	        }

	        // Any validation errors?
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "login.jsp";
	        }

       		if (form.getAction().equals("Register")) {
       			User newUser = new User();
       			newUser.setUserName(form.getUserName());
       			newUser.setPassword(form.getPassword());
       			try {
	       			userDAO.create(newUser);
	       			
	       			session.setAttribute("user", newUser);
	       			return("todolist.do");
       	        } catch (DuplicateKeyException e) {
       	        	errors.add("A user with this name already exists");
       	        	return "login.jsp";
       			} 
       		} 

	        // Look up the user
	        User user = userDAO.read(form.getUserName());
	        
	        if (user == null) {
	            errors.add("User Name not found");
	            return "login.jsp";
	        }

	        // Check the password
	        if (!user.getPassword().equals(form.getPassword())) {
	            errors.add("Incorrect password");
	            return "login.jsp";
	        }
	
	        // Attach (this copy of) the user bean to the session
	        session.setAttribute("user",user);
	        
	        // If redirectTo is null, redirect to the "todolist" action
			return "todolist.do";
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
    }
}
