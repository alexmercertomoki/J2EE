package lab4;

/**************************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Lab 4 Number of Collisions Comparison and
 * Drawing a simple fractal of N squares with recursion
 *
 **************************************************************/

import java.util.*;

public class CollisionComparison {
	private static final int SIZE = 110;

	public static void main(String[] args) {
		int[] keys = new int[SIZE];
		int keyValue = 200;
		// initialize array key values
		for (int i = 0; i < keys.length; i++) {
			keys[i] = keyValue;
			keyValue = keyValue + 5;
		}

		System.out.println("****************************************************");
		System.out.println("Key values");
		System.out.println(Arrays.toString(keys));
		System.out.println();

		DataItem[] hashArray1 = new DataItem[100];
		int numberOfCollisions = 0;
		for (int i = 0; i < keys.length; i++) {
			DataItem newItem = new DataItem(keys[i]);
			int hashVal = newItem.key % hashArray1.length;
			if (hashArray1[hashVal] == null)
				hashArray1[hashVal] = newItem;
			else
				numberOfCollisions++;
		}

		System.out.println("****************************************************");
		System.out.println("Number of Collisions with hash table 1: "
				+ numberOfCollisions);
		System.out.println(Arrays.toString(hashArray1));
		System.out.println();

		DataItem[] hashArray2 = new DataItem[101];
		numberOfCollisions = 0;
		for (int i = 0; i < keys.length; i++) {
			DataItem newItem = new DataItem(keys[i]);
			int hashVal = newItem.key % hashArray2.length;
			if (hashArray2[hashVal] == null)
				hashArray2[hashVal] = newItem;
			else
				numberOfCollisions++;
		}

		System.out.println("****************************************************");
		System.out.println("Number of Collisions with hash table 2: "
				+ numberOfCollisions);
		System.out.println(Arrays.toString(hashArray2));
	}

	private static class DataItem {
		private int key;

		public DataItem(int key) {
			this.key = key;
		}

		public String toString() {
			return "[" + key + "]";
		}
	}
}