package lab3;
/***********************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Lab 3 Simple Sorting Performance Comparison
 *
 * O(n^2) : Bubble Sort, Selection Sort, and Insertion Sort
 *
 ***********************************************************/
import java.util.*;

public class SimpleSortDemo {
	private static final int SIZE = 30000;
	private static Random rand = new Random();

	public static void main(String[] args) {
		int[] a = new int[SIZE];
		int[] b = new int[SIZE];
		int[] c = new int[SIZE];

		// Case 1: put random numbers into array a
		for(int i = 0; i < SIZE; i++) a[i] = rand.nextInt();

		// Case 2
		//for(int i = 0; i < SIZE; i++) a[i] = i;

		System.arraycopy(a, 0, b, 0, a.length);
		System.arraycopy(a, 0, c, 0, a.length);

		Stopwatch timer1 = new Stopwatch();
		bubbleSort(a);
		System.out.println("bubble sort: " + timer1.elapsedTime()
				+ " millisec");

		Stopwatch timer2 = new Stopwatch();
		selectionSort(b);
		System.out.println("selection sort: " + timer2.elapsedTime()
				+ " millisec");

		Stopwatch timer3 = new Stopwatch();
		insertionSort(c);
		System.out.println("insertion sort: " + timer3.elapsedTime()
				+ " millisec");
	}

	/**
	 * bubble sort runs in O(n^2)
	 * simple but slow and focus on the largest value
	 */
	public static void bubbleSort(int[] data) {
		// move backward from the last index
		for(int out = data.length-1; out >= 1; out--) {
			// move forward from the beginning
			// bubble up the largest value to the right
			for(int in = 0; in < data.length - 1; in++) {
				if(data[in] > data[in+1])
					swap(data, in, in+1);
			}
		}
	}

	/**
	 * selection sort runs in O(n^2)
	 * faster than bubble sort because of less number of swaps
	 * focus on the smallest value
	 */
	public static void selectionSort(int[] data) {
		for(int out = 0; out < data.length-1; out++) {
			int min = out;
			for(int in = out+1; in < data.length; in++) {
				if(data[in] < data[min])
					min = in;
			}
			// swap is outside of the inner loop
			if(out != min)
				swap(data, out, min);
		}
	}

	/**
	 * insertion sort runs in O(n^2) in the worst case
	 * but its best case running time complexity is O(n)
	 * fastest among the three but sensitive to the input values
	 *
	 * less number of comparisons on average
	 * uses shifting (copying) instead of swapping
	 * one swap equals to three copies
	 */
	public static void insertionSort(int[] data) {
		// start from at the index of 1 till the last index
		for(int out = 1; out < data.length; out++) {
			int tmp = data[out]; // store the value temporarily
			int in = out; // initially set to be the same as out

			/* while loop to check the sorted section backward
			 * go backward but not necessarily all the way to the 0th
			 * on average, look halfway through the sorted section
			 */
			while(in > 0 && data[in-1] >= tmp) {
				data[in] = data[in-1]; // shift to right
				in--;
			}
			// finally INSERT the tmp value into the right position
			data[in] = tmp;
		}
	}

	// swap helper method
	private static void swap(int[] array, int one, int two) {
		int tmp = array[one];
		array[one] = array[two];
		array[two] = tmp;
	}

}