package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildSequences {
	
//	  public ArrayList<String> buildSequences(String word) {
//	        // write your code here
//	         ArrayList<String> result = new ArrayList<>();
//	        if(word == null || word.length() == 0) {
//	            return result;
//	        }
//	      
//	        StringBuilder sb = new StringBuilder();
//	        helper(word, result, sb, 0);
//	        return result;
//	        
//	    }
//	    
//	    public void helper(String word, ArrayList<String> result, StringBuilder sb, int pos) {
//	        result.add(sb.toString());
//	        
//	        for(int i = pos; i < word.length(); i++) {
//	            sb.append(word.charAt(i));
//	            helper(word, result, sb, i + 1);
//	            sb.deleteCharAt(sb.length() - 1);
//	        }
//	        
//	    }
	
	
	
	
//	 static public String[] buildSequences(String word) {
//	        // write your code here
//	        ArrayList<String> result = new ArrayList<>();
//	        if(word == null || word.length() == 0) {
//	            return result.toArray((new String[0]));
//	        }
//	        
//	        char[] temp  = word.toCharArray(); 
//	        Arrays.sort(temp);
//	        		
//	        StringBuilder sb = new StringBuilder();
//	        helper(temp, result, sb, 0);
//
//	        return result.toArray(new String[0]);
//	        
//	    }
//	    
//	    static public void helper(char[] tempWord, ArrayList<String> result, StringBuilder sb) {
//	        if(sb.length() != 0) {
//	    		result.add(sb.toString());
//	        }
//	        
//	        for(int i = 0; i < tempWord.length; i++) {
//	            sb.append(tempWord[i]);
//	            helper(tempWord, result, sb);
//	            sb.deleteCharAt(sb.length() - 1);
//	        }
//	        
//	    }
	    
//	 public List<String> permute(String word) {
//	        List<String> res = new ArrayList<>();
//	        
//	        if(word == null || word.length() == 0) {
//	            return res;
//	        }      
//	        
//	        
//	        char[] temp  = word.toCharArray(); 
//	        Arrays.sort(temp);
//	        
//	        List<String> list = new ArrayList<>();
//	        dfs(temp, res, list);
//	        return res;        
//	        
//	    }
//	    
//	    
//	    public void dfs(char word, List<Integer> list,StringBuilder sb) {
//	        if(sb.size() == word.length) {
//	            res.add(sb.toString());
//	            return;
//	        }
//	        
//	        for(int i = 0; i < word.length; i++) {
//	            if(sb.contains(word[i])) {
//	                continue;
//	            }
//	            list.add(word[i]);
//	            dfs(word, res, list);
//	            list.remove(list.size() - 1);
//	        }
//	    }
	
	
	    
//	    static public String[] buildSequences(String word) {
//	        // write your code here
//	        ArrayList<String> result = new ArrayList<>();
//	        if(word == null || word.length() == 0) {
//	            return result.toArray((new String[0]));
//	        }
//	        
//	        char[] temp  = word.toCharArray(); 
//	        Arrays.sort(temp);
//	        		
//	        StringBuilder sb = new StringBuilder();
//	        helper(temp, result, sb, 0);
//
//	        return result.toArray(new String[0]);
//	        
//	    }
//	    
//	    static public void helper(char[] tempWord, ArrayList<String> result, StringBuilder sb, int pos) {
//	        if(sb.length() != 0) {
//	    		result.add(sb.toString());
//	        }
//	        for(int i = pos; i < tempWord.length; i++) {
//	            sb.append(tempWord[i]);
//	            helper(tempWord, result, sb, i + 1);
//	            sb.deleteCharAt(sb.length() - 1);
//	        }
//	        
//	    }
	    
	    

}
