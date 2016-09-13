package edu.cmu.cs.webapp.todolist7.model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

import edu.cmu.cs.webapp.todolist7.databean.User;

public class UserDAO extends GenericDAO<User> {
    public UserDAO(ConnectionPool cp, String tableName) throws DAOException {
        super(User.class, tableName, cp);
    }
}
