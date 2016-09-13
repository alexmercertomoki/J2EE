package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;
import model.PhotoDAO;
import model.UserDAO;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.Photo;
import databeans.User;
import formbeans.IdForm;

/*
 * Move a photo up inthe list.  Given an "id" parameter.
 * The DAO checks to see that id is valid number for a photo and that
 * the logged user is the owner.
 * 
 * Sets up the "userList" and "photoList" request attributes
 * and if successful, forwards back to to "manage.jsp".
 */
public class MoveUpAction extends Action {
	private FormBeanFactory<IdForm> formBeanFactory = FormBeanFactory.getInstance(IdForm.class);

	private PhotoDAO photoDAO;
	private UserDAO  userDAO;

    public MoveUpAction(Model model) {
    	photoDAO = model.getPhotoDAO();
    	userDAO  = model.getUserDAO();
	}

    public String getName() { return "move-up.do"; }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            // Set up user list for nav bar
			request.setAttribute("userList",userDAO.getUsers());

			IdForm form = formBeanFactory.create(request);

			User user = (User) request.getSession().getAttribute("user");

			int id = form.getIdAsInt();
    		photoDAO.moveUp(id,user.getUserName());

    		// Be sure to get the photoList after the delete
        	Photo[] photoList = photoDAO.getPhotos(user.getUserName());
	        request.setAttribute("photoList",photoList);

	        return "manage.jsp";
		} catch (RollbackException e) {
    		errors.add(e.getMessage());
    		return "error.jsp";
		} catch (FormBeanException e) {
    		errors.add(e.getMessage());
    		return "error.jsp";
    	}
    }
}
