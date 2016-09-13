package array;

public class MaxSumiArr {
	public int maxSumiArr(int[] numbers) {
		
		// 有一个 固定差值就是： + (n - 1 ) arr[0] - sumAll + arr[0] = +n arr[0] - sumAll 
		int max = Integer.MIN_VALUE;
		int total = 0;
		int sumAll = 0; 
		
		for(int i = 0; i < numbers.length;i++) {
			total += i * numbers[i];
			sumAll += numbers[i];
		}
		max = total;
		
		
		for(int j = 0; j < numbers.length - 1;j++) {
			total = total + numbers.length * numbers[j] - sumAll;
			if(total > max) {
				max = total;
			}
		}
		return max;
	}

}
