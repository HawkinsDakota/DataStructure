import java.util.Iterator;

/**
 * Interface for a binary search tree.
 * 
 * @author Greg Gagne
 *
 * @param <T>
 */
public interface SearchTreeInterface<T extends Comparable<? super T>> {
	/**
	 * Determines if the tree contains the specified item.
	 * 
	 * @param item
	 * @return
	 */
	public boolean contains(T item);
	
	/**
	 * Adds the item to the tree.
	 * 
	 * @param item
	 * @return T - the item added to the tree. Returns null if 
	 * item was not added to the tree.
	 */
	public T add(T item);
	
	/**
	 * Returns the number of elements in the tree
	 * @return int - the number of elements in the tree.
	 */
	public int size();
	
	/**
	 * Removes the specified item from the tree.
	 * 
	 * @param item
	 * @return T - the item that was moved. Returns null if item is
	 * not present in the tree.
	 */
	public T remove(T item);
	
	/**
	 * Returns an iterator containing an in order traversal of the tree.
	 * 
	 * @return Iterator
	 */
	public Iterator<T> iterator();
}
