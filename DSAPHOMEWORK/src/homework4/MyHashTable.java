package homework4;

/***********************************************************
 *
 * 08-722 Data Structures for Application Programmers Homework 4 HashTable
 * Implementation with linear probing
 *
 * Andrew ID: bhuang Name: Bilei Huang
 *
 ***********************************************************/

public class MyHashTable implements MyHTInterface {
	// data in the table which is an array
	private DataItem[] datastrarr;
	// set Deleted to -1 which prints out as #DEL#
	private static String DELETED = "-1";
	// length of the array
	private int length;
	// number of items
	private int itemNumber = 0;
	// collision in the table
	private int collision = 0;

	// when no size pass in : default capacity is 10
	public MyHashTable() {
		//initialize the array
		this.length = 10;
		datastrarr = new DataItem[length];

	}
	// when a len is passed in set the length to the number
	public MyHashTable(int len) {
		// if len is less than 0 we set it to defaulth
		if (len <= 0) {
			this.length = 10;
		}
		// else we set the length to length
		else {
			this.length = len;
		}
		//initialize the array
		datastrarr = new DataItem[length];

	}
	//calculating the loadfactor 
	public double LoadFactor() {
		//it is the items divided by length of the table
		return (double) itemNumber / length;

	}

	/**
	 * Inserts a new String value (word). Frequency of each word be stored too.
	 *
	 * @param value
	 *            String value to be added.
	 */
	@Override
	public void insert(String value) {
		//collide as false
		boolean collide = false;
		// if the value matches the criteria we try to add
		if (value != null && value.length() != 0 && value.matches("[a-z]+")) {
			//let the item number plus 1 
			itemNumber++;
			// calculate the load factor then if biger than 0.5 we rehash
			if (this.LoadFactor() > 0.5) {
				this.rehash();
			}
			// get the hashval of the value
			int index = hashFunc(value);
			// if the datastrarr is not null or Deleted we try to find the right position to add
			while (datastrarr[index] != null
					&& !datastrarr[index].value.equals(DELETED)) {
				// if the value in the array is equal to value we plus 1 to the frequency
				if (datastrarr[index].value.equals(value)) {
					datastrarr[index].frequency++;
					// itemnumber doesn't need to be added so we minus 1 
					itemNumber--;
					// then we need not to do the follwing anymore we return
					return;
				}
				// if the value is not equal to the value in the  array we continue to find the position
				index = (index + 1) % length;
				// set collide flag to true because when we try to find the position we moved down there is collision
				collide = true;
			}
			// as we find out the position set the data item value with frequency 1
			DataItem di = new DataItem(value, 1);
			//add in the item
			datastrarr[index] = di;
			// if there is collision plus 1 to collision
			if (collide) {
				collision++;
			}

		}

	}

	/**
	 * Returns the size, number of items, of the table
	 *
	 * @return the number of items in the table.
	 */
	@Override
	public int size() {
		// get the size of the array which is the item number
		return this.itemNumber;

	}

	/**
	 * Displays the values of the table If an index is empty, it shows ** If
	 * previously existed item is deleted, then it should show #DEL#
	 */
	@Override
	public void display() {
		// iterate through the array  and print 
		for (int i = 0; i < length; i++) {
			// if the value is not null
			if (datastrarr[i] != null) {
				// if the value is equal to -1 which we define as deleted
				if (datastrarr[i].value.equals("-1")) {
					// print out #DEL#
					System.out.print("#DEL#");
				} else {
					// we print out the actual value in the array and brackets 
					System.out.print("[" + datastrarr[i].value + ", "
							+ datastrarr[i].frequency + "] ");
				}

			} else {
				// null value we print **
				System.out.print("** ");
			}
		}
		//after printing we start from the next line
		System.out.println();
	}

