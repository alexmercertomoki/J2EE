package binarysearch;

import javax.sql.rowset.serial.SerialArray;

public class SearchInsert {

	public static int searchInsert (int[] data, int key) {
		if (data == null || data.length == 0) {
			return -1;
		}
		int lowerBound = 0;
		int upperBound = data.length - 1; 
		int mid;
		
		if (data[0] > key) {
			return 0; 
		}
		while (lowerBound + 1 < upperBound) {
			mid = lowerBound + (upperBound - lowerBound) / 2; 
			
			if (data[mid] == key) {
				return mid;
			} else{
				if (data[mid] < key) {
					lowerBound = mid;
				} else{
					upperBound = mid;
				}
			}
		}
		if (data[upperBound] == key) {
			return upperBound;
		}
		if (data[lowerBound] == key) {
			return lowerBound;
		}
		if (data[upperBound] < key) {
			return upperBound + 1;
		}
		return lowerBound + 1;
	}
	
	public static void main(String[] args) {
		
		int[] data = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(searchInsert(data, 100001));
		

	}

}
