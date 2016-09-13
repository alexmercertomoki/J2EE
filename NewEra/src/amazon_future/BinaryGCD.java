package amazon_future;

public class BinaryGCD {
	
	public int gcd(int num1, int num2){
		if(num1 == 0) return num2;
		if(num2 == 0) return num1;
		// if all even 
		if((num1 & 1) == 0 && (num2 & 1) == 0){
			return gcd(num1 >> 1, num2 >> 1) << 1;
		} else if((num1 & 1) == 0){ // if num1 even
			return gcd(num1 >> 1, num2);
		} else if((num2 & 1) == 0){ // if num2 even
			return gcd(num1, num2 >> 1);
		} else if(num1 >= num2){ // if num1 >= num2 odd
			return gcd((num1 - num2) >> 1, num2); // %
		} else { // if num2 > num1  odd 
			return gcd(num1, (num2 - num1) >> 1);
		}
		
	}

}
