package part1OA;

public class TreeAmplitude {
		public int calcAmplitude(TreeNode root){
			if(root == null) return 0; 
			
			return helper(root, root.val, root.val);
			
		}
		public int helper(TreeNode root, int min, int max){
			if(root == null) return max - min;
			if(root.val > max) max = root.val;
			if(root.val < min) min = root.val;
			
			return Math.max(helper(root.left, min, max), helper(root.right, min, max));
		}
}
