package leetcodeafter11;

import java.util.LinkedList;

public class QueueWithLinkedList<T> {
		LinkedList<T> llh = new LinkedList<T>();
		LinkedList<T> lll = new LinkedList<T>();
		
		public void offer(T t,char priority){
			if(priority == 'h')
				llh.offer(t);
			if(priority == 'l')
				lll.offer(t);
		}
		
		public T poll(){
			if(!llh.isEmpty()){
				return llh.pollFirst();
			} 
			if(!lll.isEmpty()){
				return lll.pollFirst();
			} else{
				return (T) "Empty";
			}
		}
		

}
