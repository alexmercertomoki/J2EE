package edu.cmu.cs.webapp.todolist7.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.todolist7.formbean.IdForm;
import edu.cmu.cs.webapp.todolist7.model.ItemDAO;
import edu.cmu.cs.webapp.todolist7.model.Model;

public class DeleteAction extends Action {
    private FormBeanFactory<IdForm> idFormFactory = FormBeanFactory
            .getInstance(IdForm.class);

    private ItemDAO itemDAO;

    public DeleteAction(Model model) {
        itemDAO = model.getItemDAO();
    }

    public String getName() {
        return "delete.do";
    }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);

        try {
            IdForm form = idFormFactory.create(request);
            errors.addAll(form.getValidationErrors());
            if (errors.size() > 0) {
                return "error.jsp";
            }

            itemDAO.delete(form.getIdAsInt());

            request.setAttribute("items", itemDAO.getItems());
            return "todolist.jsp";

        } catch (RollbackException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        } catch (FormBeanException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
    }
}
