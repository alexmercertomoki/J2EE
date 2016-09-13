package homework3;


/************************************************************
 *
 * 08-722 Data Structures for Applications Programmers Homework Assignment 3
 * SortedLinkedList Implementation with Recursion
 *
 * Andrew ID: bhuang Name: Bilei Huang
 *
 *
 ************************************************************/

public class SortedLinkedList implements MyListInterface {

	private Node head;

	/**********************************************************
	 * 
	 * Static Nested Node Class with String data
	 * 
	 **********************************************************/

	// the node class
	private static class Node {
		// the data string
		private String data;
		// the next node
		private Node next;

		// initiation
		public Node(String data, Node next) {

			this.data = data;
			this.next = next;

		}

	}

	// no parameter initiation initiate the head to null
	public SortedLinkedList() {
		head = null;
	}

	// initiate with string of array
	public SortedLinkedList(String[] unsorted) {
		// if the array is null return
		if (unsorted == null) {
			return;
		}
		// if not null add in
		this.addStringArr(unsorted, 0);

	}

	// adding array helper with call its self recursively
	public void addStringArr(String[] list, int index) {

		// if index is equal to the length we stop
		if (index == list.length) {
			return;
		} else {
			// if the value in list[index] is not null add
			if (list[index] != null) {
				this.add(list[index]);
			}
			// index plus one
			index++;
			// calling itself
			addStringArr(list, index);

		}

	}

	// The adding method
	@Override
	public void add(String value) {
		// if should not be added in
		if (value == null || value.length() == 0 || !value.matches("[a-zA-Z]+")) {
			return;
		}
		// if head is null
		if (head == null) {
			// head initiation
			head = new Node(value, null);
		}
		// if head is not null
		if (head != null) {

			if (head.data.compareTo(value) > 0) {
				// add before head
				head = new Node(value, head);
			}
		}
		// call the recursive method
		this.addHelper(value, head);

	}

	// the recursive add helper which calling itself
	public void addHelper(String value, Node n) {
		// we compare them first if equals to value
		if (n.data.compareTo(value) == 0) {
			return;
			// if the next value is null
		} else if (n.next == null) {
			n.next = new Node(value, null);
			// if the n.next value is samller than the value
		} else if (n.next.data.compareTo(value) < 0) {
			// calling helper again
			addHelper(value, n.next);
			// if the data is equal to the value return
		} else if (n.next.data.compareTo(value) == 0) {
			return;
		}
		// last case
		else {
			// initiate the node after n
			n.next = new Node(value, n.next);
		}

	}

	// checking the size of the list
	@Override
	public int size() {
		// call the recursive method
		return this.countSize(head, 0);
	}

	// the count recursive helper
	public int countSize(Node n, int count) {
		// if head is null
		if (n == null) {
			// return 0
			return count;
		} else {
			// calling itself count +1
			return countSize(n.next, ++count);
		}
	}

	// display method
	@Override
	public void display() {
		// display the [ before the array and ] after
		System.out.print("[");
		this.displayHelper(head);
		System.out.print("]\n");

	}

	// the recursive helper for display
	public void displayHelper(Node n) {
		// if head is not null
		if (n != null) {
			// print out the data
			System.out.print(n.data);
			// if the node after n is not null
			if (n.next != null) {
				// print a , and space and continue
				System.out.print(", ");
				// calling itself again
				displayHelper(n.next);
			}
		}

	}

	// find if the array contains a certain word
	@Override
	public boolean contains(String key) {
		// test if matching for looking
		if (key == null || key.length() == 0 || !key.matches("[a-zA-Z]+")) {
			return false;
		}
		// if yes go on
		return this.containHelper(key, head);
	}

	public boolean containHelper(String key, Node n) {
		// if find until the last return false
		if (n == null) {

			return false;

		}
		// if found return true
		else if (n.data.equals(key)) {

			return true;

		}
		// else recursive case
		else {

			return containHelper(key, n.next);

		}

	}

	// find whether the list is empty
	@Override
	public boolean isEmpty() {
		// head is null then it is empty
		return head == null;

	}

	// remove the head node
	@Override
	public String removeFirst() {
		// if head is null list is empty return null
		if (head == null) {
			return null;
		}
		// or we get the value remove the head and return
		String headvalue;
		headvalue = head.data;
		head = head.next;
		return headvalue;
	}

	// remove at a certain index
	@Override
	public String removeAt(int index) {
		// if the index is not in the rage
		if (index < 0 || index > this.size() - 1) {
			return null;
		}
		// index is 0 it is the first node
		else if (index == 0) {
			return this.removeFirst();
		}
		// or we
		return removeAtHelper(index, head, 0);

	}

	// the helper for calling recursively to remove a certain one
	public String removeAtHelper(int index, Node n, int count) {
		// count until the index to remove because this is a linkedlist
		// we usually have to iterate through to get a certain node
		// the base case is we find the index
		if (count == index - 1) {
			Node temp = n.next;
			n.next = temp.next;
			return temp.data;
		}
		// the recursive case
		else {
			removeAtHelper(index, n.next, ++count);
		}
		// we don't find anything: this is not possible though
		// because we limit the index before the method
		return null;
	}

}