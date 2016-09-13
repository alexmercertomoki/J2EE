package trytry;

public class IntTry {
	 public static int reverse(int x) {
	      
	        boolean flag = false;   // initiate first     integer .max  first 9 and then the 10 th 
	        if(x < 0)
	            flag = true;
	        
	        if(x == Integer.MIN_VALUE){ // MIN_VALUE == -2147483648
	        	return 0;
	        }
	        String ss = String.valueOf(Math.abs(x)); 
	        
	        char[] s = ss.toCharArray(); // String  toCharArray()
	        
	        int i = 0, j = ss.length() - 1; 
	        for(; i < j; i++, j--) {
	            char c = s[i];   // [] not () be careful 
	            s[i] = s[j];
	            s[j] = c;
	            
	        }
	        System.out.println("$$");
	        Long xx = Long.parseLong(new String(s));   // prevent  overflow
	        System.out.println(xx);
	        
	        if (xx >Integer.MAX_VALUE || xx<Integer.MIN_VALUE){
	            return 0; 
	        }
	        
	        x = Integer.parseInt(String.valueOf(xx));   //long can't be converted to int
	        if(flag) 
	            x = 0 - x;
	            
	        return x; 
	           
	    }
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);//-2147483648 is the min 
		// TODO Auto-generated method stub
//		System.out.println(reverse(-2147483648));
		System.out.println(reverse(-2147483647));
		
	}

}
