

public class BStT {
	static Node root=null;
	private static class Node<T> {
		private int val;
		private Node<T> left;
		private Node<T> right;

		public Node(int data) {
			this(data, null, null);
		}

		public Node(int data, Node left, Node right) {
			this.val = data;
			this.left = left;
			this.right = right;
		}
		
		
	}
	public static void main(String[] args) {
		
		BStT bst=new BStT();
		bst.add(3);
		bst.add(4);
		bst.add(5);
		bst.add(8);
		System.out.println(bst.heightHelper(root));
		
	}
	public void add(int val){
		
		Node v=new Node(val, null,null);
		
		if(root==null){
			root= v;
		}
		else{
			this.insertHelper(v, root);
		}
		
	}
	
	public void insertHelper(Node val, Node next){
//		Node Parent =next;
		
		
		if(val.val>=next.val){
			if(next.right!=null){
				insertHelper(val, next.right);
			}
			else{
				next.right=val;
			}
				
		}
		
		else if(val.val<next.val){
			if(next.left!=null){
				insertHelper(val,next.left);
			}
			else{
				next.left=val;
			}
		}
		
	}
	public int heightHelper(Node rt){
		if(rt==null){
			return 0;
		}
		
		return  Math.max(heightHelper(rt.left), heightHelper(rt.right))+1;
		
		
	}
	

}
