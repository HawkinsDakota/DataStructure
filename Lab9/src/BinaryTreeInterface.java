import java.util.Iterator;

/**
 * Interface for a binary tree
 * 
 * @author Greg Gagne
 *
 */
public interface BinaryTreeInterface<T> {
	
	/**
	 * Returns true if the tree is empty, false otherwise
	 * 
	 * @return boolean
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the data at the root of the tree.
	 * 
	 * @return T
	 */
	public T getRootData();
	
	/**
	 * Returns the height of the tree.
	 * 
	 * @return int
	 */
	public int getHeight();
	
	/**
	 * Returns the number of elements in the tree.
	 * 
	 * @return int
	 */
	public int getSize();
	
	/**
	 * Returns the data at the leftmost end of the tree.
	 * 
	 * @return T
	 */
	public T getLeftMostData();
	
	/**
	 * Removes and returns the leftmost data
	 * 
	 * @return T
	 */
	public T removeLeftMostData();
	
	/**
	 * Returns the data at the rightmost end of the tree.
	 * 
	 * @return T
	 */
	public T getRightMostData();
	
	/**
	 * Removes and returns the rightmost data
	 * 
	 * @return T
	 */
	public T removeRightMostData();
	
	/**
	 * Prints out the tree using arbitrary order.
	 */
	public void printTree();
	
	/**
	 * Returns an Iterator for a pre-order traversal.
	 * 
	 * @return Iterator
	 */
	public Iterator<T> getPreOrderIterator();
	
	/**
	 * Returns an Iterator for an in-order traversal.
	 * 
	 * @return Iterator
	 */
	public Iterator<T> getInOrderIterator();
	
	/**
	 * Returns an Iterator for a post-order traversal.
	 * 
	 * @return Iterator
	 */
	public Iterator<T> getPostOrderIterator();
}
