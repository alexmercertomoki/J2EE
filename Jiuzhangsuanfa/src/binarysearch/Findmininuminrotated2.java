package binarysearch;

public class Findmininuminrotated2 {
	
	public static int findmin(int[] nums) {
		
		int left = 0;
        int right = nums.length - 1;
        int mid; 
        
        while (left < right && nums[left] >= nums[right]) { // >=  
            mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else if(nums[mid] < nums[left]) {
                right = mid;
            } else {
                left = left + 1;
            }
        }
        return nums[left];
		
	}
	

	public static void main(String[] args) {
		
		int[] data = {3, 1, 3};
		System.out.println(findmin(data));
		
	}

}
