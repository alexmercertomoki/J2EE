package part1OA;
import java.lang.Math;

public class TestAll1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {1,2,3,4,5,6,7,8};
//		Swap.swap(arr,0 ,1);
//		
//		for(int i : arr){
//			System.out.println(i);
//		}
		
		
		
//		int[] arr;
//		FourIntegers fi = new FourIntegers();
//		arr = fi.Solutions(5,6,7,8);
//		
//		for(int i : arr){
//			System.out.println(i);
//		}
//		System.out.println("Difference" );
//		System.out.println(Math.abs(arr[0] - arr[1])+ Math.abs(arr[1] - arr[2]) + Math.abs(arr[2] - arr[3] ));
//	   abs() is a static method in Math class	
		
//		LinkedListLoop lll = new LinkedListLoop();
//		ListNode n1 = new ListNode(1);
//		ListNode n2 = new ListNode(2);
//		ListNode n3 = new ListNode(3);
//		ListNode n4 = new ListNode(4);
//		ListNode n5 = new ListNode(5);
//		
//		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
//		n5.next = n4;
////		boolean r = lll.hasLoop(n1);
////		System.out.println(r);
//		ListNode loopNode = lll.detectLoop(n1);
//		System.out.println(loopNode.val);
		
		
//		SumOfWindows sow = new SumOfWindows();
//		
//		int[] arr = {1,2,3,4,5,6,20};
//		int[] result = sow.solutionOfkwindows(arr, 2);
//		for(int i : result){
//			System.out.println(i);
//		}
		
		
//		ArithmeticSlice as = new ArithmeticSlice();
//		int[] array = {1,2,3,4,5,6,7,8,9,10};
//		int res = as.arithmeticSliceNumber(array);
//		System.out.println(res);
		
		
//		TreeNode tr1 = new TreeNode(1);
//		TreeNode tr2 = new TreeNode(2);
//		TreeNode tr3 = new TreeNode(3);
//		TreeNode tr4 = new TreeNode(4);
//		tr1.left = tr2;
//		tr1.right = tr3;
//		tr3.right = tr4;
//		
//		TreeAmplitude ta = new TreeAmplitude();
//		int amplitude = ta.calcAmplitude(tr1);
//		System.out.println(amplitude);
		
		
//		RoundRobinScheduling rrs = new RoundRobinScheduling(); 
//		int[] at = {1,2,3,7};
//		int[] et = {2,1,4,8};
//		float wt = rrs.rrs(at, et, 3);
//		System.out.println(wt);
		
//		ShortestJobFirst sjf = new ShortestJobFirst(); 
//		int[] request = {0, 2, 4, 5};
//		int[] duration = {7, 4, 1, 4};
//		float wt = sjf.sjf(request, duration);
//		System.out.println(wt); 
		
		
//		DayChange1 dc1 = new DayChange1();
////		int[] array = {1, 0, 0, 0, 0, 1, 0, 0};
//		int[] array2 = {0,1,0,0,1,0};
//		
//		int[] res = dc1.dc1(array2, 1);   // 1 0 1 1 0 1
//		for(int i : res){
//			System.out.print(" " + i);
//		}
		
//		DayChange2 dc2 = new DayChange2();
//		int[] array3 = {0,1,0,0,1,0};
//		int[] res = dc2.dc2(array3, 1);
//		for(int i : res){
//			System.out.print(" " + i);
//		}
		
		
//		CacheMiss cm = new CacheMiss();
//		int[] taskarr = {1,2,3,4,5,4,1};
//		int count  = cm.cm(taskarr, 4);
//		System.out.println(count);
		
		
//	//	int[][] matrix = {{1,2},{3,4}};
//		int[][] matrix = new int[2][4]; 
//		for(int i : matrix[1]){
//			System.out.println(i);
//		}
		
//		RotateARect1  rar1 = new RotateARect1(); 
//		int[][] matrix = {{1,2},{3,4}};
////		System.out.println(matrix.length);
//		int[][] rotated = rar1.Solution(matrix, 1);
//		
//		for(int i : rotated[0]){
//			System.out.println(i);
//		}
		
		RotateARect2 rar2 = new RotateARect2();
		int[][] matrix = {{1,2},{3,4}};
		int[][] cm = rar2.rar2(matrix, true);
		
		for(int i : cm[1]){
			System.out.println(i);
		}
		
		
	}

}
