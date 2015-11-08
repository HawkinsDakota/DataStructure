/**
 * LinkedList.java
 * 
 * Implementation of List interface using a linked list.
 * 
 * @author Dakota Hawkins
 * @date February 11, 2015
 *
 */

public class LinkedList<T> implements List<T>
{
    private Node head;

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
        private Object data;
        private Node next;
        
        /**
         * 1-parameter initiator for private class Node
         * initiates the data but does not link to another
         * node
         */
        private Node(Object data) {
            this(data,null);
        }
        /**
         * Two-parameter initiator for private class Node
         * Initiates both the data for the node and
         * the next node in the LinkedList
         */
        private Node (Object data, Node next) {
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
    public void add(T item) {
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
    }

    
    /**
     * getLength method returns the length of the LinkedList
     * iterates through until it finds the
     * 'null' value for node data, signifying the end of the list.
     * Increments length until the end of the list.
     */
    public int getLength() {
        int length = 0;
        Node reference = head;
        while (reference != null){
        	++length;
        	reference = reference.next;
        }
        return length;
    }
    
    /**
     * contains method determines whether an Object
     * is part of the LinkedList. Works by iterating through
     * the beginning of the LinkedList, and determines whether
     * the current value is equal to reference value. Returns true 
     * if the reference Object is found before the LinkedList ends.
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
    	if (head == null){
        	return true;
        }
    	return false;
}
    
    /**
     * Determines the number of times an Object appears in the
     * LinkedList. Iterates through LinkedList and counts number of
     * times the reference Object is equal to the iterated values.
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
    	T[] items = (T[]) new Object[this.getLength()];
    	
    	Node current = head;
    	int i = 0;
    	
    	while (current != null) {
    		items[i] = (T) current.data;
    		i += 1;
    		current = current.next;
    	}
    	
    	return items;
    }
}

