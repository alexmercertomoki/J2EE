package binaryTreeExtra;

import java.util.ArrayList;
import java.util.Stack;

public class FindCommonNodeInBST {
	
	public ArrayList<TreeNode> fcniBST(TreeNode t1, TreeNode t2) {
		
		ArrayList<TreeNode> res = new ArrayList<>();
		
		if(t1 == null || t2 == null) {
			return res; 
		}
		
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		
		while(true) {
			if(t1 != null) {
				stack1.push(t1);
				t1 = t1.left;
			} else if(t2 != null) {
				stack2.push(t2);
				t2 = t2.left;
			} else if (!stack1.isEmpty() && !stack2.isEmpty()) {
				t1 = stack1.peek();
				t2 = stack2.peek();
				
				if(t1.data == t2.data) {
					res.add(t1);
					stack1.pop();
					stack2.pop();
					t1 = t1.right;
					t2 = t2.right;
					
				} else if(t1.data < t2.data) {
					stack1.pop();
					t1 = t1.right;
					t2 = null;
				} else {
					stack2.pop();
					t2 = t2.right;
					t1 = null;
				}
			} else {
				break;
			}
		}
		
		return res;
	}
	
	
	public void helper(TreeNode t1) {
		if(t1 == null) {
			return;
		}
		
		helper(t1.left);
		System.out.println(t1.data);
		helper(t1.right);
		
	}
	

}
