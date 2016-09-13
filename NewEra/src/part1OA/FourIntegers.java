package part1OA;

import java.util.Arrays;

public class FourIntegers {
		
	public int[] Solutions(int a, int b, int c, int d){
		 int[] arr = new int[4];
		 arr[0] = a;
		 arr[1] = b;
		 arr[2] = c;
		 arr[3] = d;
		 Arrays.sort(arr);
		 Swap.swap(arr, 0, 1);
		 Swap.swap(arr, 2, 3);
		 Swap.swap(arr, 0, 3);
		 return arr;
	}
	

}
