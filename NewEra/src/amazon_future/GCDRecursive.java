package amazon_future;

public class GCDRecursive {
	public int getGCD(int[] array){
		//binary GCD algorithm can be considered  // try to find the mini number and count down from it，6 is divisible by 2  整除  
		if(array == null || array.length == 0) return 0;
		
		int gcd = array[0];
		for(int i = 1; i < array.length; i ++){
			gcd = twoNumGCD(gcd, array[i]);
		}
		return gcd;
			
	}
	
	private int twoNumGCD(int num1, int num2){
	
		if(num2 == 0) return num1;
		
//		if(num2 > num1){
//			num2 ^= num1;
//			num2 ^= num1;
//			num2 ^= num1;
//		}
		
		return twoNumGCD(num2, num1 % num2);
	}

}
