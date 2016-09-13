package basic_sort;

public class MergeSortMine {
	public int[] mergeSort(int[] nums) {
		
		int[] temp = new int[nums.length];
		int left = 0;
		int right = nums.length - 1;
		mergeSort(nums, temp, left, right);
		
		
		return nums;
	}
	
	public void mergeSort(int[] nums, int[] temp, int left, int right) {
		if(left < right) {
			int center = (left + right) / 2;
			mergeSort(nums, temp, left, center);
			mergeSort(nums, temp, center + 1, right);
			merge(nums, temp, left, center + 1, right);
			
		}
		
	}
	
	public void merge(int[] nums, int[] temp, int left, int right,int rightEnd) {
		int leftEnd =  right - 1;
		int k = left; 
		int times = rightEnd - left + 1; 
		
		while(left <= leftEnd && right <= rightEnd) {
			if(nums[left] <= nums[right]) {
				temp[k++] = nums[left++]; 
				
			} else {
				temp[k++] = nums[right++];
			}
		
		}
		
		while(left <= leftEnd) {
			temp[k++] = nums[left++];
			
		}
		
		while(right <= rightEnd) {
			temp[k++] = nums[right++];
		}
		
		for(int i = 0;  i < times; i++ , rightEnd--) {
			nums[rightEnd] = temp[rightEnd];
		}
		
	}
	

}
