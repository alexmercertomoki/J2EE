package strings;

import java.util.HashMap;

public class LongestSubStringWithoutRepeating {
	
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int len = s.length();
        int left = 0, right = 0, result = 0;
        for(; right < len; right++){
            if(hm.containsKey(s.charAt(right))){
                left = Math.max(left, hm.get(s.charAt(right)) + 1);
            }
            hm.put(s.charAt(right), right);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

}
