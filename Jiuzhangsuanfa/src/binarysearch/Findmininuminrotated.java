package binarysearch;

public class Findmininuminrotated {
	
	public static int findmin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int mid;
		
		while (left < right && nums[left] >= nums[right]) {
			mid = (left + right) / 2; 
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid; 
			}
			
		}
		return nums[left];
		
	}
	

	public static void main(String[] args) {
		
		int[] data = {5, 7, 8, 10, 1, 2, 3, 4};
		System.out.println(findmin(data));
		
	}

}
