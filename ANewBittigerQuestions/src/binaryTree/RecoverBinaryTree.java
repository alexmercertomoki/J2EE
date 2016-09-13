package binaryTree;

import java.util.Stack;

public class RecoverBinaryTree {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	 
    public void recoverTree(TreeNode root) {
    	
        Stack<TreeNode> stack = new Stack<>();
        TreeNode n1 = null;
        TreeNode n2 = null;
        
        TreeNode prev = null;
        TreeNode cur = null;
        
        boolean foundWrongFlag = false;
        
        while(true) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            
            if(stack.isEmpty()){
                break;
            }
            
            TreeNode temp = stack.pop();
            if(prev == null) {
                prev = temp;
            } else if(cur == null) {
                cur = temp;
            } else {
                prev = cur;
                cur = temp;
            }
            
            
            if(prev != null && cur != null && prev.val > cur.val) {
                if(foundWrongFlag){
                    n2 = cur;
                    break;
                } else {
                    n1 = prev;
                    n2 = cur; 
                    foundWrongFlag = true;
                }
            }
            
            if(temp.right != null) {
                root = temp.right;
            }
        }
        int tempNodeVal = n1.val;
        n1.val = n2.val;
        n2.val = tempNodeVal;
        
    }

}
