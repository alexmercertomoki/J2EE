package dfs_workout;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
//		Preorder_Traversal pt = new Preorder_Traversal();
		TreeNode tnr = new TreeNode(1);
		TreeNode tn1 = new TreeNode(2);
		TreeNode tn2 = new TreeNode(3);
		TreeNode tn3 = new TreeNode(4);
		TreeNode tn4 = new TreeNode(5);
//
		tnr.left = tn1;
		tnr.right = tn2;
		tn1.left = tn3;
		tn1.right =tn4; 
//		
//		ArrayList<Integer> arr = pt.preorderTraversal(tnr);
//		
//		for(int res : arr) {
//			System.out.println(res);
//		}
		
		Binary_Tree_Path_Sum btps = new Binary_Tree_Path_Sum();
		List<List<Integer>> arr = btps.binaryTreePathSum(tnr, 7);
		for(List<Integer> val : arr) {
			for(int i : val) {
				System.out.print(" " + i);
			}
			System.out.println();
		}
	}
	
}
