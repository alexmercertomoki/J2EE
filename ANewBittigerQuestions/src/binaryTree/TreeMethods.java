package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeMethods {
	public int getNodeNumber(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		return getNodeNumber(root.left) + getNodeNumber(root.right) + 1;
		
	}
	
	
	public int getNodeNumber2(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		int sum = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				
				if(node.left != null) {
					q.offer(node.left);
				}
				if(node.right != null) {
					q.offer(node.right);
				}
			}
			sum += size;
		}
		return sum;
	}
	
	
	
	public int getNodeNumber3(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		int sum = 1;
		
		while(!q.isEmpty()) {
			TreeNode cur = q.poll();
			
			if(cur.left != null) {
				sum++;
				q.offer(cur.left);
			}
			if(cur.right != null) {
				sum++;
				q.offer(cur.right);
			}
		}
		return sum;
	}
	
	public int getDepth(TreeNode root){
		if(root == null) {
			return 0;
		}
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		
		return Math.max(left, right) + 1;
	}
	
	
	public int getDepthIter(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int depth = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if(node.left != null) {
					q.offer(node.left);
				}
				if(node.right != null){
					q.offer(node.right);
				}
			}
			depth++;
		}
		return depth;
		
	}
	
	public void preorder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		System.out.print("   " + root.val);
		preorder(root.left);
		preorder(root.right);
		
	}
	
	
	public void preorderIter(TreeNode root) {
		if(root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode cur = stack.pop();
			System.out.print("   " + cur.val);
			if(cur.right != null) {
				stack.push(cur.right);
			}
			if(cur.left != null) {
				stack.push(cur.left);
			}
			
		}
		
	}
	
	
	public void inorder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		inorder(root.left);
		System.out.print( " " + root.val);
		inorder(root.right);
		
	}
	
	
	public void inorderIter(TreeNode root) {
		if(root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		
		while(true) {
			while(cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			
			if(stack.isEmpty()) {
				break;
			}
			
			cur = stack.pop();
			System.out.print(" " + cur.val);
			cur = cur.right;
			
		}
		
	}
	
	public void postOrder(TreeNode root) {
		
		if(root == null) {
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);	
		System.out.print(" " + root.val);
		
	}
	
	public void postOrderIter(TreeNode root) {
		if(root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> output = new Stack<TreeNode>();
		stack.push(root);
		TreeNode cur;
		
		while(!stack.isEmpty()) {
			cur = stack.pop();
			output.push(cur);
			
			if(cur.left != null) {
				stack.push(cur.left);
			}
			if(cur.right != null) {
				stack.push(cur.right);
			}
			
		}
		
		while(!output.isEmpty()) {
			cur = output.pop();
			System.out.print(" " + cur.val);
		}
		
	}
	
	
	public  ArrayList<ArrayList<Integer>> levelOrderIter(TreeNode root) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if(root == null) {
			return ret;
		}
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			ArrayList<Integer> arr = new ArrayList<Integer>();
			TreeNode node;
			for(int i = 0; i < size; i++) {
				node = q.poll();
				arr.add(node.val);
				if(node.left != null){
					q.offer(node.left);
				}
				if(node.right != null) {
					q.offer(node.right);
				}
			}
			ret.add(arr);
		}
		
		return ret;
		
	}
	
	public ArrayList<ArrayList<Integer>> levelOrderRecursion(TreeNode root) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		levelOrderDFSHelper(root, 0, ret);
		
		return ret;
		
		
	}
	
	public void levelOrderDFSHelper(TreeNode root, int level, ArrayList<ArrayList<Integer>> ret) {
		if(root == null) {
			return;
		}
		
		if(level >= ret.size()) {
			ret.add(new ArrayList<Integer>());
		}
		
		ret.get(level).add(root.val);
		levelOrderDFSHelper(root.left, level + 1, ret);
		levelOrderDFSHelper(root.right, level + 1, ret);
		
	}
	
	 public static TreeNode convertBST2DLLSubRec(TreeNode root){  
	        if(root==null || (root.left==null && root.right==null)){  
	            return root;  
	        }  
	          
	        TreeNode tmp = null;  
	        if(root.left != null){          // 处理左子树  
	            tmp = convertBST2DLLSubRec(root.left);  
	            while(tmp.right != null){   // 寻找最右节点  
	                tmp = tmp.right;  
	            }  
	            tmp.right = root;       // 把左子树处理后结果和root连接  
	            root.left = tmp;  
	        }  
	        if(root.right != null){     // 处理右子树  
	            tmp = convertBST2DLLSubRec(root.right);  
	            while(tmp.left != null){    // 寻找最左节点  
	                tmp = tmp.left;  
	            }  
	            tmp.left = root;        // 把右子树处理后结果和root连接  
	            root.right = tmp;  
	        }  
	        return root;  
	    }  
	
	
	
	

}
