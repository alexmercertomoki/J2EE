package edu.cmu.cs.webapp.addrbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.addrbook.databean.User;
import edu.cmu.cs.webapp.addrbook.formbean.LoginForm;
import edu.cmu.cs.webapp.addrbook.model.EntryDAO;
import edu.cmu.cs.webapp.addrbook.model.Model;
import edu.cmu.cs.webapp.addrbook.model.UserDAO;

public class LoginAction extends Action {
	private static FormBeanFactory<LoginForm> formBeanFactory =	FormBeanFactory.getInstance(LoginForm.class);

	private EntryDAO entryDAO;
	private UserDAO  userDAO;

	public LoginAction(Model model) {
		entryDAO = model.getEntryDAO();
		userDAO  = model.getUserDAO();
	}

	public String getName() { return "login.do"; }
    
    public String perform(HttpServletRequest request) {
        try {
			int numEntries = entryDAO.getCount();
			request.setAttribute("numEntries",numEntries);

			List<String> errors = new ArrayList<String>();
            request.setAttribute("errors",errors);

	    	User user = (User) request.getSession(true).getAttribute("user");
	    	if (user != null) {
	    		errors.add("You are already logged in.");
	    		return "search.jsp";
	    	}

			LoginForm form = formBeanFactory.create(request);
			request.setAttribute("form",form);

			if (!form.isPresent()) return "login.jsp";

	    	errors.addAll(form.getValidationErrors());
	    	if (errors.size() > 0) return "login.jsp";
	    	
	    	user = userDAO.read(form.getUserName());
	    	if (user == null) {
	    		errors.add("Username invalid");
	    		return "login.jsp";
	    	}
	    	
	    	if (!user.checkPassword(form.getPassword())) {
	    		errors.add("Incorrect password");
	    		return "login.jsp";
	    	}
	    	
	    	request.getSession(true).setAttribute("user",user);
	    	
	    	if (form.getRedirect().length() > 0) {
	    		return form.getRedirect();
	    	}
	    	
	    	return "search.jsp";
        } catch (RollbackException e) {
        	e.printStackTrace();
        	request.setAttribute("dbError",e.getMessage());
        	return "db-error.jsp";
		} catch (FormBeanException e) {
        	e.printStackTrace();
        	request.setAttribute("formError",e.getMessage());
        	return "form-error.jsp";
		}
    }
}
