package edu.cmu.cs.webapp.addrbook.controller;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

public abstract class Action {

    // Returns the name of the action, used to match the request in the hash table
    public abstract String getName();

    // Returns the name of the jsp used to render the output.
    public abstract String perform(HttpServletRequest request);

    //
    // Class methods to manage dispatching to Actions
    //
    private static Hashtable<String,Action> hash = new Hashtable<String,Action>();

    public static void add(Action a) {
        hash.put(a.getName(),a);
    }

    public static String perform(String name,HttpServletRequest request) {
        Action a = hash.get(name);
        if (a == null) return null;
        return a.perform(request);
    }
}
