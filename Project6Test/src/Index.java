/*****************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Homework 6: Building Index using BST
 *
 * Andrew ID:
 * Name:
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
		// throw new RuntimeException("Implement this!");

		BST<Word> bst = this.buildAddHelper(fileName, null,false);
		return bst;

	}

	public BST<Word> buildAddHelper(String fileName, Comparator<Word> comp,boolean lowerCase)
			throws FileNotFoundException {
		
		BST<Word> bst;
		if (comp == null) {
			 bst = new BST<Word>();
		} else {
			 bst = new BST<Word>(comp);
		}
		
		
		Scanner sc = new Scanner(new File(fileName));
		int line = 0;
		HashMap<String, Word> hm = new HashMap<String, Word>();
		ArrayList<String> list  =new ArrayList<String>();
		while (sc.hasNextLine()) {

			String[] wordArr = sc.nextLine().split("\\W");
			
			line++;
			
			for (int i = 0; i < wordArr.length; i++) {
				
				
				if (notNullandIsaWord(wordArr[i])) {
					String strword;
					if(lowerCase){
						strword=wordArr[i].toLowerCase();
					}
					else{
						strword = wordArr[i];
					}
					if (!hm.containsKey(strword)) {
						list.add(strword);
						Set<Integer> hs = new HashSet<Integer>();
						hs.add(line);
						Word w = new Word(strword, hs, 1);
						hm.put(strword, w);
						
					} else {
						Word w = hm.get(strword);
						w.addIndex(line);
						w.addFreq();
						hm.put(strword, w);
					}
				}
			}

			for(int i =0 ; i<list.size();i++){
				bst.insert(hm.get(list.get(i)));
			}

		}
		
		return bst;
		
	}

	static boolean notNullandIsaWord(String word) {

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
		
		BST<Word> bst;
		
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
		
		BST<Word> bst;
		if (comparator == null) {
			 bst = new BST<Word>();
		} else {
			 bst = new BST<Word>(comparator);
		}
		for(int i =0; i<list.size();i++){
			bst.insert(list.get(i));
		}
		
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
		if(tree == null){
			return null;
		}
//		throw new RuntimeException("Implement this!");
		ArrayList<Word> list =new ArrayList<Word>();
		Iterator<Word> itr = tree.iterator();
		while(itr.hasNext()){
			list.add(itr.next());
		}
		
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
		if(tree == null){
			return null;
		}
		ArrayList<Word> list =new ArrayList<Word>();
		Iterator<Word> itr = tree.iterator();
		
		while(itr.hasNext()){
			list.add(itr.next());
		}
		Frequency freq=new Frequency();
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
		if(tree == null){
			return null;
		}
		ArrayList<Word> list =new ArrayList<Word>();
		ArrayList<Word> hfl =new ArrayList<Word>();
		Iterator<Word> itr = tree.iterator();
		
		while(itr.hasNext()){
			list.add(itr.next());
		}
		Frequency freq=new Frequency();
		Collections.sort(list,freq);
		
		Iterator<Word> itrlist = list.iterator(); 
		Word topWord= list.get(0);
		while(itrlist.hasNext()){
			Word w= (Word) itrlist.next();
			if(topWord.getFrequency()==w.getFrequency()){
				hfl.add(w);
			}
		}
		
		return hfl;
		
	}

}