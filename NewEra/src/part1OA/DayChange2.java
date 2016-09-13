package part1OA;

import java.util.Arrays;

public class DayChange2 {
	
		public int[] dc2(int[] arr, int day){
			int len = arr.length;
			int[] arrchange = new int[len + 2];
			arrchange[0] = arrchange[len + 1] = 0; 
			int pre = arrchange[0]; 
			for(int i = 1; i < len + 1; i ++){
				arrchange[i] = arr[i - 1];
			}
			
			for(int i = 0; i < day; i ++){
				for(int j = 1; j < len + 1; j ++){
					int temp = arrchange[j];
					arrchange[j] = pre ^ arrchange[j + 1];
					pre = temp; 
					
				}
				
			}
			arrchange[1] = arrchange[len] = 0;
			return Arrays.copyOfRange(arrchange, 1, len + 1);
		}
}
