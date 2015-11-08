/**
 * Implementation of DictionaryInterface using Linear Probing
 * 
 * @author Mac & Dakota fanning
 */
public class HashDictionaryChained<K, V> implements DictionaryInterface<K, V> {

	// initial size of hash table
	private static int DEFAULT_SIZE = 13;

	// When capacity exceeds this threshold, a new addition will trigger
	// rehashing
	private static double CAPACITY_THRESHOLD = 1.00;

	// the number of elements in the hash table
	private int numberOfElements;

	// the hash table
	private LinkedList<TableElement<K,V>>[] dictionary;

	// the current capacity of the hash table
	// this is a prime number
	private int currentCapacity;

	/**
	 * Inner class representing an element in the hash table This consists of a
	 * [Key:Value] mapping
	 *
	 * @param <K>
	 *            Key
	 * @param <V>
	 *            Value
	 */
	@SuppressWarnings("hiding")
	private class TableElement<K, V> {
		private boolean removed = false;
		private K key;
		private V value;

		// private boolean flag;

		private TableElement(K key, V value) {
			this.key = key;
			this.value = value;
			// this.flag = false;
		}
		/**
		 * Two TableElement objects are equals if they both have the same key
		 */
		@SuppressWarnings("unchecked")
		public boolean equals(Object other) {
			boolean flag = false;

			if (other instanceof TableElement) {
				TableElement<K, V> candidate = (TableElement<K, V>) other;

				if ((this.getKey()).equals(candidate.getKey()))
					flag = true;
			}

			return flag;
		}

		// if key is removed
		private boolean isRemoved() {
			return removed;
		}

		// set if key is removed
		private boolean remove() {
			return removed = true;
		}

		// set if key is not removed or flagged
		private boolean noVacancy() {
			return removed = false;
		}

		private K getKey() {
			return key;
		}

		private V getValue() {
			return value;
		}

		@SuppressWarnings("unused")
		private void setKey(K key) {
			this.key = key;
		}

		private void setValue(V value) {
			this.value = value;
		}
		
		// private void setFlag(boolean flag) {
		// this.flag = flag;
		// }
		// private boolean getFlag() {
		// return flag;
		// }
	}

