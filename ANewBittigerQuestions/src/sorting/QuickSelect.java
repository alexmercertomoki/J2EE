package sorting;

public class QuickSelect {
	public int quickSelectKthSmall(int[] arr, int k) {
		int start = 0;
		int end = arr.length - 1;
		return quickSelect(start, end, arr, k - 1);
	}
	//模板！！
	private int quickSelect(int start,int end, int[] arr, int k) {
		if(start > end) {
			return Integer.MAX_VALUE;
		}
		
		int pivot = end;
		int low = start;
		
		for(int high = start; high < end; high++) {
			if(arr[high] <= arr[pivot]) {
				swap(arr,high, low);
				low++;
			}
		}
		
		swap(arr,low,pivot);
		
		if(k == low) {
			return arr[low];
		} else if(k > low) {
			return quickSelect(low + 1, end, arr, k);
		} else{
			return quickSelect(start, low - 1, arr, k);
		}
		
	}
		
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
		

}
