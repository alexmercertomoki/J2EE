package binarysearch;

public class BSGeneral {

	public static int BS(int[] data, int key) {
		if (data == null || data.length == 0) {
			return -1;
		}
		int lowerBound = 0;
		int upperBound = data.length - 1;
		int mid;

		while (lowerBound + 1 < upperBound) {
			mid = lowerBound + (upperBound - lowerBound) / 2;
			if (data[mid] == key) {
				return data[mid];
			} else {
				if (data[mid] < key) {
					lowerBound = mid;
				} else {
					upperBound = mid;
				}
			}

		}
		if (data[lowerBound] == key) {
			return lowerBound;
		}
		if (data[upperBound] == key) {
			return upperBound;
		}

		return -1;

	}

	public static void main(String[] args) {

		int[] data = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(BS(data, 1));

	}

}
