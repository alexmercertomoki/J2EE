/*****************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Homework 6: Building Index using BST
 *
 * Andrew ID:
 * Name:
 *
 *****************************************************/

import java.util.*;

public class IgnoreCase implements Comparator<Word> {

	@Override
	public int compare(Word o1, Word o2) {
		
		return o2.compareTo(o1);
		
	}

}