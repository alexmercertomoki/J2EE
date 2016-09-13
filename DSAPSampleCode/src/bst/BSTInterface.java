package bst;

/********************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Lecture 15 Binary Trees, mainly Binary Search Trees
 *
 * A very simple Binary Search Tree interface
 *
 * No duplicate keys allowed
 *
 ********************************************************/

public interface BSTInterface {

	/**
	 * search a value in the tree
	 *
	 * @param key
	 *            key value to search
	 * @return boolean value indication of success or failure
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
	void insert(int key, double value);

	/**
	 * delete an element from the tree using key
	 *
	 * @param key
	 *            key of the element to be deleted
	 */
	void delete(int key);

	/**
	 * traverse the tree and print values of the tree
	 * in ascending order based on key
	 */
	void traverse();

}