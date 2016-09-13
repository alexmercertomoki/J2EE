package edu.cmu.cs.webapp.threads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class to access a list of items.
 * This implementation uses a list in memory.
 * (Future versions will keep the list in a permanent storage.)
 * @author Jeff Eppinger
 *
 */
public class ItemDAO {
    private List<Item> itemList = new ArrayList<Item>();
    private int lastId = 0;

    /**
     * Add item to top of the list.
     * Note: the unique id field of the item is set to a new unique id value.
     * @param item reference to item object to be inserted into the list.
     */
    public synchronized void addToTop(Item item) {
        lastId = lastId + 1;
        item.uniqueId = lastId;

        itemList.add(0, clone(item));
    }

    /**
     * Add item to bottom of list.
     * Note: the unique id field of the item is set to a new unique id value.
     * @param item reference to item object to be inserted into the list.
     * @return position in the list where item was stored
     */
    public synchronized int addToBottom(Item item) {
        lastId = lastId + 1;
        item.uniqueId = lastId;

        itemList.add(clone(item));
        return itemList.size();
    }

    /**
     * Deletes an item from the list
     * @param id unique id of the item to be deleted.
     */
    public synchronized void delete(int id) {
        Iterator<Item> iterator = itemList.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.uniqueId == id) {
                iterator.remove();
            }
        }
    }

    /**
     * Get all the items in the list.
     * @return an array containing all of the items in the list.
     */
    public synchronized Item[] getItems() {
        Item[] answer = new Item[itemList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = clone(itemList.get(i));
        }
        return answer;
    }

    /**
     * Returns the number of items in the list.
     * @return the number of items in the list.
     */
    public synchronized int size() {
        return itemList.size();
    }
    
    /**
     * Returns a copy of the item.
     * @param item object to be copied.
     * @return copy of the item passed in.
     */
    private Item clone(Item item) {
        Item copy      = new Item();
        copy.text      = item.text;
        copy.uniqueId  = item.uniqueId;
        copy.ipAddress = item.ipAddress;
        return copy;
    }
}