package strings;

import java.util.Stack;

public class SimplifyPath {
	    public String simplifyPath(String path) {
	        Stack<String> stack = new Stack<>();
	        
	        int len = path.length(); 
	        int start = 0;
	        int i = 0;
	        
	        while(i < len) {
	            while(i < len && path.charAt(i) == '/') {
	               i++;
	            }
	            
	            start = i; 
	            
	            while(i < len && path.charAt(i) != '/') {
	                i++;
	            }
	            if(start < i) { //否则最后一个 / 就会截出来""
	                String tmp = path.substring(start, i);
	                
	                if(tmp.equals("..")) {
	                    if(!stack.isEmpty()) { //!!!!!!!你也考虑到了吧！ /..
	                        stack.pop();
	                    }
	                } else if(!tmp.equals(".")) {
	                    stack.push(tmp);
	                }
	            }
	        }
	    
	     
	        if(stack.isEmpty()) {
	            return "/";
	        }
	     //   StringBuilder sb = new StringBuilder();
	        String res = "";
	        while(!stack.isEmpty()) {
	           // sb.append(stack.pop(), sb);
	           res = "/" + stack.pop() + res; 
	        }
	       // return sb.toString();
	        return res; 
	    }
}
