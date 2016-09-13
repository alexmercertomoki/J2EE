package binarysearch;

public class SearchForRange {
	  public static int[] searchRange(int[] data, int key) {
		  
		  if(data == null || data.length == 0){
				return new int[]{- 1, - 1};
			}
			int lower = 0;
			int higher = data.length - 1; 
			int mid;
		    int lowRange=0,curRange=0,highRange=0;
			
			while(true) {
				if(lower > higher){
					return new int[]{- 1, - 1}; 
				}
				mid = lower + (higher - lower) / 2; 
				if(data[mid] == key) {
					curRange = mid;
					break;
				}else {
					if (data[mid] > key){
						higher = mid - 1 ;
					} else {
						lower = mid + 1 ;
					}
				}
			}
			
			lowRange=curRange;
			highRange=curRange;
			

			while(lowRange - 1 >= 0  && (data[lowRange] == data[lowRange - 1])){
				lowRange --;
			}
			
			while(highRange + 1 < data.length  && (data[highRange] == data[highRange + 1])){
				highRange ++;
			}
			
			return new int[] {lowRange, highRange};
		  
	  }

	public static void main(String[] args) {
		
		int[] data = {5, 7, 7, 8, 8, 10};
		data = searchRange(data, 10);
		for(int i : data){
			System.out.println(i);
		}
	}

}
