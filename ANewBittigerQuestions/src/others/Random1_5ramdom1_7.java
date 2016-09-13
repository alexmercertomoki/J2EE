package others;

import java.util.Random;

public class Random1_5ramdom1_7 {
	
	 public int rand15() {
		 
		int i = (1 + (int)(Math.random() * 5));
		return i; 
		
	 }
	 
	 
	 public int rand17() {
		 int num = (rand15() - 1) * 5 + (rand15() - 1);
		 int temp = num / 3 + 1;
		 if(temp > 7){
			temp = rand17();
			return temp;
		 } else {
			 return temp;
		 }
	 }

}
