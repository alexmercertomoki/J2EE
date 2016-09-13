package lists;
import java.util.LinkedList;
import java.util.Queue;





public class FlattenLinkedList1 {
	
	public ListNodeWithLayers flatten (ListNodeWithLayers head) {
		if(head == null) {
			return head;
		}
		
		ListNodeWithLayers res = head;
		ListNodeWithLayers tail = head;
				
		Queue<ListNodeWithLayers> q = new LinkedList<>();
		
		while(true) {
			while(head != null) {
				if(head.down != null) {
					q.offer(head.down);
					head.down = null;
				}
				
				if(head.next == null) {
					tail = head;	
				}
				
				head = head.next;
			}
			
			if(!q.isEmpty()) {
				head = q.poll();
				tail.next = head;
				
			} else {
				break;
			}
			
		}
		
		return res;
		
	}

	
	public ListNodeWithLayers flattenEX (ListNodeWithLayers head) {
		if(head == null) {
			return head;
		}
		
		ListNodeWithLayers res = head;
				
		Queue<ListNodeWithLayers> q = new LinkedList<>();
		
		while(true) {
			while(head.next != null) {
				if(head.down != null) {
					q.offer(head.down);
					head.down = null;
				}
				
				head = head.next;
			}
			
			if(head.down != null) {
				q.offer(head.down);
				head.down = null;
			}
			
			
			if(!q.isEmpty()) {
				head.next = q.poll();
				head = head.next;
				
			} else {
				break;
			}
			
		}
		
		return res;
		
	}
	
	
}
