package google;

import java.util.TreeMap;

public class DuplicateLarge {
	
	public int dupNumber(int number) {
		
		String strNum = Integer.toString(number);
		StringBuilder strNumBuilder;
		TreeMap<Integer, Integer>  sortMap = new TreeMap<Integer, Integer>();
		
		int dup = 0;
		while(dup < strNum.length()) {
			strNumBuilder = new StringBuilder();
			for(int i = 0; i < strNum.length(); i++) {
				if(dup == i) {
					strNumBuilder.append(strNum.charAt(i));
				}
				strNumBuilder.append(strNum.charAt(i));
			}
			sortMap.put(dup, Integer.parseInt(strNumBuilder.toString()));
			dup++;
		}
		
		int first = sortMap.firstKey();
		
		return first;
	}

}
