package lintCodeWorkOut;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class UglyNumberMine {
	    /**
	     * @param k: The number k.
	     * @return: The kth prime number as description.
	     */
	    public long kthPrimeNumber(int k) {
	        // write your code here
	        if(k <= 0) {
	            return 0;
	        }
	        
	        Set<Long> set = new HashSet<>();
	        Queue<Long> q = new PriorityQueue<>();
	        
	        long[] primes = new long[3];
	        primes[0] = 3;
	        primes[1] = 5;
	        primes[2] = 7;
	        
	        for(int i = 0; i < 3; i++) {
	            q.offer(primes[i]);
	            set.add(primes[i]);
	        }
	        
	        long number = 0;
	        for(int i = 0; i < k; i++) {
	            number = q.poll();
	            
	            for(int j = 0; j < 3; j++) {
	                long temp = number * primes[j];
	                if(!set.contains(temp)) {
	                    q.offer(temp);
	                    set.add(temp);
	                }
	            }
	            
	        }
	        return number;
	    }

}	
