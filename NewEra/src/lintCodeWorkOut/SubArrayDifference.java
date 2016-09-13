package lintCodeWorkOut;

public class SubArrayDifference {
	    /**
	     * @param nums: A list of integers
	     * @return: An integer indicate the value of maximum difference between two
	     *          Subarrays
	     */
	    public int maxDiffSubArrays(int[] nums) {
	        // write your code here
	        if(nums == null || nums.length == 0) {
	            return 0;            
	        }
	        int length = nums.length;
	        
	        int[] left = new int[length];
	        int[] right = new int[length];
	        
	        int max = Integer.MIN_VALUE, minSum = 0, sum = 0;
	        
	        for(int i = 0; i < length; i++) {
	            sum += nums[i];
	            max = Math.max(max, sum - minSum);
	            minSum = Math.min(minSum, sum); 
	            left[i] = max;
	        }
	        
	        max = Integer.MIN_VALUE;
	        minSum = 0;
	        sum = 0;
	        
	        for(int i = length - 1; i >= 0; i--) {
	            sum -= nums[i];
	            max = Math.max(max, sum - minSum);
	            minSum = Math.min(minSum, sum); 
	            right[i] = -max;
	        }
	        
	        max = Integer.MIN_VALUE;
	        for(int i = 0; i < length - 1; i++) {
	            max = Math.max(max, left[i] - right[i + 1]);            
	        }
	        return max;
	    }

}
