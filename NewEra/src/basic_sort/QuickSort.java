package basic_sort;

public class QuickSort {
	public int[] quickSort(int[] nums) {
		if(nums == null || nums.length == 0) {
			return nums;
		}
		
		int high = nums.length - 1;
		int low = 0;
		quickSort(nums, low, high);
		
		return nums;
	}
	
	public void quickSort(int[] nums, int low, int high) {
		
		if(low >= high) {
			return;
		}
		
		int i = low;
		int j = high;
		int middle = low + (high - low) / 2; 
		int pivot = nums[middle];
		
		while(i <= j) {
			while(nums[i] < pivot) {
				// dont think of =
				//你想如果所有数都一样会怎么样。
				//如果你加=当然可以，只不过还要加while (nums[i] <= pivot && i<j) {i++;}罢了
				
				i++;
			}
			while(nums[j] > pivot) {
				j--;
			}
			if(i <= j) { // make sure this   
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j--;
				i++;
			}
			
		}
		
		if(j > low) {
			quickSort(nums, low, j);
		}
		if(i < high) {
			quickSort(nums, i, high);
		}
		
	}
}
