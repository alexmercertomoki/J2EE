package part1OA;

public  class Swap {
	 public static void swap(int[] arr, int a, int b){
		 
		 
		 
		 arr[a] ^= arr[b];
		 arr[b] ^= arr[a];
		 arr[a] ^= arr[b]; // revert  manipulation  can give you swap : += -=; *= /= ; ^= ^= 
	 }
	 
	 
}
