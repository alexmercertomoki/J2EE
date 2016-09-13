package trytry;

public class MergeTwoSorted {
		
	 	 ListNode l3; 
	    ListNode head; 
	    
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1 == null) 
	            return l2;
	        if(l2 == null)
	            return l1;
	        
	      
	        
	        while(l1 != null && l2 != null) {
	            if(l1.val < l2.val){
	                add(l1.val);
	                l1 = l1.next;
	            } else {
	                add(l2.val);
	                l2 = l2.next;
	            }
	        }
	        
	        if(l1 != null){
	            l3.next = l1; /// why is l1 not added  here ???? p1 
	        } else {
	            l3.next = l2;
	        }
	            return head;
	        
	    }
	    
	    private void add(int val){
	        
	        if(l3 == null){
	            l3 = new ListNode(val); // last way were adding to cur not l3 
	            head = l3 ; 
	        } else{
	            l3.next = new ListNode(val);
	            l3 = l3.next;
	        }
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(4);
		MergeTwoSorted m1 = new MergeTwoSorted();
		
		
		ListNode x2 = m1.mergeTwoLists(l1, l2);
	
		while(x2 != null){
			 System.out.println(x2.val);
			 x2 = x2.next;
		}

	}

}
