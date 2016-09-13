package lists;

public class ListNodeFunctions {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
       
        int count = 0;
        while(fast != null && count < n) {
             count++;
             fast = fast.next;
        }
        if(count < n) {
            return head;
        }
        
        while(fast != null) {
            head = head.next;
            slow = slow.next;
            fast = fast.next;
        }
        
        head.next = slow.next;
        return dummy.next;
        
    }
	
	 public ListNode swapPairs(ListNode head) {
	        if(head == null || head.next == null) {
	            return head;
	        }
	        ListNode newHead = head.next;
	        ListNode nextNode = head.next;
	        while(nextNode != null && nextNode.next != null) {
	            
	            ListNode superNode = nextNode.next; 
	            nextNode.next = head;
	            if(superNode == null) {
	                head.next = null;
	                break;
	            } 
	            head.next = superNode.next;
	            nextNode = superNode.next;
	            head = superNode;

	        }
	        
	        return newHead;
	        
	    }

}
