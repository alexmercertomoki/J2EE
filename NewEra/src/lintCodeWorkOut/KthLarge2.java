package lintCodeWorkOut;

public class KthLarge2 {

	    /*
	     * @param k : description of k
	     * @param nums : array of nums
	     * @return: description of return
	     */
	    public int kthLargestElement(int k, int[] nums) {
	        // write your code here
	        if(k <= 0) {
	            return 0;
	        }
	        if(nums == null || nums.length == 0){
	           return 0; 
	        }
	        
	        return helper(nums, 0, nums.length - 1, k);
	    }
	    
	    public int helper(int[] nums, int left, int right, int k) {
	        if(left == right) { // edge same 
	            return nums[right];
	        }
	        int position = partition(nums, left, right);
	        
	        if(k == position + 1) {
	            return nums[position];
	        } else if(k < position + 1) {
	           return helper(nums, left, position - 1, k); 
	        } else {
	            return helper(nums, position + 1, right, k);
	        }
	    }
	    
	    public int partition(int[] nums, int left, int right) {
	        if(left == right) { // edge 
	            return right;
	        }
	        
	        int index = left; // index should be left !!
	        int number = nums[right];
	        
	        for(int i = left; i < right; i++) {
	            if(nums[i] >= number) {
	            	if(i != index){
		                nums[i] ^= nums[index]; 
		                nums[index] ^= nums[i]; 
		                nums[i] ^= nums[index]; 
	            	}
	                index++;
	            }
	        }
	        if(right != index) {
		        nums[right] ^= nums[index];
		        nums[index] ^= nums[right];
		        nums[right] ^= nums[index];
	        }
	        return index;
	    }

}
