package edu.cmu.cs.webapp.addrbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.addrbook.databean.Entry;
import edu.cmu.cs.webapp.addrbook.databean.User;
import edu.cmu.cs.webapp.addrbook.formbean.IdButtonForm;
import edu.cmu.cs.webapp.addrbook.formbean.LoginForm;
import edu.cmu.cs.webapp.addrbook.model.EntryDAO;
import edu.cmu.cs.webapp.addrbook.model.LogDAO;
import edu.cmu.cs.webapp.addrbook.model.Model;

public class DeleteEntryAction extends Action {
	private static FormBeanFactory<IdButtonForm> formBeanFactory = FormBeanFactory.getInstance(IdButtonForm.class);
	
	private EntryDAO entryDAO;
	private LogDAO   logDAO;

	public DeleteEntryAction(Model model) {
		entryDAO = model.getEntryDAO();
		logDAO   = model.getLogDAO();
	}

    public String getName() { return "delete-entry.do"; }

    public String perform(HttpServletRequest request) {
        try {
			request.setAttribute("numEntries",entryDAO.getCount());

			// Must be logged in for this one.  No redirect.
	        User user = (User) request.getSession(true).getAttribute("user");
			if (user == null) {
		        request.setAttribute("form",new LoginForm());
				return "login.jsp";
			}
			
			IdButtonForm form = formBeanFactory.create(request);
	    	List<String> errors = form.getValidationErrors();
	        request.setAttribute("errors",errors);
	    	if (errors.size() > 0) return "search.jsp";

	    	int id = form.getIdNum();
    		
	    	// Test to see if entry exists
        	Entry entry = entryDAO.read(id);
        	if (entry == null) {
    	    	errors.add("No record with id="+id+".  (Someone else must have just deleted it.)");
    	    	return "search.jsp";
        	}
    		
        	if (!form.getButton().equals("Yes")) {
        		// If user didn't click yes (so he clicked "No"), redisplay the entry
        		request.setAttribute("entry",entry);
        		return "display-entry.jsp";
        	}


        	// User clicked "Yes"
	    	logDAO.write(request,getName()+": id="+id);
	    	
	    	// Try to delete it.  If it was deleted since we looked it up (just above), DAO will throw exception
	    	entryDAO.delete(id);
	    	request.setAttribute("message","Deleted record for "+entry.getLastName()+","+entry.getFirstNames());

	    	// Update numEntries as we've deleted one
			request.setAttribute("numEntries",entryDAO.getCount());
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
