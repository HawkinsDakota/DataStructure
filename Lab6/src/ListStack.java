/**
 * 
 * Class that implements stack using a LinkedList
 * 
 * @author Dakota Hawkins and Newman Knowlton
 * @date February 25, 2015
 *
 * @param <T>
 */
public class ListStack<T> implements Stack<T> {
	private LinkedList<T> linkStack = new LinkedList<T>();

	@Override
	/**
	 * Method to push onto the stack
	 */
	public void push(T item) {
		this.linkStack.addFront(item);
		
	}

	@Override
	/**
	 * Method to remove from the stack
	 */
	public T pop() {
		return this.linkStack.removeFront();
	}

	@Override
	/**
	 * Method to look at the stack.
	 */
	public T peek() {
		return this.linkStack.getHead();
	}
	
	@Override
	/**
	 * Method to determine whether the stack 
	 * is empty.
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.linkStack.isEmpty();
	}

}
