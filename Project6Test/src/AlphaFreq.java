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

public class AlphaFreq implements Comparator<Word> {

	@Override
	public int compare(Word o1, Word o2) {
		
		char first1=o1.getWord().charAt(0);
		char first2=o2.getWord().charAt(0);
		
		if(first1-first2==0){
			return o2.getFrequency()-o1.getFrequency();
		}else{
			return (first1-first2);
		}
	}

}