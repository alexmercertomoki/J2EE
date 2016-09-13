package binarysearch;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Rotatearray {
	
	public static int[] rotate(int[] nums, int k) {
		
	        if(nums == null || k >= nums.length) {
	            return nums;
	        }
	        
	        int[] nums2 = new int[nums.length];
	        
	        if(k == nums.length - 1) {
	            // what if k == length??
	            int j = nums.length - 1;
	            
	            for(int i = 0; i < nums.length; i++) {
	                nums2[j] = nums[i];
	                j--;
	            }
	            
	            // reverse 
//	            for (int i = 0; i < nums.length / 2; i++) {
//	                int temp = nums[i];
//	                nums[i] = nums[nums.length - 1 - i];
//	                nums[nums.length - 1 - i] = temp;
//	              }
	            
	            return nums2;
	            
	        }

	        
	        for (int i = k + 1; i < nums.length; i++) {
	            nums2[i - k - 1] = nums[i];
	        }
	        
	        for (int j = 0; j <= k; j++) {
	            nums2[nums.length - 1 - k + j] = nums[j];
	        }
	        
	        return  nums2;
	}

	public static void main(String[] args) {
		int[] data = {1, 2};
		data = rotate(data, 1);

		for(int i : data) {
			System.out.println(i);
		}
		
	}

}
