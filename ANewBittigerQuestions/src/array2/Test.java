package array2;

import sun.font.CreatedFontTracker;

public class Test {
	public static void main(String[] args) {
		CreatMaxNumber cmn = new CreatMaxNumber();
		int[] nums1 = {1, 2};
		int[] nums2 = {1, 2};
		
		int[] max = cmn.maxNumber(nums1, nums2, 3);
		System.out.println(max.toString());
		
		//System.out.println(-0x7ffffff);
		
		
	}
}
