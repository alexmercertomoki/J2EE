package binarysearch;

public class BinarySearch {
	
	public static int BS (int[] data, int key) {
		if(data == null || data.length == 0){
			return - 1;
		}
		int lower = 0;
		int higher = data.length - 1; 
		int mid;
		
		while(true) {
			if(lower > higher){
				return - 1; 
			}
			mid = lower + (higher - lower) / 2; 
			if(data[mid] == key) {
				return mid;
			}else {
				if (data[mid] > key){
					higher = mid - 1 ;
				} else {
					lower = mid + 1 ;
				}
			}
			
		}
		
	}

	public static void main(String[] args) {
		int[] data ={1,2,3,4,5,6,7,8};
		System.out.println(BS(data, 8));
		
	}

}
