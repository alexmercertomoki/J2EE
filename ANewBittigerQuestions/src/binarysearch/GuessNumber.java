package binarysearch;

public class GuessNumber {
	public int guess(int num) {
		int actualNum = 6;
		
		if(num > actualNum) {
			return 1;
		} else if(num < actualNum){
			return -1;
		} else {
			return 0;
		}
		
	}
	
	public int guessNumber(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("Not valid!");
        }
        int start = 1; 
        int end = n;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if(guess(mid) == 0) {
                return mid;
            }else if(guess(mid) == -1) {
                start = mid;
            } else{
                end = mid;
            }
        }
        
       if(guess(start) == 0) {
            return start;
       } else{
    	   return end;
       }

       
    }

}
