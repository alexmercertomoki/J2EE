package array;

public class FindMedianTwoSorted {
	public class Solution {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        if(nums1 == null && nums2 != null) {
	            double val = nums2.length % 2 == 1 ? nums2[nums2.length / 2 + 1] : nums2[nums2.length / 2];
	            return val;
	        }
	        
	        if(nums2 == null && nums1 != null) {
	            double val = nums1.length % 2 == 1 ? nums1[nums1.length / 2 + 1] : nums1[nums1.length / 2];
	            return val;
	        }
	        
	        int m = nums1.length;
	        int n = nums2.length; 
	        
	        
	        int nums1Median = nums1.length % 2 == 1 ? nums1[nums1.length / 2 + 1] : nums1[nums1.length / 2];
	        int nums2Median = nums2.length % 2 == 1 ? nums2[nums2.length / 2 + 1] : nums2[nums2.length / 2];
	        
	       
	        return 0.0;
	        
	        
	    }
	    
//	    public double theMedian(int nums1Median, int nums2Median, int[] nums1, int a_start, int[] nums2, int b_start) {
//	    	if(nums1Median == nums2Median){
//	    		return nums2Median;
//	    	}
//	    	if(len1Now == 0) {
//	    		
//	    	}
//	    	
//	    	if(nums1Median < nums2Median) {
//	    		len1Now = len1Now / 2 + 1;
//	    		len2Now = len2Now / 2 + 1;
//	    		nums1Median = nums1[len1Now];
//	    		nums2Median = nums2[len2Now];
//	    		
//	    		return theMedian(nums1Median, nums2Median, nums1,len1Now, nums2,len2Now);
//	    	}
//	    	
//	    	if(nums2Median > nums1Median) {
//	    		len1Now = len1Now / 2 + 1;
//	    		len2Now = len2Now / 2 + 1;
//	    		
//	    		
//	    		
//	    	}
//	    	
//	    	
//	    	
//	    }
	}
}
