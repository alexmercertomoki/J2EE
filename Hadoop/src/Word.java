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

public class Word implements Comparable<Word> {

	private String word;
	private Set<Integer> index; // word's line number in the source text
	private int frequency; // counts occurrences of the word
	
	public Word(String word,Set<Integer> index,int frequency){
		this.word=word;
		this.index= index;
		this.frequency = frequency;
	}

	
	public String getWord() {
		return word;
	}


	public void setWord(String word) {
		this.word = word;
	}


	public Set<Integer> getIndex() {
		return index;
	}


	public void setIndex(Set<Integer> index) {
		this.index = index;
	}


	public int getFrequency() {
		return frequency;
	}


	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}


	@Override
	public int compareTo(Word o) {
		int result  =  this.word.compareTo(o.getWord());
		return result;
		
	}
	
	public void addFreq(){
		this.frequency++;
	}
	public void addIndex(int line){
		index.add(line);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return word + " " + frequency + " " + index.toString();
	}
}