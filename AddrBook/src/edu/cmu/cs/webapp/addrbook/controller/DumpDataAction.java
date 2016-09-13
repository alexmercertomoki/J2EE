package edu.cmu.cs.webapp.addrbook.controller;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import edu.cmu.cs.webapp.addrbook.databean.Entry;
import edu.cmu.cs.webapp.addrbook.databean.User;
import edu.cmu.cs.webapp.addrbook.formbean.LoginForm;
import edu.cmu.cs.webapp.addrbook.model.EntryDAO;
import edu.cmu.cs.webapp.addrbook.model.Model;

public class DumpDataAction extends Action {
	private EntryDAO entryDAO;

	public DumpDataAction(Model model) {
		entryDAO = model.getEntryDAO();
	}

    public String getName() { return "dump-data.do"; }

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
			
			Entry[] list = entryDAO.match();
			request.setAttribute("list",list);
			return "dump-entries.jsp";
        } catch (RollbackException e) {
        	e.printStackTrace();
        	request.setAttribute("dbError",e.getMessage());
        	return "db-error.jsp";
		}
    }
}
