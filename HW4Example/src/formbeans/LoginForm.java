package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class LoginForm extends FormBean {
	private String userName;
	private String password;
	
	public String getUserName()  { return userName; }
	public String getPassword()  { return password; }
	
	public void setUserName(String s) { userName = trimAndConvert(s,"<>\"");  }
	public void setPassword(String s) {	password = s.trim();                  }

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