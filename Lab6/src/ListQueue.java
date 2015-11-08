/**
 * 
 * Implements a Queue using a LinkedList
 * 
 * @author Dakota Hawkins and Newman Knowlton
 *
 * @date February 25, 2015
 * @param <T>
 */

public class ListQueue<T> extends LinkedList<T> implements Queue<T> {
	
	//Constructor
	public ListQueue(){
		super();
	}

	@Override
	public void add(T item) {
		this.addRear(item);
	}

	@Override
	public T remove() {
		return this.removeFront();
	}

	@Override
	public int size() {
		return this.getLength();
	}
}