	/**
	 * Returns true if value is contained in the table
	 *
	 * @param key
	 *            String key value to be searched
	 * @return true if found, false if not found.
	 */
	@Override
	public boolean contains(String key) {
		// calculate the hashvalue first
		int hashV = hashFunc(key);
		// if no value is found in array
		while (datastrarr[hashV] != null) {
			// if the value is equal to key 
			if (datastrarr[hashV].value.equals(key)) {
				// when we find it we return true
				return true;
			}
			// hash value + 1  and mod table length 
			hashV++;
			hashV = hashV % length;
		}
		// when we can't find it
		return false;

	}

	/**
	 * Returns the number of collisions in relation to insert and rehash.
	 *
	 * When rehashing process happens, the number of collisions should be
	 * properly updated.
	 *
	 * The definition of collision is
	 * "two different keys map to the same hash value."
	 *
	 * Be careful with the situation where you could over count. Try to think as
	 * if you are using separate chaining!
	 * "How would you count the number of collisions in separate chaining?"
	 *
	 * @return number of collisions
	 */
	@Override
	public int numOfCollisions() {
		// the number of collision is tracked  so we just return it
		return collision;

	}

	/**
	 * Returns the hash value of a String
	 *
	 * @param value
	 *            value for which the hash value should be calculated
	 * @return int hash value of a String.
	 */
	@Override
	public int hashValue(String value) {
		// hash value is the generated by hash function 
		return hashFunc(value);

	}

	/**
	 * Returns the frequency of a key String
	 *
	 * @param key
	 *            key string value to find its frequency
	 * @return frequency value if found. If not found, return 0
	 */
	@Override
	public int showFrequency(String key) {
		//  if the key matches the input criteria we start searching or we don't do anything
		if (key != null && key.length() != 0 && key.matches("[a-z]+")) {
			//  get the hash value using hash function
			int index = hashFunc(key);
			// if the value in the array is no null and it's not deleted
			while (datastrarr[index] != null
					&& !datastrarr[index].value.equals(DELETED)) {
				//  we  find the value 
				if (datastrarr[index].value.equals(key)) {
					// return the frequency of the data array
					return datastrarr[index].frequency;

				}
				// index +1 and mod table length 
				index = (index + 1) % length;

			}

		}
		// when we can't find anything that matched we return  0  
		return 0;

	}

	/**
	 * Removes and returns removed value
	 *
	 * @param value
	 *            String value to be removed
	 * @return value that is removed
	 */
	@Override
	public String remove(String key) {
		//  set up a flag for minus collsion 
		boolean collideMinus = false;
		//if matches input criteria
		if (key != null && key.length() != 0 && key.matches("[a-z]+")) {
			// get hashed value
			int index = hashFunc(key);
			//if the value in the array is not null
			while (datastrarr[index] != null) {
				// search for the key
				if (datastrarr[index].value.equals(key)) {
					// if found frequency is bigger than 1 we minus 1 frequency
					if (datastrarr[index].frequency > 1) {
						datastrarr[index].frequency--;
						// return key value
						return key;
					} 
					// if frequency is 1 we remove the item 
					else if (datastrarr[index].frequency == 1) {
						// set it to deleted
						DataItem di = new DataItem(DELETED, 0);
						datastrarr[index] = di;
						// itemnumber minus 1 
						itemNumber--;
						//  if the flag is true collision minus 1 
						if (collideMinus == true) {
							collision--;
						}
						// return key value
						return key;

					}
				}
				// move down to search for the item
				index = (index + 1) % length;
				// if the value is not equal to deleted 
				if (!datastrarr[index].value.equals(DELETED)) {
					// set the flag to true
					collideMinus = true;
				}

			}

		}
		// return not found if not found
		return "not found";

	}

