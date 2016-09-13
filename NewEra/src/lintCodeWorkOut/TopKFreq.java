package lintCodeWorkOut;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFreq {
	    /**
	     * @param words an array of string
	     * @param k an integer
	     * @return an array of string
	     */
	     
	   

	   
    private class MyComparator implements Comparator<Map.Entry<String, Integer>>{
        @Override
        public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
            int diff =  m2.getValue() - m1.getValue();
            if(diff == 0) {
                return m1.getKey().compareTo(m2.getKey()); // compareTo in String
            } else {
                return diff;
            }
        }
    }
    
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        MyComparator cmp = new MyComparator();
        Map<String, Integer> map = new HashMap<>();
        Queue<Map.Entry<String, Integer>> q = new PriorityQueue<Map.Entry<String, Integer>>(words.length, cmp);
        
        for(String word : words) {
            if(map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){ // map's entrySet
            q.offer(entry);
        }
        
        String[] strs = new String[k];
        
        for(int i = 0; i < k; i++) {
            strs[i] = q.poll().getKey();
        }
        
        return strs;
    }
}
