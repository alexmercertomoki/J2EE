package edu.cmu.cs.webapp.addrbook.controller;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.addrbook.databean.Entry;
import edu.cmu.cs.webapp.addrbook.formbean.AdvancedSearchForm;
import edu.cmu.cs.webapp.addrbook.model.EntryDAO;
import edu.cmu.cs.webapp.addrbook.model.Model;

public class AdvancedSearchAjaxAction extends Action {
	private static FormBeanFactory<AdvancedSearchForm> formBeanFactory = FormBeanFactory.getInstance(AdvancedSearchForm.class);
	private EntryDAO entryDAO;

    public AdvancedSearchAjaxAction(Model model) {
		entryDAO = model.getEntryDAO();
	}

    public String getName() { return "advanced-search-ajax.do"; }
    
    //In this method we receive the ajax request from the javascript in
    //advanced-search-form.jsp
    //We lookup in the DB the query results and we return to advanced-search-ajax.jsp
    //so it displays the results in XML format.
    public String perform(HttpServletRequest request) {
    	try {
        	AdvancedSearchForm form = formBeanFactory.create(request);
        	
        	if (!form.isPresent()) {
            	request.setAttribute("formError","No form send with this request.");
            	return "form-error.jsp";
        	}
        	
			Entry[] entryList = entryDAO.lookupAdvanced(form);
			request.setAttribute("entryList", entryList);
			return "advanced-search-ajax.jsp";
		} catch (RollbackException e) {
			e.printStackTrace();
			request.setAttribute("dbError",e.toString());
        	return "db-error.jsp";
		} catch (FormBeanException e) {
        	e.printStackTrace();
        	request.setAttribute("formError",e.getMessage());
        	return "form-error.jsp";
		}
    }
}
