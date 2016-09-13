package homework2;

public class Test1 {
	/**
	 *	Please only call one of the three methods. 
	 *	In another word, comment the other two while
	 *  	testing one of them.
	 */
	static Josephus j = null;
	public static void main(String[] args) {
		j = new Josephus();
//		ADTest();
//		LLTest();
		LLATTest();
	}
	public static void ADTest() {
		System.err.println(j.playWithAD(1,5));		
		System.err.println(j.playWithAD(5,1));		
		System.err.println(j.playWithAD(5,2));		
		System.err.println(j.playWithAD(11,1));		
		System.err.println(j.playWithAD(40,7));
		System.err.println(j.playWithAD(55,1));		
		System.err.println(j.playWithAD(66,100));		
		System.err.println(j.playWithAD(1000,1000));
//		System.err.println(j.playWithAD(-1,2));	
//		System.err.println(j.playWithAD(5,0));		

	}
	
	public static void LLTest() {
		System.err.println(j.playWithLL(1,5));		
		System.err.println(j.playWithLL(5,1));		
		System.err.println(j.playWithLL(5,2));		
		System.err.println(j.playWithLL(11,1));		
		System.err.println(j.playWithLL(40,7));
		System.err.println(j.playWithLL(55,1));		
		System.err.println(j.playWithLL(66,100));		
		System.err.println(j.playWithLL(1000,1000));
//		System.err.println(j.playWithLL(-1,2));	
//		System.err.println(j.playWithLL(5,0));		

	}
	
	public static void LLATTest() {
		System.err.println(j.playWithLLAt(1,5));		
		System.err.println(j.playWithLLAt(5,1));		
		System.err.println(j.playWithLLAt(5,2));		
		System.err.println(j.playWithLLAt(11,1));		
		System.err.println(j.playWithLLAt(40,7));
		System.err.println(j.playWithLLAt(55,1));		
		System.err.println(j.playWithLLAt(66,100));		
		System.err.println(j.playWithLLAt(1000,1000));
		System.err.println(j.playWithLLAt(-1,2));	
		System.err.println(j.playWithLLAt(5,0));		

	}
}
