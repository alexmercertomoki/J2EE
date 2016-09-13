package amazon_future;

public class GCD {
	public int getGCD(int[] array){
		//binary GCD algorithm can be considered  
		if(array == null || array.length == 0) return 0;
		
		int gcd = array[0];
		for(int i = 1; i < array.length; i ++){
			gcd = twoNumGCD(gcd, array[i]);
		}
		return gcd;
			
	}
	
	private int twoNumGCD(int num1, int num2){
		
		if(num1 == 0 || num2 == 0) return Math.abs(num1 + num2); // should be 
		while(num2 != 0){ // can we change to only num2 is 0? yes 
			if(Math.abs((double)num2) > Math.abs((double)num1)){ // prevent overflow for min value
				num2 ^= num1;
				num1 ^= num2;
				num2 ^= num1;
			}
			int temp = num1 % num2;
			num1 = num2;
			num2 = temp;
		}
		return Math.abs(num1);  //  return the positive number 
	}

}
