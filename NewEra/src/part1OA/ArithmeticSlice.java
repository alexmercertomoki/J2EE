package part1OA;

public class ArithmeticSlice {
	public int arithmeticSliceNumber(int[] arr){
		if(arr == null || arr.length < 3) return 0;
		
		int totalNumber = 0, gap = arr[1] -arr[0], len = 2;
		for(int i = 1; i < arr.length - 1; i ++){
			if(arr[i + 1] - arr[i] == gap) len++;
			else {
				gap = arr[i + 1] - arr[i];
				if(len >= 3){
					totalNumber += (len - 1) * (len - 2) / 2;
					if(totalNumber > 1000000000) return -1;
				}
				len = 2;
			}
			
		}
		if(len >= 3) totalNumber += (len - 1) * (len - 2) / 2;
		if(totalNumber > 1000000000) return -1;
		else return totalNumber;

	}

}
