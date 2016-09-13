package edu.cmu.cs.webapp.addrbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.addrbook.databean.User;
import edu.cmu.cs.webapp.addrbook.formbean.DeleteUserForm;
import edu.cmu.cs.webapp.addrbook.formbean.LoginForm;
import edu.cmu.cs.webapp.addrbook.formbean.ManageUserForm;
import edu.cmu.cs.webapp.addrbook.formbean.SetPasswordForm;
import edu.cmu.cs.webapp.addrbook.model.EntryDAO;
import edu.cmu.cs.webapp.addrbook.model.Model;
import edu.cmu.cs.webapp.addrbook.model.UserDAO;

public class ManageUsersAction extends Action {
	private static FormBeanFactory<ManageUserForm> formBeanFactory = FormBeanFactory.getInstance(ManageUserForm.class);
	
	private EntryDAO entryDAO;
	private UserDAO  userDAO;

	public ManageUsersAction(Model model) {
		entryDAO = model.getEntryDAO();
		userDAO  = model.getUserDAO();
	}

    public String getName() { return "manage-users.do"; }

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
			
			ManageUserForm form = formBeanFactory.create(request);
			if (!form.isPresent()) return "manage-users.jsp";
			
			List<String> errors = form.getValidationErrors();
	        request.setAttribute("errors",errors);
	    	if (errors.size() > 0) return "manage-users.jsp";

	    	if (form.getButton().equals("Delete")) {
	    		DeleteUserForm deleteForm = new DeleteUserForm();
	    		deleteForm.setUserName(form.getUserName());
	    		request.setAttribute("form",deleteForm);
	    		return "delete-user.jsp";
	    	}
	    	
	    	if (form.getButton().equals("Set Password")) {
	    		SetPasswordForm pwdForm = new SetPasswordForm();
	    		pwdForm.setUserName(form.getUserName());
	    		request.setAttribute("form",pwdForm);
	    		return "set-password.jsp";
	    	}
	    	
	    	errors.add("Unknown button: "+form.getButton());
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
