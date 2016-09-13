package array;

public class StrictlyIncreasingSubArr {
	public int strictlyIncreasingSubArrNums(int[] numbers) {
		if(numbers == null || numbers.length == 0 || numbers.length == 1) {
			return 0;
		}
		int prev = -1;
		int cur = 1;
		int count = 0;
		
		while(cur < numbers.length) {
			// find the increasing range 
			if(numbers[cur - 1] < numbers[cur]) {
				prev = cur - 1;
			} 
			while(cur < numbers.length && numbers[cur - 1] < numbers[cur]) {
				cur++;
			}
			
			// the range is found the start is prev, do the calc and RESET prev 
			if(prev != -1) {
				count += helper(cur - prev);
				prev = -1;
			}
			// 找不到往后走 和 找到了合适的计算过以后往后走
			cur++;
		}
//		if(prev != -1) {
//			count += helper(cur - prev);
//		}
		
		return count;
		
	}
	
	public int helper(int n) {
		return n * (n - 1) / 2;
	}

}
