package combinationsum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        List<Integer> part= new ArrayList<Integer>();
        combinationHelper(result, part, candidates, 0, target);
        return result;
    }
    public static void combinationHelper(List<List<Integer>> res, List<Integer> part, int[] candidates, int pos, int target){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(part); // <---new ArrayList(part);
        }
        for(int i = pos; i < candidates.length; i++) {
            part.add(candidates[i]);
            combinationHelper(res, part, candidates, i, target - candidates[i]); 
            part.remove(part.size()-1);
        }
        
    }
    public static void main(String[] args) {
    	int[] nums = {1};
    	List<List<Integer>> l = combinationSum(nums,1);
    	for(int i = 0; i < l.size(); i++){
    		List<Integer> ll=l.get(i);
    		for(int j = 0; j < ll.size(); j++){
    			System.out.println(ll.get(j));
    		}
    	}
    	
	}
    
    
    
}