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
import edu.cmu.cs.webapp.addrbook.model.Model;

public class ModifyEntryAction extends Action {
	private static FormBeanFactory<IdButtonForm> formBeanFactory = FormBeanFactory.getInstance(IdButtonForm.class);
	
	private EntryDAO entryDAO;

    public ModifyEntryAction(Model model) {
		entryDAO = model.getEntryDAO();
	}

    public String getName() { return "modify-entry.do"; }

    public String perform(HttpServletRequest request) {
        try {
			request.setAttribute("numEntries",entryDAO.getCount());
			
			IdButtonForm form = formBeanFactory.create(request);
	    	List<String> errors = form.getValidationErrors();
	        request.setAttribute("errors",errors);
	    	if (errors.size() > 0) return "search.jsp";

			// Must be logged in for this one
	        User user = (User) request.getSession(true).getAttribute("user");
			if (user == null) {
				LoginForm loginForm = new LoginForm();
				loginForm.setRedirect("/modify-entry.do?id="+form.getId()+"&button="+form.getButton());
		        request.setAttribute("form",loginForm);
				return "login.jsp";
			}

	    	int id = form.getIdNum();
	    	Entry entry = entryDAO.read(id);
	    	if (entry == null) {
	    		errors.add("No record with id="+id);
	    		return "search.jsp";
	    	}

	    	if (form.getButton().equals("Delete")) {
		    	request.setAttribute("entry",entry);
				return "delete-entry.jsp";
	    	}
	    	
	    	if (form.getButton().equals("Edit")) {
	    		request.setAttribute("entry", entry);
	    		request.setAttribute("digest",entryDAO.computeDigest(entry));
	    		return "edit-entry.jsp";
	    	}
	    	
	    	errors.add("Unknown Button: "+form.getButton());
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