	/*
	 * Instead of using String's hashCode, you are to implement your own here,
	 * taking the table length into your account.
	 * 
	 * In other words, you are to combine the following two steps into one step
	 * here. 1. converting Object into integer value 2. compress into the table
	 * using modular hashing (division method)
	 * 
	 * Helper method to hash a string for English lowercase alphabet and blank,
	 * we have 27 total. But, you can assume that blank will not be added into
	 * your table. Refer to the instructions for the definition of words.
	 * 
	 * For example, "cats" : 3*27^3 + 1*27^2 + 20*27^1 + 19*27^0 = 60,337
	 * 
	 * But, to make the hash process faster, Horner's method should be applied
	 * as follows;
	 * 
	 * var4*n^4 + var3*n^3 + var2*n^2 + var1*n^1 + var0*n^0 can be rewritten as
	 * (((var4*n + var3)*n + var2)*n + var1)*n + var0
	 * 
	 * Note: You must use 27 for this homework.
	 * 
	 * However, if you have time, I would encourage you to try with other
	 * constant values other than 27 and compare the results but it is not
	 * required.
	 */
	private int hashFunc(String input) {
		// if input is OK
		if (input != null && input.length() != 0 && input.matches("[a-z]+")) {
			// using helper to get the hash value
			int HashVal = HashValueHelper(input);
			// mod the length to get hashvalue
			int hv = HashVal % length;
			//  return it
			return hv;
		}
		// return -1 when doesn't meet the criteria
		return -1;

	}
	
	/**
	 * Helper function for hash function
	 *
	 * @param value
	 *            String value to be calculated
	 * @return value that is hashed 
	 */
	private int HashValueHelper(String input) {
		// hash value
		int Hashv = 0;
		// iterate through the string 
		for (int i = 0; i < input.length(); i++) {
			// calculate the hash value  I noticed we can't use Math.pow() or it will over flow
			Hashv = (Hashv * 27 + (input.charAt(i) - 'a' + 1)) % length;

		}
		// return the value
		return Hashv;
	}

	// doubles array length and rehash items whenever the load factor is reached
	private void rehash() {
		// set collision to 0 , memorize the original length , new length is 2 multiplied the original one
		collision = 0;
		int orig = length;
		this.length = length * 2;
		// while it is not a prime , plus 1 
		while (!isPrime(length)) {
			length++;
		}
		// reashing size printed out
		System.out.println("Rehashing " + this.itemNumber
				+ " items, new size is " + length);
		//new array
		DataItem[] newData = new DataItem[length];
		// iterate through to get array
		for (int i = 0; i < orig; i++) {
			if (datastrarr[i] != null) {
				// similar to insert 
				this.reinsert(datastrarr[i].value, newData);

			}
		}
		//after insertion we let the new data be the data
		datastrarr = newData;

	}
	
	/**
	 * Helper function for rehashing calculating the prime
	 *
	 * @param n int  value to be calculated
	 * @return boolean if a prime return true else false
	 */
	static boolean isPrime(int num) {
		// to find whether it mod any factors until the number is 0 if yes then it's not a prime
		for (int i = 2; 2 * i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	
	/**
	 * Helper function for rehashing to reinsert
	 *
	 * @param value string  value to be inserted
	 * @param di DataItem   the array that need items to add in 
	 * 
	 */
	private void reinsert(String value, DataItem[] di) {
		//set collide to false
		boolean collide = false;
		// if the value is OK
		if (value != null && value.length() != 0 && value.matches("[a-z]+")) {
			//calculate hash function
			int index = hashFunc(value);
			// if the value in di is not null or not deleted
			while (di[index] != null && !di[index].value.equals(DELETED)) {
				// if found the value in the array 
				if (di[index].value.equals(value)) {
					// frequency +1 
					di[index].frequency++;
					return;
				}
				//continue to find where to insert
				index = (index + 1) % length;
				collide = true;
			}
			//insert 
			DataItem dataitem = new DataItem(value, 1);
			di[index] = dataitem;

		}
		//if collide collision + 1
		if (collide) {
			collision++;
		}

	}

	// private static data item nested class
	private static class DataItem {
		// data and frequency
		private String value;
		private int frequency = 0;
		//initialization of the  data item
		public DataItem(String val, int freq) {
			this.value = val;
			this.frequency += freq;
		}

	}

}