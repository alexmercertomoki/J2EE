package lintCodeWorkOut;

public class ClosestNumber {
	 public int closestNumber(int[] A, int target) {
	        // Write your code here
	        int start = 0;
	        int end = A.length - 1;
	        
	        while(start + 1 < end) {
	            int mid = start + (end - start) / 2;
	            if (A[mid] == target) {
	                end = mid; 
	            } else if (A[mid] > target) {
	                end = mid;
	            } else {
	                start = mid;
	            }
	        }
	        
	        if(Math.abs(A[start] - target) < Math.abs(A[end] - target)) {
	            return start;
	        } else {
	            return end;
	        }
	        
	 }
}
