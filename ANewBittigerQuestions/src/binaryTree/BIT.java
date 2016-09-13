//package binaryTree;
//
//public class BIT {
//	public class TreeNodeE extends TreeNode {
//       int from;
//       int to; 
//       int sum; 
//        
//  
//       public TreeNode(int val) {  
//            this.val = val;  
//       }  
//
//}
//	
//

//	public TreeNode buildTree(int[] nums) {
//		if(nums == null) {
//			return new TreeNode(-1);
//		}
//		int len = nums.length;
//		
//		TreeNode root = new TreeNode(len / 2);
//		
//		
//		
//	}
//	
//	public TreeNode dfs( int nums, int from, int to) {
//		  
//		 if(from > to) {
//			 return null;
//		 }
//		 
//		 if(from == to) {
//			 return new TreeNode(nums[from], from, to );
//		 }
//		 
//		 int sum = 0;
//		 for(int i : nums) {
//			 sum += i;
//		 }
//		 
//		 TreeNode root = new TreeNode(sum,  from ,to);
//		 
//		 root.left = dfs( nums, from,(from + to) /2  );
//		 
//		 
//		 root.right = dfs( nums,  (from + to) / 2 + 1, to );
//				
//		
//	}
//
//}
