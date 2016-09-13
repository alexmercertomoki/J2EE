/*****************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Homework 6: Building Index using BST
 *
 * Andrew ID:bhuang
 * Name:Bilei Huang
 *
 *****************************************************/

	/**
	 * 
	 *  comparator using frequency of two words 
	 * 
	 * 
	 */
import java.util.*;

public class Frequency implements Comparator<Word> {
	/**
	 *  compare using frequency of two words 
	 * 
	 * @return int the frequency difference 
	 * 
	 */
	@Override
	public int compare(Word o1, Word o2) {
		// if one of them is null return -1 
		if(o1==null|| o2==null){ 
			return -1;
		}
		//return the difference in frequency 
		return o2.getFrequency()-o1.getFrequency();
		
	}

}