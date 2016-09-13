package edu.cmu.cs.webapp.addrbook.formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class LoginForm extends FormBean {
	private String userName;
	private String password;
	private String redirect;
	
	public String getUserName()  { return userName; }
	public String getPassword()  { return password; }
	public String getRedirect()  { return redirect; }
	
	public void setUserName(String s)  { userName = s.trim(); }
	public void setPassword(String s)  { password = s.trim(); }
	public void setRedirect(String s)  { redirect = s.trim(); }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (userName == null || userName.length() == 0) {
			errors.add("User Name is required");
		}

		if (password == null || password.length() == 0) {
			errors.add("Password is required");
		}
		
		return errors;
	}
}
