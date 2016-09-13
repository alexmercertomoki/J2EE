import java.util.ArrayList;
import java.util.Vector;


public class TestLaofei {

	public static void main(String[] args) {

//	 NamedVector
		String str=new String("1");
		
		ArrayList<String> arr=new ArrayList<String>();
//		arr.add(str);
//		arr=vec;
		arr.add(str);
		str=new String("2");
		
		arr.add(str);
		str=new String("3");
		arr.add(str);
		System.out.print(arr.toString());
		
	}

}
