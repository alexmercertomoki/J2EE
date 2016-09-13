package binaryTreeExtra;

import java.util.ArrayList;


public class Test {
	
	public static void main(String[] args) {
		
		
//		
//		FibonacciLastDigit fld = new FibonacciLastDigit();
//		long res1 = fld.FibonacciLastDigitMethod1(62);
//		long res2 = fld.FibonacciLastDigitMethod2(62);
//		System.out.println(" the result is" + res1);
//		System.out.println(" the result is" + res2);
		
		TreeNode root1 = new TreeNode(2);
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(7);
		
		TreeNode root2 = new TreeNode(6);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(7);
	
		FindCommonNodeInBST fc = new FindCommonNodeInBST();
		ArrayList<TreeNode> res = fc.fcniBST(root1, root2);
		
		for(TreeNode node : res) {
			System.out.println(node.data);
		}
		
		
	}

}
