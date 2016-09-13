package edu.cmu.cs.webapp.addrbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.addrbook.databean.User;
import edu.cmu.cs.webapp.addrbook.formbean.CreateUserForm;
import edu.cmu.cs.webapp.addrbook.formbean.LoginForm;
import edu.cmu.cs.webapp.addrbook.model.EntryDAO;
import edu.cmu.cs.webapp.addrbook.model.Model;
import edu.cmu.cs.webapp.addrbook.model.UserDAO;

public class CreateUserAction extends Action {
	private static FormBeanFactory<CreateUserForm> formBeanFactory =
		FormBeanFactory.getInstance(CreateUserForm.class);

	private EntryDAO entryDAO;
	private UserDAO  userDAO;

	public CreateUserAction(Model model) {
		entryDAO = model.getEntryDAO();
		userDAO  = model.getUserDAO();
	}
	
	public String getName() { return "create-user.do"; }
    
    public String perform(HttpServletRequest request) {
        try {
        	int numEntries = entryDAO.getCount();
			request.setAttribute("numEntries",numEntries);

			// Must be logged in for create-user.do, unless creating the intial user.
			// No need to redirect on login as normally user would login at manage-user.do
	        User user = (User) request.getSession().getAttribute("user");
        	int numUsers = userDAO.getCount();
			if (user == null && numUsers > 0) {
				request.setAttribute("form", new LoginForm());
				return "login.jsp";
			}
			
			CreateUserForm form = formBeanFactory.create(request);
			request.setAttribute("form",form);
			
			if (!form.isPresent()) return "create-user.jsp";
			
	    	List<String> errors = form.getValidationErrors();
	        request.setAttribute("errors",errors);
	    	if (errors.size() > 0) return "create-user.jsp";

	    	try {
		    	User newUser = new User();
		    	newUser.setUserName(form.getUserName());
		    	newUser.setPassword(form.getPassword());
		    	userDAO.create(newUser);
		    	
		    	if (user == null) {
		    		// This is the initial user...log in (by setting session attribute)
		    		request.getSession(true).setAttribute("user",newUser);
		    	}
	    	} catch (RollbackException e) {
	    		// Could be a duplicate key...catch exception on create here and send back to create-user.jsp
	    		errors.add(e.getMessage());
	    		return "create-user.jsp";
	    	}
	    	
	    	User[] userList = userDAO.match();
			request.setAttribute("userList",userList);
			return "manage-users.jsp";
        } catch (RollbackException e) {
        	request.setAttribute("dbError",e.toString());
        	return "db-error.jsp";
		} catch (FormBeanException e) {
        	e.printStackTrace();
        	request.setAttribute("formError",e.getMessage());
        	return "form-error.jsp";
		}
    }
}
