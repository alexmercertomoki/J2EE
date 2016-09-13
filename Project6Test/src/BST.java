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


public class BST<T extends Comparable<T>> implements Iterable<T>,
		BSTInterface<T> {
	
	private int numberOfNodes = 0;
	private Node<T> root;
	private Comparator<T> comparator;

	public BST() {
		this(null);
	}

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
		return comparator;
	}

	/**
	 * Returns the root data of this tree.
	 *
	 * @return root data
	 */
	public T getRoot() {
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
		
		int realheight = this.heightHelper(root);
			return realheight;

	}

	public int heightHelper(Node<T> rt) {
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

		Node<T> newN = new Node<T>(toSearch);
		return searchHelper(newN, root);

	}

	public T searchHelper(Node<T> search, Node<T> next) {
		
		if(next==null){
			return null;
		}
		
		int cmp;
		if (comparator == null) {
			cmp = next.data.compareTo(search.data);
		}
		else {
			cmp = comparator.compare(next.data, search.data);
		}
		
		if (cmp == 0) {
			return next.data;
		}
		else if (cmp > 0) {
			return searchHelper(search, next.left);
		}
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
		Node<T> newNode = new Node<T>(toInsert);
		if (root == null) {
			root = newNode;
			numberOfNodes++;
		} else {

			insertHelper(newNode, root);

		}

	}

	public void insertHelper(Node<T> val, Node<T> next) {

		if (comparator == null) {

			if (next.data.compareTo(val.data) == 0) {
				return;
			}

			else if (next.data.compareTo(val.data) > 0) {
				if (next.left != null) {
					insertHelper(val, next.left);
				} else {
					next.left = val;
					numberOfNodes++;
					return;
				}
			} else if (next.data.compareTo(val.data) < 0) {
				if (next.right != null) {
					insertHelper(val, next.right);
				} else {
					next.right = val;
					numberOfNodes++;
					return;
				}
			}
		}
		else{
			if(comparator.compare(next.data, val.data)==0){
				return;
			}else if (comparator.compare(next.data, val.data) > 0) {
				if (next.left != null) {
					insertHelper(val, next.left);
				} else {
					next.left = val;
					numberOfNodes++;
					return;
				}
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
		
		return new SIterator();

	}
	
	private class SIterator implements Iterator<T>{
		
		Stack<Node<T>> stack;
		
		public SIterator(){
			stack=new Stack<Node<T>>();
			Node<T> node = root;
			while(node!=null){
				stack.push(node);
				node=node.left;
			}
		}
		
		public boolean hasNext(){
			return !stack.isEmpty();
		}
		public T next(){
			
			Node<T> node = stack.pop();
			T  atype=(T) node.data;
			if(node.right!=null){
				node=node.right;
				while(node!=null){
					stack.push(node);
					node = node.left;
				}
			}
			
			return atype;
			
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
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
	 * For a very simple debug purpose:
	 *
	 * Test your BST with this first to make sure your BST works. But, this is a
	 * starting point. Should test more!
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