package lab6;

/***********************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Lab 6. Comparing BST with Ordered Array and Linked List
 *
 * Binary Search Tree interface
 *
 ***********************************************************/

public interface BSTInterface {

	/**
	 * search a value in the tree
	 *
	 * @param key
	 *            key value to search
	 * @return boolean value indication success or failure
	 */
	boolean find(int key);

	/**
	 * insert a new element into the tree
	 *
	 * @param key
	 *            key of the element
	 * @param value
	 *            value of the element
	 */
	void insert(int key);

	/**
	 * delete a value from the tree
	 *
	 * @param key
	 *            key of the element to be deleted
	 */
	void delete(int key);

	/**
	 * traverse the tree and print values of the tree
	 */
	void traverse();

}