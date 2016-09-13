package google;

public class googleOA {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		DuplicateLarge dl = new DuplicateLarge();
//		int i = dl.dupNumber(923);
//		System.out.println(i);
//		LongestPath lp = new LongestPath();
//		int res = lp.longestPath("dir1\n dir2\n dir3\n  1.txt\n  2.png\n dir4"
//				+ "\n  23.png\ndir5\n 1234567.jpeg");
//		System.out.println(res);
		
		
		LongestSubStringMine lsm = new LongestSubStringMine();
		int max = lsm.longFile("dir1\n dir2\n dir3\n  1.txt\n  2.png\n dir4"
				+ "\n  23.png\ndir5\n 1234567.jpeg");
		
		System.out.println(max);
		
//		DupNumbers dm = new DupNumbers();
//		int[] input = {1, 3, 2};
//		input = dm.duplicateNumber(input);
//		
//		for(int a : input) {
//			System.out.println(a);
//		}
		
//		DuplicateNumberMine dmm = new DuplicateNumberMine();
//		int[] input = {9, 8, 4};
//		input = dmm.dupNum(input);
//		for(int a : input) {
//			System.out.println(a);
//		}
		
//		char i = '2';
//		System.out.println(i - 48);
//		
	}

}
