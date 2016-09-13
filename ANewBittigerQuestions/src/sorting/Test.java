package sorting;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		
		//正常：快速选择时间复杂度分析: 从n ---- n / 2 ---n / 4 ---- 1正常 就是n + n / 2 ~~ 所以是O(n)
		//升级：走到底就是n * log N(层数) 
		//最坏：worst case 就是每次只排除1个元素 就是n + n - 1 + n - 2 + ....+ 1 所以是 n 平方 
		
		int[] numbers = {6 ,7 ,-10 ,-100,5 ,2, 4 , 3, 1, 100,100,100,3,3,-1, -1, 0, 36,355};
		QuickSort qs = new QuickSort();
//	//	qs.quickSort(numbers, 0, numbers.length - 1);
//		qs.qs2(numbers, 0, numbers.length -1);
//		System.out.println(Arrays.toString(numbers));
		
		//模板解决快速排序类问题，绝对给力！
		qs.qs3Model(numbers, 0, numbers.length - 1);
		System.out.println(Arrays.toString(numbers));
		
		
		
//		int[] numbers = {3,2,1,5,6,4};
//		
//		QuickSelect qs = new QuickSelect();
//		int large = qs.quickSelectKthSmall(numbers, 2);
//		System.out.println(large);
		
		
		
		
		
	}
	
}
