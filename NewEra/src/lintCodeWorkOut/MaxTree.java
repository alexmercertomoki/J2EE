package lintCodeWorkOut;

public class MaxTree {
	    /**
	     * @param A: Given an integer array with no duplicates.
	     * @return: The root of max tree.
	     */
	    public TreeNode maxTree(int[] A) {
	        // write your code here
	        int len = A.length;
	        TreeNode[] stk = new TreeNode[len];
	        for (int i = 0; i < len; ++i)
	            stk[i] = new TreeNode(0);
	        int cnt = 0;
	        for (int i = 0; i < len; ++i) {
	            TreeNode tmp = new TreeNode(A[i]);
	            while (cnt > 0 && A[i] > stk[cnt-1].val) {
	                tmp.left = stk[cnt-1];
	                cnt --;
	            }
	            if (cnt > 0)
	                stk[cnt - 1].right = tmp;
	            stk[cnt++] = tmp;
	        }
	        return stk[0];
	    }
}
