import java.util.Hashtable;


public class TEST {

	public static void main(String[] args) {
//		String[] dic = {""};
//		UniqueAbbr ua = new UniqueAbbr(dic);
//		boolean res = ua.isUnique("a");
//		System.out.println(res);
		
//		Hashtable<String, String> ht = new Hashtable<>();
//	
//		ht.put("1", "1");
//		System.out.println(ht);
		
		MovingAverage m = new MovingAverage(3);
		m.next(10);
		m.next(11);
		double res = m.next(3);
		System.out.println(res);
		
	}

}
