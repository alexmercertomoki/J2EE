package edu.cmu.cs.webapp.addrbook.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.addrbook.databean.Entry;
import edu.cmu.cs.webapp.addrbook.databean.User;
import edu.cmu.cs.webapp.addrbook.formbean.EntryForm;
import edu.cmu.cs.webapp.addrbook.formbean.LoginForm;
import edu.cmu.cs.webapp.addrbook.model.EntryDAO;
import edu.cmu.cs.webapp.addrbook.model.LogDAO;
import edu.cmu.cs.webapp.addrbook.model.Model;

public class UpdateEntryAction extends Action {
	private static FormBeanFactory<EntryForm> formBeanFactory = FormBeanFactory.getInstance(EntryForm.class);
	
	private EntryDAO entryDAO;
	private LogDAO   logDAO;

    public UpdateEntryAction(Model model) {
		entryDAO = model.getEntryDAO();
		logDAO   = model.getLogDAO();
	}

    public String getName() { return "update-entry.do"; }

    public String perform(HttpServletRequest request) {
        try {
			request.setAttribute("numEntries",entryDAO.getCount());

			// Must be logged in for this one.  No redirect.
	        User user = (User) request.getSession(true).getAttribute("user");
			if (user == null) {
		        request.setAttribute("form",new LoginForm());
				return "login.jsp";
			}
			
			EntryForm form = formBeanFactory.create(request);
			request.setAttribute("form",form);
	    	List<String> errors = form.getValidationErrors();
	        request.setAttribute("errors",errors);
	    	if (errors.size() > 0) return "edit-form.jsp";

	    	int id = form.getIdNum();
	    	if (id == 0) {
	    		return createCase(request,form);
	    	}
	    	
	    	return updateCase(request,form);
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
    
    private String createCase(HttpServletRequest request, EntryForm form) throws RollbackException {
		// Create case
		Entry entry = new Entry();
    	copyFormPropsToDataBean(form,entry);
    	entry.setUpdated(new java.util.Date());
    	
		entryDAO.createAutoIncrement(entry);
		
    	logCreate(request,entry);
		request.setAttribute("numEntries",entryDAO.getCount());  // It's now one bigger
		request.setAttribute("entry",entry);
    	request.setAttribute("message","Created record for "+entry.getLastName()+", "+entry.getFirstNames());
    	return "display-entry.jsp";
    }
    
    private String updateCase(HttpServletRequest request, EntryForm form) throws RollbackException {
    	// Update case
    	Entry newEntry = new Entry();
    	copyFormPropsToDataBean(form,newEntry);
    	newEntry.setUpdated(new java.util.Date());
    	
    	try {
    		Entry oldEntry = entryDAO.update(form.getDigest(),newEntry);
    		logUpdate(request,oldEntry,newEntry);
			request.setAttribute("entry",newEntry);
	    	request.setAttribute("message","Updated record for "+newEntry.getLastName()+", "+newEntry.getFirstNames());
	    	return "display-entry.jsp";
    	} catch (RollbackException e) {
    		// Perhaps someone else was edited this entry.  Try looking up the entry.  If we can
    		// find it let's redisplay the entry for editing along with the DAOException's message.
    		// Otherwise, just rethrow it.
    		Entry dbEntry = entryDAO.read(form.getIdNum());
    		if (dbEntry == null) throw e;
    		
			request.setAttribute("entry",dbEntry);
    		request.setAttribute("digest",entryDAO.computeDigest(dbEntry));
			
			List<String> errors = new ArrayList<String>();
			errors.add(e.getMessage());
			errors.add("Try again.  Below are the entry's current values.");
			
	    	request.setAttribute("errors",errors);
    		return "edit-entry.jsp";
    	}
    }
    
    private void copyFormPropsToDataBean(EntryForm form, Entry dataBean) {
    	dataBean.setId(            form.getIdNum()         );
    	dataBean.setAdditional(    form.getAdditional()    );
    	dataBean.setAddress(       form.getAddress()       );
    	dataBean.setBirthday(      form.getBirthdayAsDate());
    	dataBean.setCellPhone(     form.getCellPhone()     );
    	dataBean.setCity(          form.getCity()          );
    	dataBean.setCountry(       form.getCountry()       );
    	dataBean.setEmail(         form.getEmail()         );
    	dataBean.setFax(           form.getFax()           );
    	dataBean.setFirstNames(    form.getFirstNames()    );
    	dataBean.setHomePhone(     form.getHomePhone()     );
    	dataBean.setLastName(      form.getLastName()      );
    	dataBean.setReceivedCards( form.getReceivedCards() );
    	dataBean.setSentCards(     form.getSentCards()     );
    	dataBean.setSpouseBirthday(form.getSpouseBirthdayAsDate());
    	dataBean.setSpouseCell(    form.getSpouseCell()    );
    	dataBean.setSpouseEmail(   form.getSpouseEmail()   );
    	dataBean.setSpouseFirst(   form.getSpouseFirst()   );
    	dataBean.setSpouseLast(    form.getSpouseLast()    );
    	dataBean.setSpouseWork(    form.getSpouseWork()    );
    	dataBean.setState(         form.getState()         );
    	dataBean.setWorkPhone(     form.getWorkPhone()     );
    	dataBean.setZip(           form.getZip()           );
    }

    private void logChanges(HttpServletRequest request, Entry oldEntry, Entry newEntry) throws RollbackException {
    	logIfChanged(request, "additional",     oldEntry.getAdditional(),     newEntry.getAdditional()    );
    	logIfChanged(request, "address",        oldEntry.getAddress(),        newEntry.getAddress()       );
    	logIfChanged(request, "birthday",       oldEntry.getBirthday(),       newEntry.getBirthday()      );
    	logIfChanged(request, "cellPhone",      oldEntry.getCellPhone(),      newEntry.getCellPhone()     );
    	logIfChanged(request, "city",           oldEntry.getCity(),           newEntry.getCity()          );
    	logIfChanged(request, "country",        oldEntry.getCountry(),        newEntry.getCountry()       );
    	logIfChanged(request, "email",          oldEntry.getEmail(),          newEntry.getEmail()         );
    	logIfChanged(request, "fax",            oldEntry.getFax(),            newEntry.getFax()           );
    	logIfChanged(request, "firstNames",     oldEntry.getFirstNames(),     newEntry.getFirstNames()    );
    	logIfChanged(request, "homePhone",      oldEntry.getHomePhone(),      newEntry.getHomePhone()     );
    	logIfChanged(request, "lastName",       oldEntry.getLastName(),       newEntry.getLastName()      );
    	logIfChanged(request, "receivedCards",  oldEntry.getReceivedCards(),  newEntry.getReceivedCards() );
    	logIfChanged(request, "sentCards",      oldEntry.getSentCards(),      newEntry.getSentCards()     );
    	logIfChanged(request, "spouseBirthday", oldEntry.getSpouseBirthday(), newEntry.getSpouseBirthday());
    	logIfChanged(request, "spouseCell",     oldEntry.getSpouseCell(),     newEntry.getSpouseCell()    );
    	logIfChanged(request, "spouseEmail",    oldEntry.getSpouseEmail(),    newEntry.getSpouseEmail()   );
    	logIfChanged(request, "spouseFirst",    oldEntry.getSpouseFirst(),    newEntry.getSpouseFirst()   );
    	logIfChanged(request, "spouseLast",     oldEntry.getSpouseLast(),     newEntry.getSpouseLast()    );
    	logIfChanged(request, "spouseWork",     oldEntry.getSpouseWork(),     newEntry.getSpouseWork()    );
    	logIfChanged(request, "state",          oldEntry.getState(),          newEntry.getState()         );
    	logIfChanged(request, "workPhone",      oldEntry.getWorkPhone(),      newEntry.getWorkPhone()     );
    	logIfChanged(request, "zip",            oldEntry.getZip(),            newEntry.getZip()           );
    }
    
    private void logCreate(HttpServletRequest request, Entry newEntry) throws RollbackException {
       	logDAO.write(request,"update-entry: creating new entry: id="+newEntry.getId());
       	Entry dummyOldEntry = new Entry();
       	logChanges(request,dummyOldEntry,newEntry);
    }
    
    
    private void logUpdate(HttpServletRequest request, Entry oldEntry, Entry newEntry) throws RollbackException {
       	logDAO.write(request,"update-entry: updating entry: id="+newEntry.getId());
       	logChanges(request,oldEntry,newEntry);
    }

    private void logIfChanged(HttpServletRequest request, String fieldName, java.sql.Date oldV, java.sql.Date newV)
    	throws RollbackException
    {
    	if (oldV == null && newV == null) return;

    	// If equals(), no change, so return
    	if (oldV != null && oldV.equals(newV)) return;

    	// The old and new values are not the same, so log the change
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		logDAO.write(request, "     "+fieldName+
				": old=" + (oldV == null ? "null" : sdf.format(oldV))+
				", new=" + (newV == null ? "null" : sdf.format(newV)));
    }

    private void logIfChanged(HttpServletRequest request, String fieldName, String oldV, String newV)
    	throws RollbackException
    {
    	// Null Strings not permitted in this app, but we check in case someone puts them in the database
    	if (oldV == null && newV == null) return;
 
    	// If equals(), no change, so return
    	if (oldV != null && oldV.equals(newV)) return;
    	
    	// The old and new values are not the same, so log the change
		logDAO.write(request, "     "+fieldName + ": old=" + oldV +  ",new=" + newV);
    }
}
