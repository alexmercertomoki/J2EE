package part1OA;

public class SumOfWindows {	
	
	 public int[] solutionOfkwindows(int[] arr, int k){
		 if(arr == null || arr.length == 0 || k <= 0 || k > arr.length ){
			 return null;
		 }
		 int[] result = new int[arr.length - k + 1];
		 for(int i = 0; i < k ; i ++){
			 result[0] += arr[i];
		 }
		 for(int i = 1; i < result.length; i ++){
			 result[i] = result[i - 1] - arr[i - 1] + arr[i + k - 1];
		 }
		 
		 return result;
	 }

}
