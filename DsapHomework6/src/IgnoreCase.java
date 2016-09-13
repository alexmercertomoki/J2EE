/*****************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Homework 6: Building Index using BST
 *
 * Andrew ID:bhuang
 * Name:Bilei Huang
 *
 *****************************************************/
import java.util.*;

/**
 *  compare using alpha but ignore the cases 
 * 
 * 
 */

public class IgnoreCase implements Comparator<Word> {
	/**
	 *  compare using alpha  of two words 
	 * 
	 * @return int the frequency difference 
	 * 
	 */
	@Override
	public int compare(Word o1, Word o2) {
		// if null  return -1 
		if(o1==null|| o2==null){ 
			return -1;
		}
		// return  the  difference 
		return o1.compareTo(o2);
		
	}
	
}