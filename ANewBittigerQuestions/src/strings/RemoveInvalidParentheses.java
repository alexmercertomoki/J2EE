package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {
	    public List<String> removeInvalidParentheses(String s) {
	        List<String> res = new ArrayList<>();
	        if(s == null || s.length() == 0) {
	            return res;
	        }
	        
	        Set<String> vSet = new HashSet<>();
	        Queue<String> q = new LinkedList<>();
	        
	        q.offer(s);
	        vSet.add(s);
	        
	     // once true minimum just continue
	        boolean found = false;
	        while(!q.isEmpty()) {
	            String tmp = q.poll();
	            
	            if(isValidP(tmp)) {
	                res.add(tmp);
	                found = true;
	            }
	            if(found) continue; 
	            
	            for(int i = 0; i < tmp.length(); i++) {
	            	
	            	//&& not or , also tmp~~ be aware of naming, next time try tmpStr or strT to be specific 
	                if(tmp.charAt(i) != '(' && tmp.charAt(i) != ')') {
	                    continue;
	                }
	                
	                String toAdd = tmp.substring(0, i) + tmp.substring(i + 1);
	                
	                if(!vSet.contains(toAdd)) {
	                    q.offer(toAdd);
	                    vSet.add(toAdd);
	                }
	            }
	        }
	        
	        return res;
	        
	    }
	    public boolean isValidP(String s) {
	        int count = 0;
	        for(int i = 0; i < s.length(); i++) {
	            if(s.charAt(i) == '(') {
	                count++;
	            }
	            if(s.charAt(i) == ')') {
	                count--;
	            }
	            if(count == -1) {
	                return false;
	            }
	        }  
	        
	        return count == 0; 
	    }
	    
	    
}
