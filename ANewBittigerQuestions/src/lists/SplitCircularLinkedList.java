package lists;

import java.util.ArrayList;
import java.util.List;

public class SplitCircularLinkedList {
	public List<ListNode> splitCircularlltoHalves(ListNode l1) {
		List<ListNode> ret = new ArrayList<>();
		
		ListNode mid = findMid(l1);
		ret.add(mid.next);
		mid.next = null;
		ret.add(l1);
		
		return ret;
	}
	
	public ListNode findMid(ListNode listNode) {
		if(listNode == null || listNode.next == null) {
			return listNode;
		}
		
		ListNode slow = listNode;
		ListNode fast = listNode; 
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
		
	}
	
	
	
}
