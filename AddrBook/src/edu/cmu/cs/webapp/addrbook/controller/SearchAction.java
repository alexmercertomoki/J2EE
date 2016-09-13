package edu.cmu.cs.webapp.addrbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.addrbook.databean.Entry;
import edu.cmu.cs.webapp.addrbook.formbean.SearchForm;
import edu.cmu.cs.webapp.addrbook.model.EntryDAO;
import edu.cmu.cs.webapp.addrbook.model.LogDAO;
import edu.cmu.cs.webapp.addrbook.model.Model;

public class SearchAction extends Action {
	private FormBeanFactory<SearchForm> formBeanFactory = FormBeanFactory.getInstance(SearchForm.class);
	
	private EntryDAO entryDAO;
	private LogDAO  logDAO;
	
    public SearchAction(Model model) {
		entryDAO = model.getEntryDAO();
		logDAO   = model.getLogDAO();
	}

    public String getName() { return "search.do"; }

    public String perform(HttpServletRequest request) {
        try {
        	int numEntries = entryDAO.getCount();
			request.setAttribute("numEntries",numEntries);
			
			SearchForm searchForm = formBeanFactory.create(request);
			request.setAttribute("searchForm",searchForm);
			
	    	if (!searchForm.isPresent()) return "search.jsp";

        	List<String> errors = searchForm.getValidationErrors();
			request.setAttribute("errors",errors);
	    	if (errors.size() > 0) return "search.jsp";

	    	Entry[] list = entryDAO.lookupStartsWith(searchForm.getLast(),searchForm.getFirst());
	    	Entry[] spouseList = entryDAO.lookupSpouseStartsWith(searchForm.getLast(),searchForm.getFirst());

	    	logDAO.write(request,"searchAction: last="+searchForm.getLast()+", first="+searchForm.getFirst()+", list.length="+list.length+", spouseList.length="+spouseList.length);

			if (list.length + spouseList.length == 0) {
				errors.add("No matches for last name starts with \""+searchForm.getLast()+"\" and first starts with \""+searchForm.getFirst()+"\"");
				return "search.jsp";
			}
			
			if (list.length + spouseList.length > 1) {
				request.setAttribute("list",list);
				request.setAttribute("spouseList",spouseList);
				return "list-entries.jsp";
			}
			
			if (list.length == 1) {
				request.setAttribute("entry",list[0]);
				return "display-entry.jsp";
			}
			
			request.setAttribute("entry",spouseList[0]);
			return "display-entry.jsp";
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
