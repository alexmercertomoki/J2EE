package array;

import java.util.ArrayList;
import java.util.Collections;

public class StringArrayReverseOrder {

	public String solution (String word) {
		ArrayList<Character> arr = new ArrayList<>();

		for(int i = 0; i < word.length();i++) {
			arr.add(word.charAt(i));
		}

		Collections.sort(arr);

		StringBuilder sb = new StringBuilder();

		for(int i = arr.size() - 1; i >= 0; i--) {
			sb.append(arr.get(i));
		}

		return sb.toString();
	}


}
