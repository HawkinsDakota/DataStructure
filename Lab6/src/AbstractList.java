/**
 * An interface representing an abstract list with a front and rear of 
 * the list. Classes implementing these operations could be used to
 * support LIFO and FIFO structures such as stacks, queues, and deques.
 * 
 * @author Greg Gagne - February 2015.
 *
 */
public interface AbstractList<T> {
	/**
	 * Add item to the front of the list
	 * @param item
	 */
	public void addFront(T item);
	
	/**
	 * Add item to the rear of the list
	 * @param item
	 */
	public void addRear(T item);
	
	/**
	 * Remove the item at the front of the list.
	 * 
	 * @return T or null if list is empty
	 */
	public T removeFront();
	
	/**
	 * Remove the item at the rear of the list.
	 * 
	 * @return T or null if list is empty
	 */
	public T removeRear();
	
	/**
	 * Returns the length of the list.
	 * 
	 * @return
	 */
	public int getLength();
	
	/**
	 * Returns the number of occurrences of item in the list.
	 * @param item
	 * @return The number of occurrences of item in the list.
	 */
	public int getFrequency(T item);
	
	/**
	 * Determines if item is contained in the list.
	 * @param item
	 * @return Returns true if item is contained, false otherwise.
	 */
	public boolean contains(T item);
	
	/**
	 * Determines if the list is empty
	 * @return True if list is empty, false otherwise.
	 */
	public boolean isEmpty();
	
	/**
	 * Returns an iteration of elements in the list.
	 * @return java.util.Iterator
	 */
	public java.util.Iterator<T> iterator();
}
