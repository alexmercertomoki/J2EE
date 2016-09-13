package lists;

import java.util.ArrayList;


public class Test {
	
	public static void main(String[] args) {
		
//		
//		ListNodeWithLayers head = new ListNodeWithLayers(1);
//		ListNodeWithLayers node2 = new ListNodeWithLayers(2);
//		ListNodeWithLayers node3 = new ListNodeWithLayers(3);
//		ListNodeWithLayers node4 = new ListNodeWithLayers(4);
//		ListNodeWithLayers node7 = new ListNodeWithLayers(7);
//		ListNodeWithLayers node9 = new ListNodeWithLayers(9);
//		ListNodeWithLayers node14 = new ListNodeWithLayers(14);
//		ListNodeWithLayers node15 = new ListNodeWithLayers(15);
//		ListNodeWithLayers node23 = new ListNodeWithLayers(23);
//		ListNodeWithLayers node24 = new ListNodeWithLayers(24);
//		ListNodeWithLayers node8 = new ListNodeWithLayers(8);
//		ListNodeWithLayers node16 = new ListNodeWithLayers(16);
//		ListNodeWithLayers node17 = new ListNodeWithLayers(17);
//		ListNodeWithLayers node18 = new ListNodeWithLayers(18);
//		ListNodeWithLayers node19 = new ListNodeWithLayers(19);
//		ListNodeWithLayers node20 = new ListNodeWithLayers(20);
//		ListNodeWithLayers node21 = new ListNodeWithLayers(21);
//		ListNodeWithLayers node10 = new ListNodeWithLayers(10);
//		ListNodeWithLayers node11 = new ListNodeWithLayers(11);
//		ListNodeWithLayers node12 = new ListNodeWithLayers(12);
		
		
		
		
//		head.next = node2;
//		head.next.next = node3;
//		head.next.next.next = node4;
//		head.next.down = node7;
//		head.next.down.down = node9;
//		head.next.down.down.down = node14;
//		head.next.down.down.down.down = node15;
//		head.next.down.down.down.down.next
//										= node23;
//		head.next.down.down.down.down.next.down
//										= node24;
//		head.next.down.next = node8;
//		head.next.down.next.down = node16;
//		head.next.down.next.down.down = node17;
//		head.next.down.next.down.down.next
//										= node18;
//		head.next.down.next.down.down.next.next
//										= node19;
//		head.next.down.next.down.down.next.next.next
//										= node20;
//		head.next.down.next.down.down.next.next.next.down
//										= node21;
//		head.next.down.next.next = node10;
//		head.next.down.next.next.down = node11;
//
//		head.next.down.next.next.next = node12;

//		FlattenLinkedList2 fll = new FlattenLinkedList2();
//		fll.dfs1(head, null);
//		
//		while(head != null) {
//			System.out.println(head.data);
//			head = head.next;
//		}
		
//		FlattenLinkedList1 fl = new FlattenLinkedList1();
//		ListNodeWithLayers res1 = fl.flatten(head);
//		ListNodeWithLayers res2 = fl.flattenEX(head);
//		
//		
//		while(res1 != null) {
//			System.out.print("  " + res1.data);
//			res1 = res1.next;
//		}
//		System.out.println();
//		while(res2 != null) {
//			System.out.print("  " + res2.data);
//			res2 = res2.next;
//		}
		
		
//		
//		FibonacciLastDigit fld = new FibonacciLastDigit();
//		long res1 = fld.FibonacciLastDigitMethod1(62);
//		long res2 = fld.FibonacciLastDigitMethod2(62);
//		System.out.println(" the result is" + res1);
//		System.out.println(" the result is" + res2);
		
//		TreeNode root1 = new TreeNode(2);
//		root1.left = new TreeNode(1);
//		root1.right = new TreeNode(7);
//		
//		TreeNode root2 = new TreeNode(6);
//		root2.left = new TreeNode(1);
//		root2.right = new TreeNode(7);
//		
//		FindCommonNodeInBST fc = new FindCommonNodeInBST();
//		ArrayList<TreeNode> res = fc.fcniBST(root1, root2);
//		
//		for(TreeNode node : res) {
//			System.out.println(node.data);
//		}
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		ListNodeFunctions rmln = new ListNodeFunctions();
		
		//rmln.removeNthFromEnd(head, 1);
		rmln.swapPairs(head);
		
	}

}
