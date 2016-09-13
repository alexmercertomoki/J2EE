package lab6;

/**************************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Lab 6. Comparing BST with Ordered Array and Linked List
 *
 * Andrew ID:bhuang
 * Name:Bilei Huang
 *
 **************************************************************/
import java.util.*;

public class BSTComparison {
	private static BST theBST;
	private static int SIZE = 1000000;

	public static void main(String[] args) {
		BSTComparison tester = new BSTComparison();

		// create an ordered array and linkedlist with the same values.
		int[] array = new int[SIZE];
		LinkedList<Integer> llist = new LinkedList<Integer>();
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
			llist.add(i);
		}

		// build a BST with the values from the ordered array
		tester.createMinBST(array);

		Stopwatch timer1 = new Stopwatch();
		theBST.find(999999);
		System.out.println(" Computing time for BST search: "
				+ timer1.elapsedTime() + " millisec");

		Stopwatch timer2 = new Stopwatch();
		tester.binarySearch(array, 999999);
		System.out
				.println(" Computing time for Binary Search on ordered array: "
						+ timer2.elapsedTime() + " millisec");

		Stopwatch timer3 = new Stopwatch();
		llist.contains(999999);
		System.out
				.println(" Computing time for search, or contains call, on linkedlist: "
						+ timer3.elapsedTime() + " millisec");

		Stopwatch timer4 = new Stopwatch();
		theBST.delete(0);
		System.out.println(" Computing time for BST deletion: "
				+ timer4.elapsedTime() + " millisec");

		Stopwatch timer5 = new Stopwatch();
		tester.delete(array, 0);
		System.out.println(" Computing time for deletion on ordered array: "
				+ timer5.elapsedTime() + " millisec");

		Integer llvalue = new Integer(999999);
		Stopwatch timer6 = new Stopwatch();
		llist.remove(llvalue);
		System.out.println(" Computing time for deletion on linked list: "
				+ timer6.elapsedTime() + " millisec");

		Stopwatch timer7 = new Stopwatch();
		theBST.insert(0);
		System.out.println(" Computing time for BST insertion: "
				+ timer7.elapsedTime() + " millisec");

		Stopwatch timer8 = new Stopwatch();
		tester.insert(array, 0);
		System.out.println(" Computing time for insertion on ordered array: "
				+ timer8.elapsedTime() + " millisec");

		Stopwatch timer9 = new Stopwatch();
		llist.add(llvalue);
		System.out.println(" Computing time for insertion on linked list: "
				+ timer9.elapsedTime() + " millisec");

	}

	// build a new BST with the minimum height
	// inserting values in an ordered array recursively
	public void createMinBST(int[] orderedArray) {
		theBST = new BST();
		createMinBST(orderedArray, 0, orderedArray.length - 1);
	}

	private void createMinBST(int[] array, int start, int end) {
		//the base case if start cross end return 
		if(start>end){
			return;
		}
		// middle of the array which is at first the root..
		int mid =start+(end-start)/2;
		// insert the middle element in
		theBST.insert(array[mid]);
		// create the tree using the left side
		createMinBST(array,start,mid-1);
		// create the tree using right side
		createMinBST(array,mid+1,end);
		
	}

	/*
	 * All of the following methods are operations of an ordered array
	 * 1. Binary search
	 * 2. insert
	 * 3. delete
	 */
	public int binarySearch(int[] array, int searchKey) {
		int lowerBound = 0;
		int upperBound = array.length - 1;
		int curIndex;
		while (true) {
			if (lowerBound > upperBound)
				return array.length;

			curIndex = lowerBound + (upperBound - lowerBound) / 2;
			if (array[curIndex] == searchKey)
				return curIndex;
			else {
				if (array[curIndex] < searchKey)
					lowerBound = curIndex + 1;
				else
					upperBound = curIndex - 1;
			}
		}
	}

	public void delete(int[] array, int keyToDelete) {
		int index = binarySearch(array, keyToDelete);
		if (index == array.length)
			return;
		else { // not really perfect but enough to see the difference
			for (int k = index; k < array.length - 1; k++) {
				array[k] = array[k + 1];
			}
		}
	}

	public void insert(int[] array, int keyToInsert) {
		// Search first
		int index = binarySearch(array, keyToInsert);
		// id the value is not in the array, then perform insertion
		if (index == array.length) {
			// find the place to be inserted
			int place;
			for (place = 0; place < array.length; place++) {
				if (array[place] > keyToInsert)
					break;
			}
			// shift larger values up
			// not really perfect but good enough to see the difference
			for (int k = array.length - 1; k > place; k--) {
				array[k] = array[k - 1];
			}
			array[place] = keyToInsert;
		} else {
			return;
		}
	}
}