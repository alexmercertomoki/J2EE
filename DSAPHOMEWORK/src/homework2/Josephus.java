package homework2;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.soap.Node;

/**********************************************************
 *
 * 08-722 Data Structures for Application Programmers
 *
 * Homework Assignment 2 Solve Josephus problem
 * with different data structures and different algorithms
 * and compare running time
 *
 * Andrew ID:  bhuang	
 * Name:  Bilei Huang
 *
 **********************************************************/

public class Josephus{

	/**
	 * This method uses ArrayDeque data structure as Queue/Deque to find the
	 * survivor's position.
	 *
	 * @param size
	 *            Number of people in the circle that is bigger than 0.
	 * @param rotation
	 *            Elimination order in the circle. The value has to be greater
	 *            than 0.
	 * @return The position value of the survivor.
	 */
	
	 public int playWithAD(int size, int rotation) {
		// TODO implement this
		//When the size is less or equal to 0 or rotation is less or equal to 0  throw exception
		if(size<=0||rotation<=0){
		    // throw runtime exceptions 
			throw new RuntimeException("not right size or rotation ");
		}
		
		// initiate array dequeue 
		ArrayDeque<Integer> ad=new ArrayDeque<Integer>(size);
		// we need to put number of  k in the front to the  back k is rotation -1
		int k= rotation-1;
		// we put from 1 - size into ll 
		for(int p=0; p<size;p++){
			ad.add(p+1);
		}
		// each time we remove (kill) one so we remove size -1 times 
		for(int rottime=0;rottime<size-1;rottime++){	
			 // rotate k times 
			for(int i=0; i<k ;i++){
				// the element needed to be poped and add to last 
				int putin = ad.pop();
				// add the element to the last 
				ad.offerLast(putin);
			}
			// remove the next one after poping 
			ad.remove();
		}
		//  return the last element (survivor )
		return ad.pop();
		
	}

	/**
	 * This method uses LinkedList data structure as Queue/Deque to find the
	 * survivor's position.
	 *
	 * @param size
	 *            Number of people in the circle that is bigger than 0.
	 * @param rotation
	 *            Elimination order in the circle. The value has to be greater
	 *            than 0.
	 * @return The position value of the survivor.
	 */
	 
	public int playWithLL(int size, int rotation) {
		// TODO implement this
		//When the size is less or equal to 0 or rotation is less or equal to 0  throw exception
		if(size<=0||rotation<=0){
			// throw runtime exceptions 
			throw new RuntimeException("not right size or rotation ");
		}
		
		//initiate the linked list   
		LinkedList<Integer> ll=new LinkedList<Integer>();
		// we put from 1 - size into ll 
		for(int p=0; p<size;p++){
			// fron 1 to size (means person 1 to person last one )
			ll.add(p+1);
		}
		
		// we need to put number of  k in the front to the  back k is rotation -1     
		int k= rotation-1;
		// each time we remove (kill) one so we remove size -1 times 
		for(int rottime=0;rottime<size-1;rottime++){
			// rotate k times 
			for(int i=0; i < k;i++){
				//the element to put to the last
				int putin= ll.getFirst();
				// remove the first
				ll.removeFirst();
				//  add to the last which manipulate the rotation   
				ll.add(putin);

			}
			//   remove the first one (kill the person)
			ll.removeFirst();
			
		}
		// the last survivor 
		return ll.pop();
	}

	/**
	 * This method uses LinkedList data structure to find the survivor's position.
	 * However, this does not use the LinkedList as Queue/Deque.
	 * Instead, this method uses LinkedList as "Linked List."
	 *
	 * That means, it uses index value to find and remove a person to be executed in the
	 * circle.
	 *
	 * @param size
	 *            Number of people in the circle that is bigger than 0.
	 * @param rotation
	 *            Elimination order in the circle. The value has to be greater
	 *            than 0.
	 * @return The position value of the survivor.
	 */
	
	public int playWithLLAt(int size, int rotation) {
		// TODO implement this
		//When the size is less or equal to 0 or rotation is less or equal to 0  throw exception 
		if(size<=0||rotation<=0){
			throw new RuntimeException("not right size or rotation ");
		}
		// the list initiated
		LinkedList<Integer> ll=new LinkedList<Integer>();
		// adding  1 to the last person  to the list
		for(int p=0; p<size;p++){
			ll.add(p+1);
		}
		// the index that needs to be removed
		int reindex=0;
		// size - 1 times then there is one left
		for(int rottime=0;rottime<size-1;rottime++){	
			
			// the index that needs to be  removed is : the index + (rotation-1)times because 
			// it will be larger than the size of the list we mod the current length of the list
		    reindex = (reindex+(rotation-1))%ll.size();
			//remove the person 
		    ll.remove(reindex);
			
		}
		//return the last one remained
		return ll.getFirst();
		
	}

}