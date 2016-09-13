package google;

import java.util.Stack;

public class LongestPath {
	public int longestPath(String S) {
	    // write your code in Java
	    int n = S.length();
	    if(n==0) return 0;

	    String[] strs = S.split("\n");

	    Stack<String> stack = new Stack<>();
	
	    int len=0;
	    int maxlen=0;
	    for(int i=0;i<strs.length;){
	        String cur = strs[i];

	        int spaceNum = 0;
	        for(int j=0;j<cur.length();j++){
	            if(cur.charAt(j)==' '){
	                spaceNum++;
	            }else{
	                break;
	            }
	        }
	        String filename = cur.substring(spaceNum);
	        if(spaceNum == stack.size()){
	            if(cur.contains(".jpeg")||cur.contains(".png")||cur.contains(".gif")) {
	                stack.push(filename);
	                len+=filename.length()+1;
	                maxlen = Math.max(maxlen,len);
	                if(len==maxlen){
	                    for(String ss: stack){
	                        System.out.print("\\"+ss);
	                    }
	                    System.out.println();
	                }

	            }else{
	                len+=filename.length()+1;
	                stack.push(filename);
	            }
	            i++;
	        }else if(spaceNum<stack.size()){
	            while(spaceNum<stack.size()){ 
	                String tempname = stack.pop();
	                len-=(tempname.length()+1);
	            }
	        }
	    }
	    return maxlen;
	}
}
