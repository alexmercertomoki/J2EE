package trytry;

import java.util.LinkedList;


	public class uglyNum {
	    
	    int i = 1, j = 1, k = 1;
	    LinkedList<Integer> ll = new LinkedList<Integer>();
	    
	    public int nthUglyNumber(int n) {
	        ll.add(1);
	        int h = ll.get(0);
	        int times = 1;
	        while (times < n){
	        	if(times == 5){
	        		System.out.println("this one");
	        	}
	            min(i,j,k);
	            times ++;
	        }
	        return ll.get(n - 1).intValue();
	    }
	    private void min(int ii, int jj, int kk){
	        
	        if(ii * 2> jj * 3 || ii * 2 > kk * 5) {
	           if (jj * 3 > kk * 5) {
	               k = kk * 5; 
	               ll.add(k);
	           } else {
	               j = jj * 3; 
	               ll.add(j);
	           }
	           
	        } else {
	            i = ii * 2;
	            ll.add(i);
	        } 
	    }
	    
	}
	
