import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    Queue<Integer> q;
    int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
    	q = new LinkedList<>();
    	this.size = size;
    }
    
    public double next(int val) {
    	if(q.size() < size) {
    		q.offer(val);
    	} else {
    		q.poll();
    		q.offer(val);
    	}
    	
    	int sum = 0;
    	for(int num : q) {
    		sum += num;
    	}
    	
    	return  (double)sum / q.size();
    	
    }
}