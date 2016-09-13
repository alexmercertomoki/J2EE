package strstr;

public class TryList {
	private static class ListNode {
		     int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
   }
	public static void main(String[] args) {
		
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next= new ListNode(4);
		ListNode delete = l.next.next;
		
		l.next.next.next.next = new ListNode(5);
		
		ListNode cur = l;
		while(cur != null){
			System.out.println(cur.val);
			cur = cur.next;
		}
		
		delete = delete.next; 
		cur = l;
		while(cur != null){
			System.out.println(cur.val);
			cur = cur.next;
		}
		
	}

}
