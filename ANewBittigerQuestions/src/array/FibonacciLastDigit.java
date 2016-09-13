package array;

public class FibonacciLastDigit {
	
	public long FibonacciLastDigitMethod1(int n) {
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 1;
		}
		
		long prev = 1, next = 1;
		long after = 3;
		System.out.println(1);
		System.out.println(1);
		for(int i = 3; i <= n; i++) {
			after = prev + next;
			System.out.print(" " +after % 10);
			prev = next;
			next = after;
		}
		
		return after % 10;
	}
	
	

	public long FibonacciLastDigitMethod2(int n) {
		n = n % 60;
		
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 1;
		}
		
		long prev = 1, next = 1;
		long after = 3;
		System.out.println(1);
		System.out.println(1);
		for(int i = 3; i <= n; i++) {
			after = prev + next;
			System.out.print(" " +after % 10);
			prev = next;
			next = after;
		}
		
		return after % 10;
	}
	
	
}
