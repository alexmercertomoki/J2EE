package part1OA;

public class LinkedListLoop {
		public boolean hasLoop(ListNode head){
			
			if(head == null) return false;
			
			ListNode slow = head; 
			ListNode fast = head; 
			
			do{
			   if(fast.next == null || fast.next.next == null ){
				  return false;
			   }
			   slow = slow.next;
			   fast = fast.next.next;
				
			}while(slow != fast);
			
			return true;
		}
		
		public ListNode detectLoop(ListNode head){
			if(head == null) return null;
			
			ListNode slow = head;
			ListNode fast = head;
			
			do{
				if(fast.next == null  || fast.next.next == null){
					return null; 
				}
				slow = slow.next;
				fast = fast.next.next; 
				
				
			}while(slow != fast);
			
			while(head != slow){
				head = head.next;
				slow = slow.next;
			}
			
			
			return slow;
		}
		
		
}
