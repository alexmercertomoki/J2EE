package godaddyOA;

import java.math.BigDecimal;

public class Test {
	public static void main(String[] args) {
		
		// false   : precision problem !!! big decimal 
		System.out.println(0.10 + 0.20 == 0.3);
		BigDecimal bd = new BigDecimal("0.100");
		BigDecimal bd2 = new BigDecimal("0.20");
		System.out.println(bd.add(bd2));
	}
}
