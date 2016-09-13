package basic_sort;

public class Test {
	
		public static void main(String[] args) {
			int[] nums = {1, 10, 2, 8, 3, 6, 7, 4};
			
			
//			Bubble b = new Bubble();
//			nums = b.bubbleSort(nums);
//			for(int num : nums) {
//				System.out.println(num);
//			}
			
			
			
//			Insertion is = new Insertion();
//			nums = is.insertionSort(nums);
//			for(int num : nums) {
//				System.out.println(num);
//			}
			
		//	MergeSort ms = new MergeSort();
			
//			MergeSortMine msm = new MergeSortMine();
//			nums = msm.mergeSort(nums);
//			for(int num : nums) {
//				System.out.println(num);
//			}
			
//			QuickSort qs = new QuickSort();
//			nums = qs.quickSort(nums);
//			
//			for(int num : nums) {
//				System.out.println(num);
//			}
			
			
//			ListInsertionSort 
			
			ListNode head = new ListNode(1);
			ListNode h2 = new ListNode(10);
			ListNode h3 = new ListNode(8);
			ListNode h4 = new ListNode(-1);
			
			head.next = h2;
			h2.next = h3;
			h3.next = h4;
			
			ListInsertionSort lis = new ListInsertionSort();
			lis.insertionSortList(head);
			
			
		}
		
}
