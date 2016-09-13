public class fibonacci {

	static int n = 1;

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		int sum = fibo(0, 1);
		System.out.println(sum);
	}

	public static int fibo(int i, int j) {

		if (n == 5) {
			return j;
		} else {
			i = i + j;
			j = i + j;
			n++;
			return fibo(i,j);
		}
		// if(n==5){
		// return j;
		// }
		// return fibo(i,j);

	}

}
