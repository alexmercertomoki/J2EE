package homeowork1;

/*
This file: MyArray.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 08-722
Assignment: arraylist implementation
Last Modified: 03/25/2015 
Known Bugs: unknown
Compiler: JDK 1.8
*/

public class MyArray {
	//this is where we store the strings, the array 
	private String[] stringArray;
	// this is the index for adding elements and also the size of the array 
	private int index=0;  //  mis 1 
	
	//this is the adding function　　O(1) 
	public void add(String s){
		// to judge whether we should add or not 
		 if(shouldAdd(s)){
			 // to ensure the minimum length is the index plus one  
			 int min= index+1;
			 //to make sure there is enough space 
			 makeSureCapacity(min);
			 // add the string into the array 
			 stringArray[index]=s;
			 index++; // mis2 
		 }
		 
	}
	
	// to see if we should add this string or not  O(n) match
	private static boolean shouldAdd(String s) {
		// if it is  null or length is  0 or it is not from a-z or A-Z we don't add it 
		if (s == null || s.length() == 0 || !s.matches("[A-Za-z]+"))
			return false;
		//  we should add it 
	    return true;
	}
	
	// the constructor of the array  O(1)
	public MyArray(int iniSize){ 
	
		stringArray=new String[iniSize];
	}
	
	// to make sure there is enough space at least minCapacity O(n)
	protected void makeSureCapacity(int minCapacity){
		//get the old capacity 
		int oldCapacity = stringArray.length;
		// if minCapacity is bigger than old one  we need to double 
		if(minCapacity > oldCapacity){
			//copy the old data
			String oldData[]=stringArray;
			// if new Capacity  is equal to old and it is 0 we need to make it one 
			// or we directly double it 
			int newCapacity = oldCapacity == 0 ? 1 : oldCapacity*2; 			
			//if new Capacity is still smaller we make the newCapacity minCapacity we need 
			if(newCapacity< minCapacity){
				newCapacity = minCapacity;
			}
			// enlarge the  old string array 
			stringArray=new String[newCapacity];
			//  copy the data in the for loop 
			for(int i=0; i<oldData.length;i++){
				stringArray[i]=oldData[i];
			}
			
		}
		
	}
	// to search for the word O(n)
	public boolean search(String word){
		// for loop traversal 
		for (String sWord : stringArray){
			// if the word is null means it is the the end of the list because capacity > size
			if(sWord==null){
				break;  // mis4
			}
			//if during the process we found the word we can return true .
			if(sWord.equals(word)){
				return true;
			}
		}
		// we don't find it we return false 
		return false;
		
	}
	// size is the index where we last add the word O(1)
	public int size(){
		return index;
	}
	
	
	//capacity is the length of the array
	public int getCapacity(){
		return stringArray.length;
	}
	
	// print out all info
	public void display(){
		// traversal  the print the info
		for (int i=0; i<this.index;i++){
			System.out.print(stringArray[i]+" "); // mis 7 
		}
		// to print \n
		System.out.println();
	}
	
	// remove duplicates 
	public void removeDups(){
		
		// initiate locate variable indexRe for removing dups equal 1
		int indexRe = 1;
		// traversal until the size of the array
		for (int i = 1; i < this.index; i++) {
			// set a flag  false 
			boolean exist = false;
			// compare each  String  from the beginning till the the part that has been removed dups
			for (int j = 0; j < indexRe; j++) {
				// if the string matches the part has been removed dups  mean exists 
				if (stringArray[i].equals(stringArray[j])) {
					// if it exists we don't need to add
					exist = true;
					break;
				}
			}
			// if it doesn't exist we add this String at the end of the part that has been removed dups
			if (!exist) {
				stringArray[indexRe++] = stringArray[i];
			}
		}
		// reset the size to indexRe which is the size after removing dups
		this.index = indexRe;
	}
		
		

	
}
