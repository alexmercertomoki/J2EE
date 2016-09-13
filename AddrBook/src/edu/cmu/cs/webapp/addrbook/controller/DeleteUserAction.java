package edu.cmu.cs.webapp.addrbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.addrbook.databean.User;
import edu.cmu.cs.webapp.addrbook.formbean.DeleteUserForm;
import edu.cmu.cs.webapp.addrbook.formbean.LoginForm;
import edu.cmu.cs.webapp.addrbook.model.EntryDAO;
import edu.cmu.cs.webapp.addrbook.model.Model;
import edu.cmu.cs.webapp.addrbook.model.UserDAO;

public class DeleteUserAction extends Action {
	private static FormBeanFactory<DeleteUserForm> formBeanFactory = FormBeanFactory.getInstance(DeleteUserForm.class);

	private EntryDAO entryDAO;
	private UserDAO  userDAO;

	public DeleteUserAction(Model model) {
		entryDAO = model.getEntryDAO();
		userDAO  = model.getUserDAO();
	}

	public String getName() { return "delete-user.do"; }
    
    public String perform(HttpServletRequest request) {
		try {
			int numEntries = entryDAO.getCount();
			request.setAttribute("numEntries",numEntries);

			// Must be logged in for this one.  Don't need to redirect.
	        User user = (User) request.getSession(true).getAttribute("user");
			if (user == null) {
				request.setAttribute("form", new LoginForm());
				return "login.jsp";
			}
	
	    	User[] userList = userDAO.match();
			request.setAttribute("userList",userList);

			DeleteUserForm form = formBeanFactory.create(request);
	        List<String> errors = form.getValidationErrors();
	        request.setAttribute("errors",errors);
	    	if (errors.size() > 0) return "manage-users.jsp";
	    	
	    	if (!form.getButton().equals("Yes")) return "manage-users.jsp";

	    	if (user.getUserName().equals(form.getUserName())) {
	    		errors.add("Cannot delete yourself");
	    		return "manage-users.jsp";
	    	}
	    	userDAO.delete(form.getUserName());
			
			// Refresh userList because we've changed it
	    	userList = userDAO.match();
			request.setAttribute("userList",userList);

			request.setAttribute("message","User "+form.getUserName()+" deleted");
			return "manage-users.jsp";
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
