import java.util.Arrays;

public class twoSum {
	public boolean twosum(int[] nums, int target) {

		if(nums == null || nums.length == 0) {
            return false;
        }    
		
		Arrays.sort(nums);
       
		for(int left = 0, right = nums.length - 1; left < right; ) {
			if(nums[left] + nums[right] > target) {
				right--;
			} else if(nums[left] + nums[right] < target){
				left++;
			} else {
				return true;
			}
		}
		return false;
	}
}
