package array;

public class ValidParenthesesSimple {
	public boolean isValidP(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                count++;
            }
            if(s.charAt(i) == ')') {
                count--;
            }
            if(count == -1) {
                return false;
            }
        }  
        
        return count == 0; 
    }
}
