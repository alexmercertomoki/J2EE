package binarysearch;

public class SearchForRangeGeneralWay {
	  public static int[] searchRange(int[] data, int key) {
		  
		  if(data == null || data.length == 0){
				return new int[]{- 1, - 1};
		  }
		  
		  int lower = 0;
		  int higher = data.length - 1;
		  int mid;
		  int[] bound =new int[2];
		  
		  while (lower + 1 < higher) {
			  mid = lower + (higher - lower) / 2;
			  if (data[mid] == key) {
				  higher = mid;
			  }else{
				  if (data[mid] < key) {
					  lower = mid;
				  } else {
					  higher = mid; 
				  }
			  }
		  
		  }
		  if (data[lower] == key) {
			  bound[0] = lower;
		  } else if (data[higher] == key){
			  bound[0] = higher;
		  } else {
			  bound[0] = bound[1] = - 1;
			  return bound;
		  }
		  
		  lower = 0;
		  higher = data.length - 1;
		  
		  while (lower + 1 < higher) {
			  mid = lower + (higher - lower) / 2; 
			  if(data[mid] == key) {
				  lower = mid;
			  } else {
				  if (key > data[mid]) {
					  lower = mid;
				  } else {
					  higher = mid;
				  }
			  }
		  }
		  if(data[higher] == key) {
			  bound[1] = higher;
		  } else if (data[lower] == key){
			  bound[1] = lower;
		  } else {
			  bound[0] = bound[1] = - 1;
			  return bound;
		  }
		return bound;
	  }

	public static void main(String[] args) {
		int[] data = {2,2};
		data = searchRange(data, 2);
		for(int i : data){
			System.out.println(i);
		}
	
	}

}
