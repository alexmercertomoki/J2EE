package google;

import java.util.Stack;

public class LongestSubStringMine {
		
		public int longFile(String s) {
			
			if(s == null || s.length() == 0) {
				return 0;
			}
			
			Stack<String> st = new Stack<>();
			String[] strArr = s.split("\n");
			String cur;
			int len = 0;
			int maxLen = 0;
			
			for(int i = 0; i < strArr.length;) {
				int j = 0;
				cur = strArr[i];
				int level = 0; 
				
				while(j < cur.length()) {
					if(cur.charAt(j) == ' ') {
						level++;
					} else {
						break;
					}
					j++;
				}
				
				String fileName = cur.substring(level);
				
				if(level == st.size()) {
					if(fileName.contains(".png")||fileName.contains(".jpeg")||fileName.contains(".gif")) {
						st.push(fileName);
						len += fileName.length() + 1;
						maxLen = Math.max(len, maxLen);
						if(len == maxLen) {
							for(String names : st) {
								System.out.print("\\" + names);
							}
							System.out.println();
						}
						
					}else {
						len += (fileName.length() + 1);
						st.push(fileName);
					}
					
					i++;
				} else {
					while(level < st.size()) {
						String tempName = st.pop();
						len -= (tempName.length() + 1);
					}
				}
				
			
			}
			
			return maxLen;
		}
	
}
