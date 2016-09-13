package permutation;


import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	public static List<List<Integer>> perm(int[] nums) {
		// sort 
		Arrays.sort(nums);
		// new partition
		List<Integer> part = new ArrayList<Integer>();
		// the result list of Lists
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		// combination helper result partition numbers passed in, start from 0 
		permuHelper(result, part, nums);

		return result;

	}

	public static void permuHelper(List<List<Integer>> result,
			List<Integer> part, int[] numbers) {
		// adding the lists to the result  
		if(part.size()==numbers.length){
			result.add(new ArrayList<>(part));
		}
		// for loop adding in the elements 
		for (int i = 0; i < numbers.length; i++) {
			// adding in numbers 
			if(part.contains(numbers[i])){
				continue;
			}
			part.add(numbers[i]);
			// calling recursively 
			permuHelper(result, part, numbers);
			// remove the last ele : trace back  
			part.remove(part.size() - 1);

		}

	}
	
	public static void main(String[] args) {
		int[] numbers={1,2,3};
		
		List<List<Integer>> result = perm(numbers);
		
		
		
	}


}