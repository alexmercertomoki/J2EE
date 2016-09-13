import java.util.HashSet;
import java.util.Set;

public class twoSumOpt {
	public boolean twosum(int[] nums, int target) {

		if(nums == null || nums.length == 0) {
            return false;
        }    
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i])) {
				return true;
			}
			int diff = target - nums[i];
			set.add(diff);
	    }
		return false;
	}
}