	public HashDictionaryChained() {
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public HashDictionaryChained(int size) {
		if (size < 0)
			throw new IllegalArgumentException();

		dictionary = (LinkedList<TableElement<K, V>>[]) new LinkedList[size];
		numberOfElements = 0;
		currentCapacity = size;
	}

	/**
	 * Returns the hash value in the range [0 .. currentCapacity-1]
	 * 
	 * @param key
	 * @return int
	 */
	private int hashValue(K key) {
		return (Math.abs(key.hashCode()) % currentCapacity);
	}
	
	public  LinkedList<TableElement<K,V>>[] getDictionary() {
		return dictionary;
	}
	
	public  void setDictionary(LinkedList<TableElement<K,V>>[] newDictionary) {
		dictionary = newDictionary;
	}

	/**
	 * This calls the appropriate hashing strategy
	 */
	public V put(K key, V value) {
		// if (this.contains(key)){
		// return this.changeValue(key, value);
		// } else {
		TableElement<K, V> element = new TableElement<K, V>(key, value);

		// get the hash value for the specified key
		int hash = hashValue(key);
		
		//this.ensureCapacity();
		
		if(dictionary[hash]==null){
			dictionary[hash] = new LinkedList();
		}
		if(this.contains(key)){
			///probably failing on contains, look at contains or change value-change method
			this.remove(key);
		}
		dictionary[hash].add(element);
		++numberOfElements;
		return value;
	}


	public V get(K key) {
		int hash = hashValue(key);
		if (this.contains(key)){
			Object[] elementArray = dictionary[hash].toArray();
			for(int i = 0; i < elementArray.length ; i++ ) {
				TableElement<K,V> currentElement = (TableElement<K,V>) elementArray[i];
				if(currentElement.getKey().equals(key)){
					return currentElement.getValue();
				}
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DictionaryInterface#contains(java.lang.Object)
	 */
	public boolean contains(K key) {
		int hash = hashValue(key);
		if(dictionary[hash] != null){
			Object[] elementArray = dictionary[hash].toArray();
			for(int i = 0; i < elementArray.length ; i++ ) {
				TableElement<K,V> currentElement = (TableElement<K,V>) elementArray[i];
				if(currentElement.getKey().equals(key)){
					return true;
				}
			}
		}
	
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DictionaryInterface#remove(java.lang.Object)
	 */
	public V remove(K key) {
		if (this.contains(key)){
			int hash = hashValue(key);
			Object[] elementArray = dictionary[hash].toArray();
			for(int i = 0; i < elementArray.length ; i++ ) {
				@SuppressWarnings("unchecked")
				TableElement<K,V> currentElement = (TableElement<K,V>) elementArray[i];
				if(currentElement.getKey().equals(key)){
					dictionary[hash].remove(currentElement);
					--numberOfElements;
					return currentElement.getValue();
				}
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DictionaryInterface#size()
	 */
	public int size() {
		return numberOfElements;
	}
	
	public String toString() {
		String out = "";
		for (int i = 0; i < currentCapacity; i++) {
			if (dictionary[i] != null) {
				Object[] elementArray = dictionary[i].toArray();
				for(int j = 0; j < elementArray.length ; j++){
					TableElement<K,V> currentElement = (TableElement<K,V>) elementArray[j];
					out = out + (currentElement.getKey() + ",");
				}
			}
		}
		return out;
	}

	/**
	 * returns the next prime number that is least 2 larger than the current
	 * prime number.
	 */
	@SuppressWarnings("unused")
	private int getNextPrime(int currentPrime) {
		// first we double the size of the current prime + 1
		currentPrime *= 2;
		currentPrime += 1;

		while (!isPrime(currentPrime))
			currentPrime++;

		return currentPrime;
	}

	/**
	 * Helper method that tests if an integer value is prime.
	 * 
	 * @param candidate
	 * @return True if candidate is prime, false otherwise.
	 */
	private boolean isPrime(int candidate) {
		boolean isPrime = true;

		// numbers <= 1 or even are not prime
		if ((candidate <= 1))
			isPrime = false;
		// 2 or 3 are prime
		else if ((candidate == 2) || (candidate == 3))
			isPrime = true;
		// even numbers are not prime
		else if ((candidate % 2) == 0)
			isPrime = false;
		// an odd integer >= 5 is prime if not evenly divisible
		// by every odd integer up to its square root
		// Source: Carrano.
		else {
			for (int i = 3; i <= Math.sqrt(candidate) + 1; i += 2)
				if (candidate % i == 0) {
					isPrime = false;
					break;
				}
		}
		return isPrime;
	}

	/**
	 * re-hash the elements in the dictionary
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void rehash() {
		// double size of array
		TableElement[] tempArray = new TableElement[numberOfElements];
		int oldCapacity = currentCapacity;

		// re-mod the keys to get new hash
		for (int i = 0; i < oldCapacity; i++) {
			int index = 0;
			if (dictionary[i] != null) {
				Object[] elementArray = dictionary[i].toArray();
				for(int j = 0; j < elementArray.length ; j++){
					TableElement<K,V> currentElement = (TableElement<K,V>) elementArray[j];
					tempArray[index] = currentElement;
					index++;
				}
			}
		}
		currentCapacity = this.getNextPrime(currentCapacity);
		dictionary =  new LinkedList[currentCapacity];
		for (int j = 0; j < tempArray.length; j++){
			System.out.println(tempArray.length);
			System.out.println(j);
			K newKey = (K) tempArray[j].getKey();
			V newValue = (V) tempArray[j].getValue();
			this.put(newKey, newValue);
		}
		//currentCapacity = this.getNextPrime(currentCapacity * 2);
		//this.setDictionary(NewDictionary.getDictionary());
//		currentCapacity = this.getNextPrime(currentCapacity*2);
//		LinkedList<TableElement<K,V>>[] newDictionary = new LinkedList[currentCapacity];
//		for (int i = 0; i < oldCapacity; i++) {
//			if (dictionary[i] != null) {
//				Object[] elementArray = dictionary[i].toArray();
//				for(int j = 0; j < elementArray.length ; j++){
//					TableElement<K,V> currentElement = (TableElement<K,V>) elementArray[j];
//					int newHash = currentElement.getKey().hashCode() % currentCapacity;
//					if(newDictionary[newHash] == null){
//						newDictionary[newHash] = new LinkedList();
//					}
//					newDictionary[newHash].add(currentElement);
//				}
//			}
//		}
//		this.setDictionary(newDictionary);
	}

	/**
	 * Return the current load factor
	 * 
	 * @return
	 */
	private double getLoadFactor() {
		return numberOfElements / (double) currentCapacity;
	}

	/**
	 * Ensure there is capacity to perform an addition
	 */
	private void ensureCapacity() {
		double loadFactor = getLoadFactor();

		if (loadFactor >= CAPACITY_THRESHOLD)
			rehash();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DictionaryInterface#keySet()
	 */
	public Set<K> keySet() {
		// create set
		ArraySet<K> set = new ArraySet<K>();

		// loop through entire array
		for (int i = 0; i < currentCapacity; i++){
			if (dictionary[i] != null){
				Object[] elementArray = dictionary[i].toArray();
				for (int j = 0; j < elementArray.length; j++){
					TableElement<K,V> currentElement = (TableElement<K,V>) elementArray[j];
					set.add(currentElement.getKey());
				}
			}
		}
		return set;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DictionaryInterface#valueSet()
	 */
	public Set<V> valueSet() {
		// create set
		ArraySet<V> set = new ArraySet<V>();

		// loop through entire array
		for (int i = 0; i < currentCapacity; i++){
			if (dictionary[i] != null){
				Object[] elementArray = dictionary[i].toArray();
				for (int j = 0; j < elementArray.length; j++){
					TableElement<K,V> currentElement = (TableElement<K,V>) elementArray[j];
					set.add(currentElement.getValue());
				}
			}
		}
		return set;
	}

}
