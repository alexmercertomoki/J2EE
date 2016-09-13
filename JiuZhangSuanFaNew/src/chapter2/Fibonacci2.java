package chapter2;

public class Fibonacci2 {
	 public  static int fibo(int n){
		 int a = 0;
		 int b = 1; 
		 
		 for(int i = 0; i < n; i ++){
			 int c = a + b;
			 a = b;
			 b = c; 
		 }
		 return a; 
	 }
	
}
