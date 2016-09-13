/*****************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Homework 6: Building Index using BST
 *
 * Andrew ID: bhuang
 * Name:Bilei Huang
 *
 *****************************************************/
import java.util.*;

/**
 * 
 * compare using  alpha and freqency 
 * 
 */
public class AlphaFreq implements Comparator<Word> {
	
	/**
	 *  compare using  alpha and freqency 
	 * 
	 * * @return int bigger or smaller >0 bigger ==0 equal <0 smaller
	 */
	@Override
	public int compare(Word o1, Word o2) {
		
		// if o1 or o2 ==null return -1 
		if(o1==null|| o2==null){ 
			return -1;
		}
		
		// the result got by  alpha comapare
		int rel =o1.compareTo(o2);
		
		// if result is not 0 return rel
		if(rel!=0){
			return  rel;
		}else{
			// if result is not 0 return the o2 -o1 frequency 
			return  o2.getFrequency()-o1.getFrequency();
		}
		
	}

}