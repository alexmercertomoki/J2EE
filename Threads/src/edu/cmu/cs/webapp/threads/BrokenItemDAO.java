package edu.cmu.cs.webapp.threads;

import java.util.List;
import java.util.Vector;

public class BrokenItemDAO {
    private List<Item> itemList = new Vector<Item>();
    private int lastId = 0;

    public void addToTop(Item item) {
        lastId = lastId + 1;
        sleep();
        item.uniqueId = lastId;
        itemList.add(0, item);
    }

    // Returns the position in list where item was inserted
    // (i.e., the size of the list)
    public int addToBottom(Item item) {
        lastId = lastId + 1;
        sleep();
        item.uniqueId = lastId;
        itemList.add(item);
        sleep();
        return itemList.size();
    }

    public void delete(int position) {
        itemList.remove(position);
    }

    public Item getItem(int position) {
        sleep();
        return itemList.get(position);
    }

    public Item[] getItems() {
        Item[] answer = new Item[itemList.size()];

        for (int i = 0; i < itemList.size(); i++) {
            sleep();
            answer[i] = itemList.get(i);
        }

        return answer;
    }

    public int size() {
        return itemList.size();
    }

    private void sleep() {
        // The concurrency control problems happen more often
        // when these sleeps occur.
        try {
            Thread.sleep(100); // sleep 100 milliseconds
        } catch (InterruptedException e) {
            // We were woken up early...oh well, who needs sleep anyway.
        }
    }
}
