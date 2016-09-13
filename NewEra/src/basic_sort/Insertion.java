package basic_sort;

public class Insertion {
	public int[] insertionSort(int[] nums) {
		 int i;
		 int j;
		 int key;
		 for(j = 1; j < nums.length;j++) {
			 key = nums[j];
			 for(i = j - 1; i >= 0  && key < nums[i]; i-- ) {
				 nums[i + 1] = nums[i];
			 }
			 nums[i + 1] = key;
		 }
		return nums;
	}

}
