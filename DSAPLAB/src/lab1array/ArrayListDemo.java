package lab1array;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		int size = 100000;

		// running time of adding values to the end
		Stopwatch timer1 = new Stopwatch();
		for (int i = 0; i < size; i++)
			tmp.add(i);

		System.out.println("running time for adding " + size
				+ " items into arraylist : " + timer1.elapsedTime()
				+ " millisec");

		// running time of removal
		Stopwatch timer2 = new Stopwatch();
		for (int i = 0; i < size; i++) {
//			tmp.remove(0);
//			tmp.remove(tmp.size()/2);
			tmp.remove(tmp.size()-1);
		}

		System.out.println("running time for removing " + size
				+ " items from arraylist : " + timer2.elapsedTime()
				+ " millisec");
	}

}