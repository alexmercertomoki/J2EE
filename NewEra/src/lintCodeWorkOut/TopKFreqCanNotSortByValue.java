package lintCodeWorkOut;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TopKFreqCanNotSortByValue {
	    /**
	     * @param words an array of string
	     * @param k an integer
	     * @return an array of string
	     */
	     
	   
	    private class MyComparator implements Comparator<Map.Entry<String, Integer>>{
	        @Override
	        public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
	            return m2.getValue() - m1.getValue();
	        }
	    }
	    
	    public String[] topKFrequentWords(String[] words, int k) {
	        // Write your code here
	        Comparator cmp = new MyComparator();
	        Map<String, Integer> map = new TreeMap<String, Integer>(cmp);
	        // Cannot use treeMap sorted by value
	        
	        for(String word : words) {
	            if(map.containsKey(word)) {
	                map.put(word, map.get(word) + 1);
	            } else {
	                map.put(word, 1);
	            }
	        }
	        
	        String[] strs = new String[k];
	        Iterator itr = map.entrySet().iterator();
	        
	        int index = 0;
	        while(index < k) {
	        	Map.Entry<String, Integer> pair = (Map.Entry)itr.next();
	        	strs[index++] = pair.getKey();
	        }
	        return strs;
	        
	    }
}
