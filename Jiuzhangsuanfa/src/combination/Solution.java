package combination;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	public List<List<Integer>> subsets(int[] nums) {
		// sort 
		Arrays.sort(nums);
		// new partition
		List<Integer> part = new ArrayList<Integer>();
		// the result list of Lists
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		// combination helper result partition numbers passed in, start from 0 
		combinationHelper(result, part, nums, 0);

		return result;

	}

	public void combinationHelper(List<List<Integer>> result,
			List<Integer> part, int[] numbers, int position) {
		// adding the lists to the result  
		result.add(new ArrayList<>(part));
		// for loop adding in the elements 
		for (int i = position; i < numbers.length; i++) {
			// adding in numbers 
			part.add(numbers[i]);
			// calling recursively 
			combinationHelper(result, part, numbers, i + 1);
			// remove the last ele : trace back  
			part.remove(part.size() - 1);

		}

	}

}