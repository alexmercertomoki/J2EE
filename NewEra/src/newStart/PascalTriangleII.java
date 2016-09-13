package newStart;

// couldn't understand 

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	    public List<Integer> getRow(int rowIndex) {
	        int n = rowIndex;
	        int[] tmp = new int[2*n+3];
	        tmp[n+1] = 1;
	        int left = n+1, right = n+1;
	        while (n-- > 0) {
	            --left;
	            ++right;
	            for (int i = left; i <= right; i += 2) {
	                tmp[i] = tmp[i-1] + tmp[i+1];
	            }
	        }
	        List<Integer> ret = new ArrayList<>();
	        for (int i = left; i <= right; i += 2) {
	            ret.add(tmp[i]);
	        }
	        return ret;
	    }
}
