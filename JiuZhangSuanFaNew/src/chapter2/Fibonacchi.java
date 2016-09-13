package chapter2;

public class Fibonacchi {
	 private static int fibo(int n){
		 if(n <= 1) return n;
		 return fibo(n - 1) + fibo(n - 2);
		 
	 }
	 
	 public static void Fibonacci(int n){
		 for(int i = 1; i <= n; i ++) {
			 System.out.println(i + " is " + fibo(i));
		 }
		 
	 }
	
}
