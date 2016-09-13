package TreeSet;

/********************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Lecture 17 TreeMap and TreeSet in Java
 *
 * Example usages of TreeMap and TreeSet
 *
 ********************************************************/

import java.util.*;

public class MainDriver {

	public static void main(String[] args) {
		HashMap<String, Integer> freqOfWords = new HashMap<String, Integer>();
		String[] words = "coming together is a beginning keeping together is progress working together is success"
				.split(" ");

		for (String word : words) {
			Integer frequency = freqOfWords.get(word);
			if (frequency == null)
				frequency = 1;
			else
				frequency++;
			freqOfWords.put(word, frequency);
		}

		System.out.println(freqOfWords);

		// print freqOfWords in ascending order
		TreeMap<String, Integer> sortedWords = new TreeMap<String, Integer>(
				freqOfWords);
		System.out.println("Sorted with TreeMap: " + sortedWords);

		// print in descending order
		System.out.println("Sorted with TreeMap in descending order: "
				+ sortedWords.descendingMap());

		HashSet<String> distinctWords = new HashSet<String>();
		for (String word : words)
			distinctWords.add(word);

		System.out.println("There are " + distinctWords.size() + " words.");
		System.out.println("And, they are: " + distinctWords);

		// print distinctWords in ascending order
		TreeSet<String> sortedDistinctWords = new TreeSet<String>(distinctWords);
		System.out.println("Sorted with TreeSet: " + sortedDistinctWords);
	}

}