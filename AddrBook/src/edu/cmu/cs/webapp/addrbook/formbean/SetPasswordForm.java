package edu.cmu.cs.webapp.addrbook.formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class SetPasswordForm extends FormBean {
	private String confirmPassword = "";
	private String newPassword     = "";
	private String userName        = "";
	
	public String getConfirmPassword() { return confirmPassword; }
	public String getNewPassword()     { return newPassword;     }
	public String getUserName()        { return userName;        }
	
	public void setConfirmPassword(String s) { confirmPassword = s.trim(); }
	public void setNewPassword(String s)     { newPassword     = s.trim(); }
	public void setUserName(String s)        { userName        = s.trim(); }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (newPassword.length() == 0) {
			errors.add("New Password is required");
		}
		
		if (confirmPassword.length() == 0) {
			errors.add("Confirm Pwd is required");
		}
		
		if (userName.length() == 0) {
			errors.add("Hidden value \"userName\" not set");
		}
		
		if (errors.size() > 0) return errors;
		
		if (!newPassword.equals(confirmPassword)) {
			errors.add("New Password and Confirm Pwd do not match");
		}

		return errors;
	}
}
