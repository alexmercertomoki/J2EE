package edu.cmu.cs.webapp.todolist4.formbean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class ItemForm {
    private String item;

    public ItemForm(HttpServletRequest request) {
        item = sanitize(request.getParameter("item"));
    }

    public String getItem() {
        return item;
    }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (item == null || item.length() == 0) {
            errors.add("Item is required");
        }

        return errors;
    }

    private String sanitize(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;")
                .replace(">", "&gt;").replace("\"", "&quot;");
    }
}
