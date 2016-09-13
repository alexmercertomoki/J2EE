package edu.cmu.cs.webapp.addrbook.formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class DeleteUserForm extends FormBean {
	private String button;
	private String userName;
	
	public String getButton()   { return button;   }
	public String getUserName() { return userName; }
	
	public void setButton(String s)   { button   = s.trim(); }
	public void setUserName(String s) { userName = s.trim(); }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (button == null || button.length() == 0) {
			errors.add("Button value is required");
		}
		
		if (userName == null || userName.length() == 0) {
			errors.add("Hidden value \"userName\" not set");
		}
		
		return errors;
	}
}
