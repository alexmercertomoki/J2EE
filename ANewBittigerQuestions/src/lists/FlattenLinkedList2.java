package lists;
import java.util.ArrayList;





public class FlattenLinkedList2 {
	
	public void dfs1(ListNodeWithLayers head, ListNodeWithLayers tail) {

		if(head.next == null && head.down == null) {
			head.next = tail;
		} else if(head.next == null) {
			head.next = head.down;
			head.down = null;
			dfs1(head.next, tail);
		} else if (head.down == null) {
			dfs1(head.next, tail);
		} else {
			ListNodeWithLayers tmp = head.next;
			head.next = head.down;
			head.down = null;
			dfs1(head.next, tmp);
			dfs1(tmp, tail);
		}
		
	}
	
	public ListNodeWithLayers dfs2(ListNodeWithLayers head, ListNodeWithLayers tail) {
		
		if(head.next == null && head.down == null) {

		
		}
		
		
		return null;
	}
	
	
	
	
	

}
