package queue;

import java.util.LinkedList;
import java.util.Queue;

	
	class MyStack {
	    // Push element x onto stack.
	    Queue<Integer> q1 = new LinkedList<>();
	    Queue<Integer> q2 = new LinkedList<>();
	    
	    public void push(int x) {
	        q1.offer(x);
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        if(q1.isEmpty()) {
	            return;
	        }
	        
	        while(q1.size() > 1) {
	            q2.offer(q1.poll());
	        }
	        q1.poll();
	        swap(q1, q2);
	    }

	    // Get the top element.
	    public int top() {
	       if(q1.isEmpty()) {
	            return Integer.MIN_VALUE;
	       }
	        while(q1.size() > 1) {
	            q2.offer(q1.poll());
	        }
	        
	        int temp = q1.peek();
	        q2.offer(q1.poll());
	        swap(q1, q2);
	        
	        return temp; 
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        return q1.isEmpty();
	    }
	    // 传入的reference 是拷贝的reference  
	    public void swap(Queue q1, Queue q2) {
	        Queue temp = q1;
	        q1 = q2; 
	        q2 = temp; 
	        
	    }
	    
	}

