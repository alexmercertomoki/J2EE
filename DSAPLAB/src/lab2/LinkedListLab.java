package lab2;

/*******************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Lab 2 LinkedList (Singly) Operation Implementation
 *
 * Andrew ID:bhuang
 * Name: Bilei Huang	
 *
 *******************************************************/

import java.util.*;

public class LinkedListLab<AnyType> implements Iterable<AnyType> {
	private Node<AnyType> head;

	public LinkedListLab() {
		head = null;
	}

	/**
	 * insert a new item at the end
	 * @param item data item to be inserted
	 */
	
	public void insert(AnyType item) {
		if (head == null)
			head = new Node<AnyType>(item, head);
		else {
			Node<AnyType> tmp = head;
			while (tmp.next != null)
				tmp = tmp.next;
			tmp.next = new Node<AnyType>(item, null);
		}
	}

	/**
	 * Find object that is kth to the last node of linkedlist
	 *
	 * @param k
	 *            kth position to the last. 1 means the last node
	 * @return Object that is located at kth to the last
	 */
	public AnyType kthToLast(int k) {
		
		    // two nodes tmp2  is ahead one tmp2 the kth 
			Node<AnyType> tmp1 = head;
			Node<AnyType> tmp2 = head;
			//if head is null return null
			if(head==null){
				return null;
			}
			// if k is less or equal to 0 return null
			if(k<=0){
				return null;
			}
			//if k > length of the list return null
			int len = this.lengList();
			if(k>len){
				return null;
			}
			
			// let tmp2 go ahead
			for(int i=0;i<k-1;i++){
				tmp2=tmp2.next;
			}
			
			//let tmp1 and tmp2 go together until tmp2 go the the end
			while (tmp2.next != null){
				tmp2 = tmp2.next;
				tmp1 = tmp1.next;
			}
			//return the data in the tmp1 
			return (AnyType) tmp1.data;
			
	}
	
	public int lengList(){
		int count=1;
		if(head== null){
			return 0;
		}
		Node<AnyType> temp = head;
		
		while(temp.next!=null){
			temp=temp.next;
			count++;
		}
		return count;
	}

	/**
	 * Returns a string representation
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Object x : this)
			result.append(x).append(" ");

		return result.toString();
	}

	@Override
	public Iterator<AnyType> iterator() {
		return new LinkedListIterator();
	}

	/******************************************************
	 *
	 * non-static nested class for Iterator implementation
	 *
	 ******************************************************/
	private class LinkedListIterator implements Iterator<AnyType> {
		private Node<AnyType> nextNode;

		public LinkedListIterator() {
			nextNode = head;
		}

		public boolean hasNext() {
			return nextNode != null;
		}

		public AnyType next() {
			if (!hasNext())
				throw new NoSuchElementException();
			AnyType result = nextNode.data;
			nextNode = nextNode.next;
			return result;
		}

		// not supporting remove()
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/******************************************************
	 *
	 * Node (static nested class)
	 *
	 ******************************************************/
	private static class Node<AnyType> {
		private AnyType data;
		private Node<AnyType> next;

		public Node(AnyType data, Node<AnyType> next) {
			this.data = data;
			this.next = next;
		}
	}

	/*
	 * A few simple test cases!
	 */
	public static void main(String[] args) {
		LinkedListLab<String> theList = new LinkedListLab<String>();
		theList.insert("data");
		theList.insert("strutures");
		theList.insert("rock");
		theList.insert("the");
		theList.insert("world");
		theList.insert("way");
		theList.insert("to");
		theList.insert("go");
		theList.insert("dude");

		System.out.println("values:" + theList);

		// should print null
		System.out.println("0:" + theList.kthToLast(0));

		// should print "dude"
		System.out.println("1:" + theList.kthToLast(1));

		// should print "go"
		System.out.println("2:" + theList.kthToLast(2));

		// should print "to"
		System.out.println("3:" + theList.kthToLast(3));

		// should print data
		System.out.println("9:" + theList.kthToLast(9));
	}

}