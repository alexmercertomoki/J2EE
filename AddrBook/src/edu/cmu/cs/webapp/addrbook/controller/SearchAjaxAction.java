package edu.cmu.cs.webapp.addrbook.controller;


import java.util.Arrays;
import java.util.Comparator;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.addrbook.databean.Entry;
import edu.cmu.cs.webapp.addrbook.formbean.SearchForm;
import edu.cmu.cs.webapp.addrbook.model.EntryDAO;
import edu.cmu.cs.webapp.addrbook.model.LogDAO;
import edu.cmu.cs.webapp.addrbook.model.Model;
import edu.cmu.cs.webapp.addrbook.viewbean.Name;

public class SearchAjaxAction extends Action {
	private FormBeanFactory<SearchForm> formBeanFactory = FormBeanFactory.getInstance(SearchForm.class);
	
	private EntryDAO entryDAO;
	private LogDAO   logDAO;
	
    public SearchAjaxAction(Model model) {
		entryDAO = model.getEntryDAO();
		logDAO   = model.getLogDAO();
	}

    public String getName() { return "search-ajax.do"; }

    // In this method we receive the ajax request from the javascript in
    // search-form.jsp.  We lookup in the DB the query results and we return
    // them via the search-ajax.jsp view which will send them to the client
    // browser as XML format records.
    //
    // The JavaScript in search-suggest.js converts the XML records to
    // to a DOM tree and updates the HTML created by search.jsp.
    
    public String perform(HttpServletRequest request) {
        try {	
			SearchForm searchForm = formBeanFactory.create(request);
	    	
			if (!searchForm.isPresent()) return "search-ajax.jsp";
			if (searchForm.getValidationErrors().size() > 0) return "search-ajax.jsp";
	    	
			Entry[] entryList = entryDAO.lookupStartsWith(searchForm.getLast(),searchForm.getFirst());
			Entry[] spouseList = entryDAO.lookupSpouseStartsWith(searchForm.getLast(),searchForm.getFirst());
			
			Name[] nameList = merge(entryList,spouseList);
			request.setAttribute("nameList",nameList);
			logDAO.write(request,"SearchAjaxAction: last="+searchForm.getLast()+", first="+searchForm.getFirst()+
					", names="+nameList.length);
			return "search-ajax.jsp";
			
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
    
    private Name[] merge(Entry[] entryList, Entry[] spouseList) {
    	Name[] nameList = new Name[entryList.length + spouseList.length];
    	int pos = 0;
    	
    	for (Entry e : entryList) {
    		Name n = new Name();
    		n.setId(e.getId());
    		n.setFirstNames(e.getFirstNames());
    		n.setLastName(e.getLastName());
    		nameList[pos] = n;
    		pos++;
    	}
    	
    	for (Entry e : spouseList) {
    		Name n = new Name();
    		n.setId(e.getId());
    		n.setFirstNames(e.getSpouseFirst());
    		n.setLastName(e.getSpouseLast());
    		nameList[pos] = n;
    		pos++;
    	}

    	Arrays.sort(nameList, new Comparator<Name>() {
    		public int compare(Name n1, Name n2) {
    			int c = n1.getLastName().compareToIgnoreCase(n2.getLastName());
    			if (c != 0) return c;
    			return n1.getFirstNames().compareToIgnoreCase(n2.getFirstNames());
    		}
    	});
    	
    	return nameList;
    }
}
