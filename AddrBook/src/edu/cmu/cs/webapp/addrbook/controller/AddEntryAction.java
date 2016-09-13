package edu.cmu.cs.webapp.addrbook.controller;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import edu.cmu.cs.webapp.addrbook.databean.User;
import edu.cmu.cs.webapp.addrbook.formbean.EntryForm;
import edu.cmu.cs.webapp.addrbook.formbean.LoginForm;
import edu.cmu.cs.webapp.addrbook.model.EntryDAO;
import edu.cmu.cs.webapp.addrbook.model.Model;

public class AddEntryAction extends Action {
	private EntryDAO entryDAO;

    public AddEntryAction(Model model) {
		entryDAO = model.getEntryDAO();
	}

    public String getName() { return "add-entry.do"; }

    public String perform(HttpServletRequest request) {
        try {
			int numEntries = entryDAO.getCount();
			request.setAttribute("numEntries",numEntries);

			// Must be logged in for this one
	        User user = (User) request.getSession(true).getAttribute("user");
			if (user == null) {
				LoginForm form = new LoginForm();
				form.setRedirect("/add-entry.do");
		        request.setAttribute("form",form);
				return "login.jsp";
			}

			EntryForm form = new EntryForm();
			form.setId("0");
			request.setAttribute("form",form);
			return "edit-form.jsp";
        } catch (RollbackException e) {
        	e.printStackTrace();
        	request.setAttribute("dbError",e.getMessage());
        	return "db-error.jsp";
		}
    }
}
