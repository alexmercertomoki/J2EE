package binarysearchtree;

import java.util.ArrayList;
import java.util.List;


 
 
public class Solution {
	private static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
    public static List<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> result =new ArrayList<Integer>();
    	Help(root,result);
    	return result;
    	
    }
    // adding to the original instance //????
    private static void Help(TreeNode root, ArrayList<Integer> rel){
    		if(root==null){
    			return;
    		}
    		rel.add(root.val);
    		Help(root.left,rel);
    		Help(root.right,rel);
    		
    }
    
    
    
    public static void main(String[] args) {
		  
        TreeNode root =new TreeNode(1);
        root.left=new TreeNode(2);
        root.right =new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
    	
        List<Integer> list = preorderTraversal(root);
        
        for(int e : list){
        	System.out.println(e);
        }
        
         
    	
	}
}
