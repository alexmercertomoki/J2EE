package heap;

/********************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Lecture 18 Heaps and Heap Sort
 *
 * A very simple and naive MaxHeap implementation
 *
 ********************************************************/

import java.util.*;

public class MaxHeap implements MaxHeapInterface {

	private Node[] heapArray;
	private int currentSize;

	// precondition : initialSize > 0
	public MaxHeap(int initialSize) {
		heapArray = new Node[initialSize];
		currentSize = 0;
	}

	/**
	 * Insert a new key into a heap
	 *
	 * @param key
	 *            key to be inserted
	 * @return boolean to check whether it is successfully added or not
	 */
	@Override
	public boolean insert(double key) {
		if (currentSize == heapArray.length) // array is full
			return false;

		Node newNode = new Node(key);
		// insert into the next available index position
		// to make sure the heap is complete
		heapArray[currentSize] = newNode;
		percolateUp(currentSize++);
		return true;
	}

	/**
	 * remove the highest priority key value (maximum key for max heap)
	 *
	 * @return removed key value
	 */
	@Override
	public double removeMax() {
		if (currentSize == 0)
			throw new NoSuchElementException("The heap is empty");

		Node root = heapArray[0];
		currentSize--;
		// massive promotion of the last node to the root
		// to make sure the heap is complete
		heapArray[0] = heapArray[currentSize];
		heapArray[currentSize] = null;
		percolateDown(0);
		return root.key;
	}

	public int size() {
		return currentSize;
	}

	// helper method to percolate up for insert operation
	private void percolateUp(int index) {
		Node bottom = heapArray[index];
		int parent = (index - 1) / 2;

		// compare with parent and move it down if necessary
		while (index > 0 && heapArray[parent].key < bottom.key) {
			heapArray[index] = heapArray[parent]; // move node down
			index = parent; // move index upward
			parent = (parent - 1) / 2; // parent also moves upward
		}

		heapArray[index] = bottom;
	}

	// helper method to percolate down for remove max operation
	private void percolateDown(int index) {
		Node top = heapArray[index];
		// need to keep track of larger child
		int largerChild;

		// loop as long as there is left child
		// in other words, about the half of the nodes should be leaves
		while (index < (currentSize / 2)) {
			int leftChild = (2 * index) + 1;
			int rightChild = leftChild + 1; // or 2 * (index + 1);

			// check rightChild is within the boundary of current size
			// and compare left and right to find larger child
			if (rightChild < currentSize
					&& heapArray[leftChild].key < heapArray[rightChild].key)
				largerChild = rightChild;
			else
				largerChild = leftChild;

			// no need to go down any more
			if (top.key >= heapArray[largerChild].key)
				break;

			// largerChild's node moves up
			heapArray[index] = heapArray[largerChild];
			// index goes down toward largerChild
			index = largerChild;
		}

		heapArray[index] = top;
	}

	/*
	 * private static class for Node
	 *
	 * Free lunch because heap is complete binary tree: No left and right
	 * self-references needed
	 */
	private static class Node {
		private double key;

		public Node(double key) {
			this.key = key;
		}
	}

	// a few simple test cases
	public static void main(String[] args) {
		MaxHeap theHeap = new MaxHeap(20);

		// initial removeMax method throws NoSuchElementException
		// theHeap.removeMax();
		theHeap.insert(24.0);
		theHeap.insert(5.0);
		theHeap.insert(45.0);
		theHeap.insert(10.0);
		theHeap.insert(45.0);
		theHeap.insert(56.0);
		theHeap.insert(17.0);
		theHeap.insert(24.0);
		theHeap.insert(19.0);
		theHeap.insert(20.0);

		// heap sort
		double[] sorted = new double[theHeap.size()];
		for (int i = 0; i < sorted.length; i++)
			sorted[i] = theHeap.removeMax();

		System.out.println("Sorted in descending order: "
				+ Arrays.toString(sorted));
	}
}