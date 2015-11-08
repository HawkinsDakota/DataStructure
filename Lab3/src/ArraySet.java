
/**
 * Class that creates the Set object type. Contains 
 * intersection, union, and difference methods.
 * 
 * @author Dakota Hawkins and Harry Hause
 * @date January 28, 2015
 */

public class ArraySet implements Set {
	
	public static final int CAPACITY_MULTIPLIER = 2;
	public static final int DEFAULT_CAPACITY = 15;
	private int capacity = 0; 
	private int size = 0;
	private Object [] elements;
	
	//Default constructor for ArraySet object.
	//Sets capacity to DEFAULT_CAPACITY.
	public ArraySet(){
		this(DEFAULT_CAPACITY);
	}
	
	//Non-default constructor. Allows
	//user to set capacity.
	public ArraySet(int capacity){
		if(capacity < 0){
			throw new IllegalArgumentException("Capacity must be >= 0");
		}
		this.capacity = capacity;
		elements = new Object [capacity];
	}
	//Method to add new element to ArraySet.
	//Checks for duplicate element before adding.
	//Does nothing if duplicate exists.
	public void add(Object element){
		ensureCapacity();
		if (this.contains(element) == false) {
			elements[size] = element;
			size++;
		}
	}
	
	//Method to add multiple element to ArraySet
	//Calls add method: duplicates are checked.
	public void addAll(Object[] elements){
		for (int i = 0; i < elements.length; i++) {
			add(elements[i]);
		}
	}
	
	//Method to determine whether element 
	//exists within ArraySet.
	public boolean contains(Object element){
		if (indexOf(element) > -1) { 
			return true;
		} else {
			return false;
		}
	}
	
	//Getter method for instance variable "size".
	public int getSize(){
		return size;
	}
	
	//Getter method for instance variable "capacity"
	public int getCapacity(){
		return capacity;
	}
	//Removes an element from the set.
	public void remove(Object element){
		int index = indexOf(element);
		
		if (index > -1){
			size--;
			elements[index] = elements[size];
		}
	}
	//Find the set union of two sets.
	public Set union(Set anotherSet) {
		Set set1 = new ArraySet();
		set1 = anotherSet.difference(this);
		for (int i = 0; i < this.getSize(); i++){
		    set1.add(elements[i]);
		    
		}
		
		return set1;
	}
	//Finds the set intersection of two sets.
	public Set intersection(Set anotherSet) {
		Set intersection = new ArraySet();
		for (int i = 0; i < this.getSize(); i++){
			if (anotherSet.contains(elements[i])){
				intersection.add(elements[i]);
			}
			
		}
		return intersection;
	}
	//Finds the set difference of two sets
	public Set difference(Set anotherSet) {
		Set difference = new ArraySet();
		for (int i = 0; i < this.getSize(); i++){
			if (anotherSet.contains(elements[i]) == false){
				difference.add(elements[i]);
			}
			
		}
		return difference;
	}
	//Helper method to find the index of
	//a specific element.
	private int indexOf(Object element){
		int index = -1;
		for(int i = 0; i < size;i++){
			if(elements[i].equals(element)){
				index = i;
				break;
			}
		}
		return index;
	}
	//Helper method to check capacity
	//of the ArraySet. Increases capacity
	//if array is not large enough.
	private void ensureCapacity(){
		if (size == capacity){
			Object [] newArray = new Object[(size +1)* CAPACITY_MULTIPLIER];
			System.arraycopy(elements,0,newArray,0,size);
			elements = newArray;
		}
	}
}
