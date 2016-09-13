/*****************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Homework 6: Building Index using BST
 *
 * Andrew ID: bhuang
 * Name:Bilei Huang
 *
 *****************************************************/

import java.lang.ProcessBuilder.Redirect;
import java.util.*;

/**
 * Binary search tree to get the index 
 *
 */

public class BST<T extends Comparable<T>> implements Iterable<T>,
		BSTInterface<T> {
	// number of nodes
	private int numberOfNodes = 0;
	// root of tree
	private Node<T> root;
	// comparator passed in 
	private Comparator<T> comparator;
	
	// constructor 
	public BST() {
		this(null);
	}
	// constructor with comparator 
	public BST(Comparator<T> comparator) {
		this.comparator = comparator;
		root = null;
	}

	/**
	 * Returns the comparator used to order this collection.
	 *
	 * @return comparator
	 */
	public Comparator<T> comparator() {
		// return comparator 
		return comparator;
	}

	/**
	 * Returns the root data of this tree.
	 *
	 * @return root data
	 */
	public T getRoot() {
		if(root==null)
			return null;
		// return the root data 
		return this.root.data;
	}

	/**
	 * 
	 * Returns the height of this tree. if the tree is empty or tree has only a
	 * root node, then the height of the tree is 0.
	 *
	 * @return int value of the height 
	 * 
	 */

	public int getHeight() {
		//get height 
		int realheight = this.heightHelper(root);
		// null return 0
		if(realheight == -1){
			return 0;
		}	
		return realheight;

	}
	/**
	 * 
	 * get heigh helper get heigh from  
	 *
	 * @return int value of the height but root null is considered -1
	 * 
	 */
	
	public int heightHelper(Node<T> rt) {
		// add one when reaches base case
		if (rt == null) {
			return -1;
		}
		return Math.max(heightHelper(rt.left), heightHelper(rt.right)) + 1;
	}

	/**
	 * 
	 * Returns the number of ndoes in this tree.
	 *
	 * @return int value of the number of nodes.
	 */
	public int getNumberOfNodes() {
		// node number is calculated 
		return this.numberOfNodes;
	}

	/**
	 * Given the value (object) to be searched, it tries to find it.
	 *
	 * @param toSearch
	 *            - value to be searched
	 * @return The value (object) of the search result. If nothing found, null.
	 */
	@Override
	public T search(T toSearch) {
		
		//  the toSearch is null
		if(toSearch==null){
			return null;
		}
		// new Node to search  using search helper  
		Node<T> newN = new Node<T>(toSearch);
		return searchHelper(newN, root);

	}

	public T searchHelper(Node<T> search, Node<T> next) {
		// return  null if search is null
		if(next==null){
			return null;
		}
		//comp is the result after comparison 
		int cmp;
		if (comparator == null) {
			cmp = next.data.compareTo(search.data);
		}
		else {
			cmp = comparator.compare(next.data, search.data);
		}
		// equal 
		if (cmp == 0) {
			return next.data;
		}
		//bigger
		else if (cmp > 0) {
			return searchHelper(search, next.left);
		}
		//smaller 
		else {
			return searchHelper(search, next.right);
		}

	}

	/**
	 * Inserts a value (object) to the tree. No duplicates allowed.
	 *
	 * @param toInsert
	 *            - a value (object) to be inserted to the tree.
	 */

	@Override
	public void insert(T toInsert) {
		// toInsert is null
		if(toInsert==null){
			return ;
		}
		// value to insert 
		Node<T> newNode = new Node<T>(toInsert);
		// root is null 
		if (root == null) {
			// add node to root 
			root = newNode;
			numberOfNodes++;
		} else {
			// insert using insert helper
			insertHelper(newNode, root);

		}

	}
	
	/**
	 * To insert using a certain order 
	 *
	 * @param val  value to insert 
	 * @param next value next  : left or right 
	 *  
	 */

	public void insertHelper(Node<T> val, Node<T> next) {
		
		// if comparator is null
		if (comparator == null) {
			// if equal 
			if (next.data.compareTo(val.data) == 0) {
				return;
			}
			// if the val data is less than next data  see left 
			else if (next.data.compareTo(val.data) > 0) {
				// if not null  go to the next
				if (next.left != null) {
					insertHelper(val, next.left);
				} else {
				//	 if null: add in , if not null 
					next.left = val;
					// node add 1 
					numberOfNodes++;
					return;
				}
				//if val data is bigger than next data 
			} else if (next.data.compareTo(val.data) < 0) {
				// if right is not null go to the next 
				if (next.right != null) {
					insertHelper(val, next.right);
				// if null : add in 
				} else {
					next.right = val;
					numberOfNodes++;
					return;
				}
			}
		}
		else{
			// using comparator do the same thing 
			if(comparator.compare(next.data, val.data)==0){
				// equal return 
				return;
			}else if (comparator.compare(next.data, val.data) > 0) {
				// bigger  to the  left and find null to insert 
				if (next.left != null) {
					insertHelper(val, next.left);
				} else {
					next.left = val;
					numberOfNodes++;
					return;
				}
				// less to the right find null to insert 
			} else if (comparator.compare(next.data, val.data) < 0) {
				if (next.right != null) {
					insertHelper(val, next.right);
				} else {
					next.right = val;
					numberOfNodes++;
					return;
				}
			}
			
		}

	}

	/**
	 * 
	 * In-order iterator
	 * 
	 * @return iterator object
	 * 
	 */
	@Override
	public Iterator<T> iterator() {
		// return the Siterator  
		return new SIterator();

	}
	
	/**
	 * 
	 * In-order iterator obj 
	 * 
	 * 
	 */
	private class SIterator implements Iterator<T>{
		//using a stack to implement
		Stack<Node<T>> stack;
		//  the iterator constructor 
		public SIterator(){
			stack=new Stack<Node<T>>();
			Node<T> node = root;
			while(node!=null){
				stack.push(node);
				node=node.left;
			}
		}
		// the iterator has next method
		public boolean hasNext(){
			return !stack.isEmpty();
		}
		// the next method 
		public T next(){
			Node<T> node = stack.pop();
			T  atype= node.data;
			if(node.right!=null){
				node=node.right;
				while(node!=null){
					stack.push(node);
					node = node.left;
				}
			}
			//returning next obj 
			return atype;
			
		}

		@Override
		public void remove() {

			
		}
		
	}

	// private static nested class for Node
	private static class Node<T> {
		private T data;
		private Node<T> left;
		private Node<T> right;

		public Node(T data) {
			this(data, null, null);
		}

		public Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return data.toString();
		}
	}

	/***********************************************************
	 *
	 *
	 *
	 * For a very simple debug purpose:
	 *
	 * Test your BST with this first to make sure your BST works. But, this is a
	 * starting point. Should test more!
	 * 
	 *
	 *
	 ***********************************************************/
	public static void main(String[] args) {

		BST<Integer> b = new BST<Integer>();
		int[] ar = { 1,2,3,4,5,6};
		for (Integer x : ar)
			b.insert(x);

		for (Integer x : b)
			System.out.print(x + " ");

		System.out.println();
		System.out.println(b.search(8));
		System.out.println(b.getHeight());
		System.out.println(b.getNumberOfNodes());

	}

}