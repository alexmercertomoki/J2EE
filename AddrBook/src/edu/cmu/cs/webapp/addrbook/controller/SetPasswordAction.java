package edu.cmu.cs.webapp.addrbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.addrbook.databean.User;
import edu.cmu.cs.webapp.addrbook.formbean.LoginForm;
import edu.cmu.cs.webapp.addrbook.formbean.SetPasswordForm;
import edu.cmu.cs.webapp.addrbook.model.EntryDAO;
import edu.cmu.cs.webapp.addrbook.model.Model;
import edu.cmu.cs.webapp.addrbook.model.UserDAO;

public class SetPasswordAction extends Action {
	private static FormBeanFactory<SetPasswordForm> formBeanFactory = FormBeanFactory.getInstance(SetPasswordForm.class);

	private EntryDAO entryDAO;
	private UserDAO  userDAO;

	public SetPasswordAction(Model model) {
		entryDAO = model.getEntryDAO();
		userDAO  = model.getUserDAO();
	}

	public String getName() { return "set-password.do"; }
    
    public String perform(HttpServletRequest request) {
		try {
			int numEntries = entryDAO.getCount();
			request.setAttribute("numEntries",numEntries);

			// Must be logged in for this one.  Don't need to redirect.
	        User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
				request.setAttribute("form", new LoginForm());
				return "login.jsp";
			}
	
			SetPasswordForm form = formBeanFactory.create(request);
			request.setAttribute("form",form);
	
	        List<String> errors = form.getValidationErrors();
	        request.setAttribute("errors",errors);
	    	if (errors.size() > 0) return "set-password.jsp";

	    	userDAO.setPassword(form.getUserName(), form.getNewPassword());
			
			request.setAttribute("message","Password changed for user "+form.getUserName());
	    	User[] userList = userDAO.match();
			request.setAttribute("userList",userList);
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
