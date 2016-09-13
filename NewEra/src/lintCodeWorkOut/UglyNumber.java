package lintCodeWorkOut;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class UglyNumber {
	 public long kthPrimeNumber(int n) {        
	        Queue<Long> Q = new PriorityQueue<Long>();
	        HashMap<Long, Boolean> inQ = new HashMap<Long, Boolean>();
	        Long[] primes = new Long[3];
	        primes[0] = Long.valueOf(3);
	        primes[1] = Long.valueOf(5);
	        primes[2] = Long.valueOf(7);
	        for (int i = 0; i < 3; i++) {
	            Q.add(primes[i]);
	            inQ.put(primes[i], true);
	        }
	        Long number = Long.valueOf(0);
	        for (int i = 0; i < n; i++) {
	            number = Q.poll();
	            for (int j = 0; j < 3; j++) {
	                if (!inQ.containsKey(primes[j] * number)) {
	                    Q.add(number * primes[j]);
	                    inQ.put(number * primes[j], true);
	                }
	            }
	        }
	        return number;
	    }
}
