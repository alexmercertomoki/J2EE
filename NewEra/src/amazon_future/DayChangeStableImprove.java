package amazon_future;

import java.util.Arrays;

public class DayChangeStableImprove {
	 // 如果达到稳定态都是 0 可以快速退出 。。 return cells // saving array of spaces
	 //  if not  0   1 we should throw exception 
		public int[] dc1(int[] cells, int day){
			if(cells == null || day <= 0) return  cells;
			int prev = 0;
			int count = 0;
			
			for(int i = 0; i < day; i ++ ){
				prev = 0;
				for(int j = 0; j < cells.length; j ++){
					int temp = cells[j];
					if(j < cells.length - 1){
						cells[j] = prev ^ cells[j + 1];
						if(cells[j] == temp ){
							count ++; 
						}
					} else{
						cells[j] = prev ^ 0;
					}
					prev = temp;
				}
				
				if(count == cells.length){
					return cells;
				}
			}
			return cells;
		}
}
