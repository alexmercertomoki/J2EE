package sorting;

public class QuickSort {
	//作为模板练习 
	public void quickSort(int[] array, int low, int high) {
		if(array == null || array.length == 0) {
			return;
		}
		// s首先第一点： 排出如果数组里面只有一个元素 和 非法输入的情况
		if(low >= high) {
			return;
		}
		
		int i = low; 
		int j = high;
		int mid = i + (j - i) / 2;
		int pivotal = array[mid];
		
		//等于的时候计算一下： 让他们错开 之后再递归 
		while(i <= j) {
			// 这里不需要判断边界，原因是一定会最终遇到pivotal 然后跳出循环
			while(array[i] < pivotal) {
				i++;
			}
			//同理 
			while(array[j] > pivotal) {
				j--;
			}
			// 等于的时候也执行一下 错开， 这里等于 只有一种情况  那就是 pivotal，其他情况就直接错开了，没有影响
			if(i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp; 
				i++;
				j--;
			}
				
		}
		
		if(j > low) {
			quickSort(array, low, j);
		}
			
		if(i < high) {
			quickSort(array, i, high);
		}
		
	}
	
	public void qs2(int[] arr, int low, int high) {
		if(arr == null || arr.length <= 1) {
			return;
		}
		if(low >= high) {
			return;
		}
		
		int i = low;
		int j = high; 
		int pivot = arr[low + (high - low) / 2];
		
		while(i <= j) {
			while(arr[i] < pivot) {
				i++;
			}
			
			while(arr[j] > pivot) {
				j--;
			}
			
			if(i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
			
			if(low < j) {
				qs2(arr, low, j);
			}
			if(high > i) {
				qs2(arr, i, high);
			}
		}
		
	}
	
	// the model for quick sort and quick select ! 
	public void qs3Model(int[] arr, int low, int high) {
		if(arr == null || arr.length <= 1) {
			return;
		}
		
		if(low >= high) {
			return;
		}
		
		int pivot = high;
		int j = low; 
		
		for(int i = low; i < high; i++) {
			if(arr[i] <= arr[high]) {
				swap(arr,i, j);
				j++;
			}
		}
		
		swap(arr, j, pivot);
		
		if(low < j - 1) {
			qs3Model(arr, low, j - 1);
		}
		if(high > j + 1) {
			qs3Model(arr, j + 1, high);
		}
		
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	

}
