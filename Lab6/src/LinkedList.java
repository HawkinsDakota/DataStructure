import java.util.Iterator;

/**
 * LinkedList.java
 * 
 * Implementation of List interface using a linked list.
 * 
 * @author Dakota Hawkins and Newman Knowlton
 * @date February 11, 2015
 *
 */

public class LinkedList<T> implements AbstractList<T>
{
	private Node head;
	private int length = 0;

	public LinkedList() {
		head = null;
	}

	/** 
	 * Inner class representing a node in the linked list
	 * Contains two instance variables: data and next.
	 * Data hold information for the node, while
	 * next show the next node in the linked list
	 */

	private class Node
	{
		private T data;
		private Node next;

		/**
		 * 1-parameter initiator for private class Node
		 * initiates the data but does not link to another
		 * node
		 */
		private Node(T data) {
			this(data,null);
		}
		/**
		 * Two-parameter initiator for private class Node
		 * Initiates both the data for the node and
		 * the next node in the LinkedList
		 */
		private Node (T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	// Methods

	/**
	 * Adds an item to the linked list
	 * This implementation adds to the tail of the list. 
	 * The method first checks to see whether the list is empty,
	 * if it is, the method appends the newNode by directly referencing
	 * it with the head.
	 * 
	 * If the list is not empty, it iterates until the end of the list
	 * and reassigns the last element to refer to the newNode. The newNode
	 * then references 'null' to signify it is the last node in the list.
	 */
	public void addRear(T item) {
		Node newNode = new Node(item);
		if (this.isEmpty()){
			newNode.next = head;
			head = newNode;
		} else {
			Node current = head;
			Node reference = null;
			while (current != null){
				reference = current;
				current = current.next;
			}
			reference.next = newNode;
			newNode.next = null;
		}
		length++;
	}
	public void addFront(T item) {
		Node newNode = new Node(item);
		newNode.next = head;
		head = newNode;
		length++;
	}
	/**
	 * Remove method for LinkedList class. Works by rewriting
	 * removed node to head, and removing head from the LinkedLIst
	 * 
	 * The method Iterates through the beginning on the 
	 * LinkedList to until it finds the 
	 * reference node. Once the node is found, the nodes data
	 * is switched to the head's data, and the head is set to 
	 * refer to the next node in the list.
	 */
	public void remove (T item) {
		// get a reference to the item we want to delete
		Node reference = null;
		// Used to be
		// Node reference = getReferenceTo(item);
		Node current = head;
		while ((current != null )&& (reference == null) ){
			if ((current.data).equals(item)){
				reference = current;
			}
			current = current.next;
		}

		if (reference != null) {
			/**
			 * set the data of the node we want
			 * to delete to the data currently
			 * at the head.
			 */
			reference.data = head.data;

			/**
			 * now remove the head
			 */
			head = head.next;
		}
		length--;
	}


	/**
	 * getLength method returns the length of the LinkedList
	 * iterates through until it finds the
	 * 'null' value for node data, signifying the end of the list.
	 * Increments length until the end of the list.
	 */
	public int getLength() {
		return length;
	}

	/**
	 * contains method determines whether an T
	 * is part of the LinkedList. Works by iterating through
	 * the beginning of the LinkedList, and determines whether
	 * the current value is equal to reference value. Returns true 
	 * if the reference T is found before the LinkedList ends.
	 */
	public boolean contains(T item) {
		Node current = head;

		boolean check = false;
		while(check == false && current != null)
		{
			if((current.data).equals(item)){
				check = true;
				return check;
			}
			current = current.next;
		}
		return check;
	}
	/**
	 * Determines whether the LinkedList contains any data by
	 * seeing if the head points to any data.
	 */
	public boolean isEmpty() {
//		if (head == null){
//			return true;
//		}
//		return false;
		return length == 0;
	}
	/**
	 * Returns the first data entry in a linkedlist. 
	 * @return the data entry of the head
	 */
	
	public T getHead(){
		if(head!=null)
			return head.data;
		return null;
	}

	/**
	 * Determines the number of times an T appears in the
	 * LinkedList. Iterates through LinkedList and counts number of
	 * times the reference T is equal to the iterated values.
	 */
	public int getFrequency(T item) {
		int sum = 0;
		Node current = head;
		while(current != null){
			if ((current.data).equals(item)){
				++sum;
			}
			current = current.next;

		}
		return sum;
	}

	/**
	 * Returns an array representation of items in the linked list
	 */
	public T[] toArray() {
		T[] items = (T[]) new Object[length];

		Node current = head;
		int i = 0;

		while (current != null) {
			items[i] = current.data;
			i += 1;
			current = current.next;
		}

		return items;
	}
	@Override
	public T removeFront() {
		if (!this.isEmpty()){
			T front = head.data;
			head = head.next;
			length--;
			return front;
		}
		return null;
	}
	@Override
	public T removeRear() {
		if (!this.isEmpty()){
			Node current = head;
			Node reference = null;
			for(int i=0; i<length; i++){
				reference = current;
				current = current.next;
			}
			length--;
			return reference.data;
		}
		return null;
	}
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<T>{
		private Node current = head;
		private int index = 0;
		
		public boolean hasNext(){
			if(index < length)
				return true;
			else
				return false;
		}
		
		public T next(){
			if(hasNext()){
				T nextItem = current.data;
				current = current.next;
				index++;
				return nextItem;
			}
			else
				throw new java.util.NoSuchElementException("No items remaining in the iteration.");
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
}

