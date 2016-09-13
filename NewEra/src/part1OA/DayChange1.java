package part1OA;

import java.util.Arrays;

public class DayChange1 {
	
		public int[] dc1(int[] arr, int day){
			int len = arr.length;
			int[] arrchange = new int[len + 2];
			arrchange[0] = arrchange[len + 1] = 0; 
			int pre = arrchange[0]; 
			for(int i = 1; i < len + 1; i ++){
				arrchange[i] = arr[i - 1];
			}
			for(int i = 0; i < day; i ++){
				pre = 0;
				for(int j = 1; j < len + 1; j ++){
					int temp = arrchange[j];
					arrchange[j] = pre ^ arrchange[j + 1];
					pre = temp; 
					
				}
				
			}
			
			return Arrays.copyOfRange(arrchange, 1, len + 1);
		}
}
