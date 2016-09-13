package edu.cmu.cs.webapp.todolist2.dao;

import java.util.HashMap;
import java.util.Map;

import edu.cmu.cs.webapp.todolist2.databean.User;

public class UserDAO {
    private Map<String, User> userMap = new HashMap<String, User>();
    private BeanCloner<User> cloner = new BeanCloner<>(User.class);

    public void create(User newUser) throws MyDAOException {
        synchronized (userMap) {
            User existingUser = userMap.get(newUser.getUserName());
            if (existingUser != null) {
                throw new MyDAOException(
                        "User with this userName already exists: "
                                + existingUser.getUserName());
            }
            
            userMap.put(newUser.getUserName(), cloner.clone(newUser));
        }
    }

    public User read(String userName) throws MyDAOException {
        synchronized (userMap) {
            return cloner.clone(userMap.get(userName));
        }
    }
}
