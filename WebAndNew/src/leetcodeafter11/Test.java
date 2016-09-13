package leetcodeafter11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
	public static void main(String[] args) {
//		Romantoint rmi = new Romantoint();
//		int res = rmi.romanToInt("DM");
//		System.out.println(res);

//		QueueWithLinkedList<String>  qwl = new QueueWithLinkedList<String>();
//		qwl.offer("Hello World!", 'h');
//		qwl.offer("Hello World2!", 'h');
//		qwl.offer("Hello World3!", 'h');
//		
//		qwl.offer("Hello11", 'l');
//		qwl.offer("Hello12", 'l');
//		qwl.offer("Hello13", 'l');
//		
//		int i = 0;
//		while(i < 7){
//			System.out.println(qwl.poll());
//			i ++;
//		}
		
		Stack st = new Stack();
		st.push("Hello");
		System.out.println(st.isEmpty());
		
		Queue<String> qu = new LinkedList<String>(); // with LinkedList or ArrayDeque
		qu.offer("Hello");
		System.out.println(qu.isEmpty());
		
	}
}
