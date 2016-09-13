package trytry;

public class ListAdd {
	ListNode  l2 = new ListNode(1);
	ListNode head = l2;
	
	public ListNode test(){
		add(2);
		add(5);
		add(9);
		add(10);
		return head;
	}
	
	private  void add(int val){
		l2.next = new ListNode(val);
		l2 = l2.next;
	}
}
