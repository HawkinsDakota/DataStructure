/** 
 * List.java
 *
 * An interface representing a List ADT
 *
 * @author Greg GAgne - January 2015.
 */

public interface List<T>
{
	/**
	 * Adds item to List
	 * 
	 * @param item
	 */
    public void add(T item);

    /**
     * Removes item from List
     * 
     * @param item
     */
    public void remove (T item);

    /**
     * Determines the number of items in the List
     * 
     * @return int - The length of the list
     */
    public int getLength();

    /**
     * Determines in item is contained in the List.
     * 
     * @param item - The item being searched for.
     * 
     * @return True if items is contained in the List, False otherwise
     */
    public boolean contains(T item);

    /**
     * Determines if the List is empty.
     * 
     * @return True if the List is empty, False otherwise.
     */
    public boolean isEmpty();

    /**
     * Determines the frequency of item appearing in the List
     * 
     * @param item - The item being searched for.
     * 
     * @return int representing the frequency that items occurs in the List
     */
    public int getFrequency(T item);
    
    /**
     * Returns the items in the List as an array of Ts.
     * 
     * @return T[] - The items in the List.
     */
    public T[] toArray();
}
