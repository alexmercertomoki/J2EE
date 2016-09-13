package others;

import java.util.Scanner;

public class Adder extends Arithmetic{

	@Override
	public void add(int a, int b) {
		// TODO Auto-generated method stub
		if(a > 0 && b > 0 && Integer.MAX_VALUE - a < b){
			return;
		}
		if(a < 0 && b < 0 && Integer.MIN_VALUE - a > b){
			return;
		}
			int sum = a + b;
			System.out.println("Arithmetic");
			System.out.println(sum);
	}
	
	
//	@Override
//	public void add() {
//		Scanner sc = new Scanner(System.in);
//		String a = sc.next();
//		String b = sc.next();
//		
//		System.out.println(Integer.parseInt(a) + Integer.parseInt(b));
//	}

}
