package dfs_workout;

import java.util.ArrayList;


public class Preorder_Traversal {
	 public ArrayList<Integer> preorderTraversal(TreeNode root) {
	        // write your code here
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        
	        if(root == null) {
	            return result;
	        }
	        // better for threads left   and    right 
	        ArrayList<Integer> left =  preorderTraversal(root.left);
	        ArrayList<Integer> right = preorderTraversal(root.right);
	        
	        result.add(root.val);
	        result.addAll(left);
	        result.addAll(right);
	        return result; 
	        
	 }
}
