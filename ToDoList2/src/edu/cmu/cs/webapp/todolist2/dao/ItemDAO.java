package edu.cmu.cs.webapp.todolist2.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.cmu.cs.webapp.todolist2.databean.ItemBean;

public class ItemDAO {
    private List<ItemBean> list = new ArrayList<ItemBean>();
    private BeanCloner<ItemBean> cloner = new BeanCloner<>(ItemBean.class);
    
    private int lastUniqueId = 0;
    private int minPosition  = 0;
    private int maxPosition  = 0;

    public synchronized void addToTop(ItemBean b) throws MyDAOException {
        lastUniqueId = lastUniqueId + 1;

        if (list.size() == 0) {
            minPosition = 1;
            maxPosition = 1;
        } else {
            minPosition = minPosition - 1;
        }

        b.setId(lastUniqueId);
        b.setPosition(minPosition);

        list.add(cloner.clone(b));
    }

    public synchronized void addToBottom(ItemBean b) throws MyDAOException {
        lastUniqueId = lastUniqueId + 1;

        if (list.size() == 0) {
            minPosition = 1;
            maxPosition = 1;
        } else {
            maxPosition = maxPosition + 1;
        }

        b.setId(lastUniqueId);
        b.setPosition(maxPosition);

        list.add(cloner.clone(b));
    }

    public synchronized void delete(int id) throws MyDAOException {
        Iterator<ItemBean> iter = list.iterator();
        while (iter.hasNext()) {
            ItemBean b = iter.next();
            if (b.getId() == id) {
                iter.remove();
                return;
            }
        }

        throw new MyDAOException("No item found with id = " + id);
    }

    public synchronized ItemBean[] getItems() throws MyDAOException {
        ItemBean[] answer = new ItemBean[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = cloner.clone(list.get(i));
        }
        
        return answer;
    }

    public synchronized int size() throws MyDAOException {
        return list.size();
    }
}
