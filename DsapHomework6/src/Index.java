/*****************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Homework 6: Building Index using BST
 *
 * Andrew ID:bhuang
 * Name:Bilei Huang
 *
 *****************************************************/

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Index {

	/**
	 * Build a tree giving a file name
	 *
	 * @param fileName
	 *            - input file name
	 * @return BST object
	 * @throws FileNotFoundException
	 */
	public BST<Word> buildIndex(String fileName) throws FileNotFoundException {
		// the get the bst using build helper 
		BST<Word> bst = this.buildAddHelper(fileName, null,false);
		// return the tree
		return bst;
	}
	/**
	 *
	 * @param fileName
	 *            - input file name
	 * @param comp comparator  
	 * @param boolean lowercase or not 
	 *
	 * @throws FileNotFoundException
	 */
	
	public BST<Word> buildAddHelper(String fileName, Comparator<Word> comp,boolean lowerCase)
			throws FileNotFoundException {
		// build a bst
		BST<Word> bst;
		// using comparator or not to initialize 
		if (comp == null) {
			 bst = new BST<Word>();
		} else {
			 bst = new BST<Word>(comp);
		}
		
		//scan the file 
		Scanner sc = new Scanner(new File(fileName));
		// line is 0 
		int line = 0;
		// map and list to help insert
		HashMap<String, Word> hm = new HashMap<String, Word>();
		ArrayList<String> list  =new ArrayList<String>();
		// read line by line 
		while (sc.hasNextLine()) {
			// split words
			String[] wordArr = sc.nextLine().split("\\W");
			// line +1 
			line++;
			//  get word by word
			for (int i = 0; i < wordArr.length; i++) {
				
				// if a word 
				if (notNullandIsaWord(wordArr[i])) {
					String strword;
					// if lower case is true convert
					if(lowerCase){
						strword=wordArr[i].toLowerCase();
					}
					else{
						strword = wordArr[i];
					}
					// hashmap contain the word
					if (!hm.containsKey(strword)) {
						list.add(strword);
						Set<Integer> hs = new HashSet<Integer>();
						hs.add(line);
						Word w = new Word(strword, hs, 1);
						hm.put(strword, w);
						
					} else {
						// add the attributes of words
						Word w = hm.get(strword);
						w.addIndex(line);
						w.addFreq();
						hm.put(strword, w);
					}
				}
			}
			//iterate in order to insert 
			for(int i =0 ; i<list.size();i++){
				bst.insert(hm.get(list.get(i)));
			}

		}
		//return the tree
		return bst;
		
	}

	/**
	 * Build a tree with a file name and comparator object
	 *
	 * @param Sting word  to be judged 
	 *
	 * @return boolean is a word or not 
	 */
	static boolean notNullandIsaWord(String word) {
		// null length ==0 or not match we return false
		if (word != null && word.length() != 0 && word.matches("[A-Za-z]+")) {
			return true;
		} else
			return false;

	}

	/**
	 * Build a tree with a file name and comparator object
	 *
	 * @param fileName
	 *            - input file name
	 * @param comparator
	 *            - comparator to be used
	 * @return BST object
	 * @throws FileNotFoundException 
	 */
	
	public BST<Word> buildIndex(String fileName, Comparator<Word> comparator) throws FileNotFoundException {
		// build a bst 
		BST<Word> bst;
		// if comparator is ignore case  set the last param true
		if (comparator instanceof IgnoreCase) {
			 bst= buildAddHelper(fileName, comparator, true);
		}else{
			 bst= buildAddHelper(fileName, comparator, false);
		}
		
		return bst;

	}

	/**
	 * Build a tree with a given list and comparator
	 *
	 * @param list
	 *            - ArrayList of words
	 * @param comparator
	 *            - comparator to be used
	 * @return BST object
	 */

	public BST<Word> buildIndex(ArrayList<Word> list,
			Comparator<Word> comparator) {
		// build up tree 
		BST<Word> bst;
		// if the comparator is null  or not 
		if (comparator == null) {
			 bst = new BST<Word>();
		} else {
			 bst = new BST<Word>(comparator);
		}
		//after build using a list
		for(int i =0; i<list.size();i++){
			bst.insert(list.get(i));
		}
		//return the tree
		return bst;
		
	}

	/**
	 * Sort words alphabetically Note: Should keep the state of the tree
	 *
	 * @param tree
	 *            - BST tree
	 * @return ArrayList of words sorted alphabetically
	 */
	public ArrayList<Word> sortByAlpha(BST<Word> tree) {
		// if tree is null rerturn null
		if(tree == null){
			return null;
		}
		// iterate list 
		ArrayList<Word> list =new ArrayList<Word>();
		Iterator<Word> itr = tree.iterator();
		// while it has next(), add in 
		while(itr.hasNext()){
			list.add(itr.next());
		}
		// build a comparator and sort
		AlphaFreq alp= new AlphaFreq();
		Collections.sort(list,alp);
		return list;
		
	}

	/**
	 * Sort words by frequency Note: Should keep the state of the tree
	 *
	 * @param tree
	 *            - BST tree
	 * @return ArrayList of words sorted by frequency
	 */

	public ArrayList<Word> sortByFrequency(BST<Word> tree) {
		// if the tree is null return null
		if(tree == null){
			return null;
		}
		// list and tree iterator
		ArrayList<Word> list =new ArrayList<Word>();
		Iterator<Word> itr = tree.iterator();
		// the tree has the next  add next in the list
		while(itr.hasNext()){
			list.add(itr.next());
		}
		Frequency freq=new Frequency();
		// sort the list 
		Collections.sort(list,freq);
		return list;
		
	}

	/**
	 * Find all words of the highest frequency Note: Should keep the state of
	 * the tree
	 *
	 * @param tree
	 *            - BST tree
	 * @return ArrayList of words that have highest frequency
	 */
	public ArrayList<Word> getHighestFrequency(BST<Word> tree) {
		//if tree is null return null
		if(tree == null){
			return null;
		}
		// use hfl to sort
		ArrayList<Word> list =new ArrayList<Word>();
		ArrayList<Word> hfl =new ArrayList<Word>();
		Iterator<Word> itr = tree.iterator();
		// add the next 
		while(itr.hasNext()){
			list.add(itr.next());
		}
		//using frequency comparator to sort
		Frequency freq=new Frequency();
		Collections.sort(list,freq);
		// get the top one 
		Iterator<Word> itrlist = list.iterator(); 
		Word topWord= list.get(0);
		// add the highest ones to the hfl
		while(itrlist.hasNext()){
			Word w= (Word) itrlist.next();
			if(topWord.getFrequency()==w.getFrequency()){
				hfl.add(w);
			}
		}
		// return the top list
		return hfl;
		
	}

}