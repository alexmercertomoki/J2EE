package lab5;

/********************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Lab 5 Comparing MergeSort with QuickSort
 *
 * A simple MergeSort implementation
 *
 * Andrew ID:
 * Name:
 *
 ********************************************************/

import java.util.*;

public class Copy_2_of_MergeSort {
	private static final int SIZE = 100000;
	private static Random rand = new Random();

	public static void main(String[] args) {
		Copy_2_of_MergeSort sorter = new Copy_2_of_MergeSort();
		int[] array = new int[SIZE];

		for (int i = 0; i < SIZE; i++)
			array[i] = rand.nextInt();

		// for(int i = 0; i < SIZE; i++) array[i] = SIZE - i;

		Stopwatch timer = new Stopwatch();
		sorter.mergeSort(array);
		System.out.println("Time taken to sort " + SIZE
				+ " elements (Merge Sort): " + timer.elapsedTime()
				+ " milliseconds");

		// to make sure sorting works.
		// add "-ea" vm argument
		assert isSorted(array);
	}

	public void mergeSort(int[] from) {
		// create a new array
		int[] to = new int[from.length];
		mergeSort(from, to, 0, from.length - 1);
		//System.out.println(Arrays.toString(from));
	}

	private void mergeSort(int[] from, int[] to, int left, int right) {
		if (right <= left) return;
		if (right - left ==1){ // base case  11mili
			
			if(from[right]<from[left]){int temp;
				temp = from[right];
				from[right] = from[left];
				from[left] = temp;
//				to[right] = to[right] ^ to[left];
//				to[left] = to[right] ^ to[left];
//				to[right] = to[right] ^ to[left];
				
			}
		}
		else { // recursive case
				// find midpoint
			int mid = left + (right - left) / 2;
			// sort left half recursively
			mergeSort(from, to, left, mid);
			// sort right half recursively
			mergeSort(from, to, mid + 1, right);
			// merge them
			merge(from, to, left, mid + 1, right);
		}
	}

	/*
	 * Instead of creating multiple arrays, this works with only two arrays
	 * (from and to)
	 * 
	 * 1. leftPos: starting point of left half 2. rightPos: starting point of
	 * right half 3. rightBound: upper bound of right half
	 */
	public void merge(int[] from, int[] to, int leftPos, int rightPos,
			int rightBound) {
		// left bound is the right starting position -1 
		int leftBound = rightPos - 1;
		// the starting index is left position
		int toIndex = leftPos;
		//number of elements is right - left +1 
		int numberOfItems = rightBound - leftPos + 1;
		//if left position and right position are all not the end 
		while (leftPos <= leftBound && rightPos <= rightBound) {
			// if value in the  right position is less than the value in the right position
			if (from[rightPos] < from[leftPos])
				// set the value in the right position in the index and then index+1 right position+1
				to[toIndex++] = from[rightPos++];
			else
				//set the value in the left position in the index and then index + 1 left position + 1 
				to[toIndex++] = from[leftPos++];

		}
		while (leftPos <= leftBound)
			//set the what is left in the left array
			to[toIndex++] = from[leftPos++];
		while (rightPos <= rightBound)
			//set what is left in the right array
			to[toIndex++] = from[rightPos++];
		// set the numbers in the to back to from, from the right bound backwards,
		for (int i = 0; i < numberOfItems; i++, rightBound--) {
			from[rightBound] = to[rightBound];
		}

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