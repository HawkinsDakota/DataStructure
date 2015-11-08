/**
 * LinkedList.java
 * 
 * Implementation of List interface using a linked list.
 * 
 * @author Greg Gagne  
 * 								Mac Greene January 2015 
 */

public class LinkedList<T> implements List {
	private int size = 0;
	
	private Node head;

	public LinkedList() {
		head = null;
		size = 0;
	}

	/**
	 * Inner class representing a node in the linked list
	 */
 
	private class Node // this is a private class
	{
		private Object data;
		private Node next;

		private Node(Object data) {
			this(data, null);
		}

		private Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	// Methods

	/**
	 * Adds an item to the linked list This implementation adds to the beginning
	 * of the list.
	 */
	public void add(Object item) {
		size++;
		Node newNode = new Node(item);

		if(head == null) 
		{
			newNode.next = head;
			head = newNode;
		}
		else 
		{
			Node current = head;
			
			while (current.next != null) 
			{
				current = current.next;
			}
				current.next = newNode;
			}
		}
		public void remove(Object item) {
			Node nodeupdate = head;
			// get a reference to the item we want to delete
			Node reference = null;
			// Node reference = getReferenceTo(item);
			while ((nodeupdate != null) && (reference == null)) {
				if ((nodeupdate.data).equals(item)) {
					reference = nodeupdate;
				}
				nodeupdate = nodeupdate.next;
			}
			if (reference != null) {
				// set the data of the node we want
				// * to delete to the data currently
				// * at the head.
				//
				reference.data = head.data;

				/**
				 * now remove the head
				 */
				head = head.next;
				size--;
			}
		}

		public int getLength() {
			return size;
		}

		public boolean contains(Object item) {
			if(this.isEmpty()){
				return false;
			}
			int nodefind = 0;
			Node nodeupdate = head;
			while (nodeupdate.data.equals(item) == false) {
				nodeupdate = nodeupdate.next;
				nodefind++;
				if ((nodefind == this.getLength())) {
					return false;
				}
			}
			return true;
		}

		public boolean isEmpty() {
			if (size == 0)
				return true;
			else
				return false;
		}

		public int getFrequency(Object item) {
			int frequency = 0;
			Node nodeupdate = head;
			for (int nodefind = 0; nodefind < size; nodefind++) {
				if (nodeupdate.data.equals(item)) {
					frequency++;
				}
				nodeupdate = nodeupdate.next;
			}
			return frequency;
		}

		/**
		 * Returns an array representation of items in the linked list
		 */
		public Object[] toArray() {
			Object[] items = new Object[getLength()];

			Node current = head;
			int i = 0;

			while (current != null) {
				items[i] = current.data;
				i += 1;
				current = current.next;
			}
			return items;
		}
		public static void main(String[] args){
			LinkedList testList = new LinkedList();
			System.out.println(testList.contains("hi"));
		}

	}


