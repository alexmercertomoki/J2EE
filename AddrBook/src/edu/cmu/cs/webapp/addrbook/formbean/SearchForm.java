package edu.cmu.cs.webapp.addrbook.formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class SearchForm extends FormBean {
	private String last;
	private String first;
	
	public String getLast()  { return last;  }
	public String getFirst() { return first; }
	
	public void setLast(String s)  { last  = s.trim(); }
	public void setFirst(String s) { first = s.trim(); }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		
		if (last == null && first == null) {
			errors.add("Must specify start of last name or start of first name");
			return errors;
		}

		// Later processing wants empty strings and no null strings, so clean them up.
		if (last == null) last = "";
		if (first == null) first = "";
		
		if (last.length() == 0 && first.length() == 0) {
			errors.add("Must specify part of last name or part of first name");
			return errors;
		}
		
		
		return errors;
	}

}
