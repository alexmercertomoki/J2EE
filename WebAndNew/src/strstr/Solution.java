package strstr;



public class Solution {
    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)){
        	return -1;
        }
        
        for(int i = 0; i < haystack.length(); i++) {

        	int flag=0;
        	
        	if(haystack.charAt(i)==needle.charAt(0)){
        		
        		for(int a=1;a<needle.length();a++){
        			if(haystack.charAt(a+i)!=needle.charAt(a)){
        				flag=1;
        				break;
        			}
        		}
        		
        		if(flag==1){
        			continue;
        		}else{
        			return i;
        		}
        	
        	}
        	
        }
        return -1;
        
    }
}
