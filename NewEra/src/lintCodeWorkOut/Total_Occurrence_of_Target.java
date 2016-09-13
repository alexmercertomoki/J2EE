package lintCodeWorkOut;

public class Total_Occurrence_of_Target {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code herej
        if(A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1; 
        int count = 0;
        
        while(start + 1 < end) {
            
            int mid = start + (end - start) / 2;
            if(target == A[mid]) {
                end = mid;
            } else if (target < A[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if(A[start] == target) {
            while(start < A.length && A[start] == target ) {
                count++;
                start++;
            }
        }else if(A[end] == target){
            while(end < A.length && A[end] == target) {
                count++;
                end++;
            }
        }
        return count;
    }
}