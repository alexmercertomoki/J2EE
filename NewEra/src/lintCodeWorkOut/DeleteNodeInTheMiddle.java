package lintCodeWorkOut;

public class DeleteNodeInTheMiddle {
	    /**
	     * @param node: the node in the list should be deleted
	     * @return: nothing
	     */
	
	    public void deleteNode(ListNode node) {
	        // write your code here
	        
	        ListNode dummy = new ListNode(-1);
	        dummy.next = node;
	        
	        ListNode prev = dummy;
	        ListNode fast = node;
	        ListNode slow = node;
	        
	        while(fast != null && fast.next != null) {  // why this doesn't work????
	            fast = fast.next.next;
	            slow = slow.next;
	            prev = prev.next;
	        }
	        prev.next = slow.next;
	    }
}
