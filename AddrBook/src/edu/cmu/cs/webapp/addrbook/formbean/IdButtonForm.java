package edu.cmu.cs.webapp.addrbook.formbean;

import java.util.List;

public class IdButtonForm extends IdForm {
	private String button;
	
	public String getButton()   { return button;   }
	
	public void setButton(String s)   { button   = s.trim(); }

	public List<String> getValidationErrors() {
		List<String> errors = super.getValidationErrors();

		if (button == null || button.length() == 0) {
			errors.add("Button value is required");
		}
		
		return errors;
	}
	
	public boolean isPresent() {
		if (button != null) return true;
		return super.isPresent();
	}
}
