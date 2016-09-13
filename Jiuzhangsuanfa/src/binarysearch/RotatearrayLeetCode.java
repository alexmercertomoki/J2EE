package binarysearch;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class RotatearrayLeetCode {
	
	public static int[] rotate(int[] nums, int k) {
		
		if(nums == null) {
            return null;
        }
     
        int[] nums2 = new int[nums.length];
        
        int r = k % nums.length;
        
        int l = nums.length - 1;
        
        for (int i = r - 1; i >= 0; i --) {
            nums2[i] = nums[l];
            l--;
        }
        for (int j = r; j < nums.length; j++) {
            nums2[j] = nums[j - r];
        }
        return nums2;
	}

	public static void main(String[] args) {
		int[] data = {1, 2};
		data = rotate(data, 1);

		for(int i : data) {
			System.out.println(i);
		}
		
	}

}
