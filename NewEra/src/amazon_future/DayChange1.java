package amazon_future;

import java.util.Arrays;

public class DayChange1 {
	 // 如果达到稳定态都是 0 可以快速退出 。。 return cells // saving array of spaces
		public int[] dc1(int[] cells, int day){
			// corner case :
			for(int i = 0; i < cells.length; i ++){
				if(cells[i] != 0 && cells[i] != 1){
					return cells; // or throw exception 
				}
			}
			if(cells == null || day <= 0) return  cells;
			int prev = 0;
			
			for(int i = 0; i < day; i ++ ){
				prev = 0;
				for(int j = 0; j < cells.length; j ++){
					int temp = cells[j];
					if(j < cells.length - 1){
						cells[j] = prev ^ cells[j + 1];
					} else{
						cells[j] = prev ^ 0;
					}
					prev = temp;
				}
			}
			return cells;
		}
}
