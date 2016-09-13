package lab5;

/*********************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Lab 5 Comparing MergeSort with QuickSort
 *
 * A simple QuickSort implementation
 *
 *********************************************************/

import java.util.*;
// may get stack overflow 
public class QuickSort {
	private static final int SIZE = 100000;
	private static Random rand = new Random();

	public static void main(String args[]) {
		QuickSort sorter = new QuickSort();
		int[] array = new int[SIZE];

		for (int i = 0; i < SIZE; i++) array[i] = rand.nextInt();

//		for(int i = 0; i < SIZE; i++) array[i] = SIZE - i; // stack over flow 

		Stopwatch timer = new Stopwatch();
		sorter.quickSort(array);
		System.out.println("Time taken to sort " + SIZE
				+ " elements (Quick Sort) : " + timer.elapsedTime()
				+ " milliseconds");

		// to make sure sorting works.
		// add "-ea" vm argument
		assert isSorted(array);
	}

	public void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private void quickSort(int[] arr, int left, int right) {
		if (right - left <= 0)
			return;
		else {
			// Note: selection of pivot value makes a difference!!
			int pivot = arr[right];
			int partition = partition(arr, left, right, pivot);
			quickSort(arr, left, partition - 1);
			quickSort(arr, partition + 1, right);
		}
	}

	// private helper method to partition the array
	private int partition(int[] arr, int left, int right, int pivot) {
		int leftPointer = left - 1;
		int rightPointer = right;

		while (true) {
			while (arr[++leftPointer] < pivot);
			while (rightPointer > 0 && arr[--rightPointer] > pivot);

			if (leftPointer >= rightPointer)
				break;
			else
				swap(arr, leftPointer, rightPointer);
		}
		swap(arr, leftPointer, right);
		return leftPointer;
	}

	// private helper method to swap two values in an array
	private void swap(int[] arr, int dex1, int dex2) {
		int temp = arr[dex1];
		arr[dex1] = arr[dex2];
		arr[dex2] = temp;
	}

	/**********************************************************
	 * Check if array is sorted. A simple debugging tool
	 **********************************************************/
	private static boolean isSorted(int[] array) {
		return isSorted(array, 0, array.length - 1);
	}

	private static boolean isSorted(int[] array, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (array[i] < array[i - 1])
				return false;
		return true;
	}

}