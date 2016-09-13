package strstr;

import java.util.LinkedList;
import java.util.List;

public class SummaryRange {
	
	    public List<String> summaryRanges(int[] nums) {
	        List<String> list = new LinkedList<String>();
	        if(nums == null || nums.length == 0 ) return list;
	        
	        int begin = nums[0], end = nums[0]; 
	        for(int i = 1; i < nums.length; i ++){
	            System.out.println(nums[i] - nums[i - 1]); // overflow  int and get -2 actually should be 2 times large as int range
	            if(nums[i] - nums[i - 1] > 1 || nums[i] - nums[i - 1] < 0){ // less than 0 overflow we handle this 
	                end = nums[i - 1];
	                if(end != begin){
	                     list.add(begin +"->"+ end);
	                } else {
	                    list.add("" + end);
	                }
	                begin = nums[i];
	            }
	            end = nums[i];
	        }
	        
	        if(begin != end){
	             list.add(begin +"->"+ end);
	        } else{
	            list.add("" + end);
	        }
	        
	        return list;
	        
	    }

}
