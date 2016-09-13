package array;

public class BackTrackingTheKth {
	    boolean flag = false;
	    int k = 0;
	    public String getPermutation(int n, int k) {
	        
	        if(n <= 0 || k <= 0) {
	            return "";
	        }  
	        this.k = k;
	       
	        StringBuilder sb = new StringBuilder();
	        dfs(n, sb);
	        return sb.toString(); 
	        
	        
	    }
	  
	    public void dfs(int n, StringBuilder sb) {
	        if(sb.length() == n) {
	            k--;
	            if(k == 0){
	            	flag = true;
	            }
	            return;
	        }
	        
	      
	        
	        for(int i = 1; i <= n; i++) {
	            if(charContainsInSb(sb, i)) {
	                continue;
	            }
	            sb.append(i);
	            dfs(n, sb);
	            if(flag) {
	                return;
	            }
	            sb.deleteCharAt(sb.length() - 1);
	        }
	    }
	    
	    private boolean charContainsInSb(StringBuilder sb, int i) {
	        for(int j = 0; j < sb.length(); j++) {
	            if(sb.charAt(j) == ((char)(i + 48))) {
	                return true;
	            }
	        }
	        return false;
	    }
	    
}