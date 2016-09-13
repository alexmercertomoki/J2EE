package edu.cmu.cs.webapp.addrbook.controller;

import javax.servlet.http.HttpServletRequest;

import edu.cmu.cs.webapp.addrbook.model.Model;

public class LogoutAction extends Action {

	public LogoutAction(Model model) {
	}

	public String getName() { return "logout.do"; }

	public String perform(HttpServletRequest request) {
        request.getSession(true).setAttribute("user",null);
        
        // Now redirect back to the top of the site so that
        // the login will be done correctly according to the controller's rules

        return "/";
    }
}
