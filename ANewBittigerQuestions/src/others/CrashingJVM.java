package others;
//to really crash the JVM JVM
public class CrashingJVM {
	public void crash1(){
		Object o = new Object();
		while(true) {
			o = new Object();
		}
	}
	
	public void crash2() {
		Object[] o = null;
		
		while(true) {
			
			o = new Object[]{o};
			
		}
	}
}
