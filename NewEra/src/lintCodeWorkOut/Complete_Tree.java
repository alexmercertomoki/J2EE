package lintCodeWorkOut;

import java.util.LinkedList;
import java.util.Queue;

public class Complete_Tree {
	public boolean isComplete(TreeNode root) {
        // Write your code here
    	if (root == null) {
    		return true;
    	}

    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
        boolean flag = false;
    	while (!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		if (flag && (node.left != null || node.right != null)) {
    		    return false;
    		}
    		if (node.left == null && node.right != null) {
    			return false;
    		} else if (node.left == null || node.right == null) {
    		    flag = true;
    		} 
    		if (node.left != null) {
        		queue.offer(node.left);    		    
    		}
            if (node.right != null) {
                queue.offer(node.right);    
            }
    	}

    	return true;
        
    }
}
