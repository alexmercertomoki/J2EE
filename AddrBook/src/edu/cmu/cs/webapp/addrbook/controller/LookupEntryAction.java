package edu.cmu.cs.webapp.addrbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.addrbook.databean.Entry;
import edu.cmu.cs.webapp.addrbook.formbean.IdForm;
import edu.cmu.cs.webapp.addrbook.model.EntryDAO;
import edu.cmu.cs.webapp.addrbook.model.LogDAO;
import edu.cmu.cs.webapp.addrbook.model.Model;

public class LookupEntryAction extends Action {
	private static FormBeanFactory<IdForm> formBeanFactory = FormBeanFactory.getInstance(IdForm.class);
	
	private EntryDAO entryDAO;
	private LogDAO   logDAO;

	public LookupEntryAction(Model model) {
		entryDAO = model.getEntryDAO();
		logDAO   = model.getLogDAO();
	}

    public String getName() { return "lookup-entry.do"; }

    public String perform(HttpServletRequest request) {
        try {
			int numEntries = entryDAO.getCount();
			request.setAttribute("numEntries",numEntries);
			
			IdForm form = formBeanFactory.create(request);
	    	List<String> errors = form.getValidationErrors();
	        request.setAttribute("errors",errors);
	    	if (errors.size() > 0) return "search.jsp";

	    	int id = form.getIdNum();
	    	Entry entry = entryDAO.read(id);
	    	if (entry == null) {
		    	logDAO.write(request,"lookupAction: id="+id+", entry=null");
	    		errors.add("No record with id="+id);
	    		return "search.jsp";
	    	}
	    	
	    	logDAO.write(request,"lookupAction: id="+id+", lastName="+entry.getLastName()+", firstName="+entry.getFirstNames());
	    	request.setAttribute("entry",entry);
			return "display-entry.jsp";
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
