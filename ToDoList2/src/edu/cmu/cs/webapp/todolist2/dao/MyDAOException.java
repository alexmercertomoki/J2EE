package edu.cmu.cs.webapp.todolist2.dao;

public class MyDAOException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public MyDAOException(Exception e) { super(e); }
	public MyDAOException(String s)    { super(s); }
}
