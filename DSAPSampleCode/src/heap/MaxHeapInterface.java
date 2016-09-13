package heap;
/**********************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Lecture 18 Heaps and Heap Sort
 *
 * A very simple MaxHeap Interface (insert and removeMax)
 *
 * You can add bells and whistles on your own
 *
 **********************************************************/

public interface MaxHeapInterface {
	/**
	 * Insert a new key into a heap
	 *
	 * @param key
	 *            key to be inserted
	 * @return boolean to check whether it is successfully inserted or not
	 */
	boolean insert(double key);

	/**
	 * remove the highest priority key value (maximum key for max heap)
	 *
	 * @return removed key value
	 * @throws NoSuchElementExcpetion when there is nothing to remove
	 */
	double removeMax();
}