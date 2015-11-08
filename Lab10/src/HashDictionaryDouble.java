/**
 * Implementation of DictionaryInterface using Linear Probing
 * 
 * @author Mac & Dakota fanning
 */
import java.lang.Math;

public class HashDictionaryDouble<K, V> implements DictionaryInterface<K, V> {

	// initial size of hash table
	private static int DEFAULT_SIZE = 13;

	// When capacity exceeds this threshold, a new addition will trigger
	// rehashing
	private static double CAPACITY_THRESHOLD = 0.67;

	// the number of elements in the hash table
	private int numberOfElements;

	// the hash table
	private TableElement<K, V>[] dictionary;

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

	public HashDictionaryDouble() {
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public HashDictionaryDouble(int size) {
		if (size < 0)
			throw new IllegalArgumentException();

		dictionary = (TableElement<K, V>[]) new TableElement[size];
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

	/**
	 * This calls the appropriate hashing strategy
	 */
	public V put(K key, V value) {
		// if (this.contains(key)){
		// return this.changeValue(key, value);
		// } else {
		return linearProbing(key, value);
	}

	// private V changeValue(K key, V value){
	// TableElement<K,V> element = new TableElement<K,V>(key,value);
	// int hash = hashValue(key);
	// while (!dictionary[hash].equals(element)){
	// hash = (hash + 1) % currentCapacity;
	// }
	// dictionary[hash] = element;
	// return value;
	// }

	/**
	 * Private helper method that implements appropriate hashing strategy
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unused")
	private V linearProbing(K key, V value) {

		// create new value
		V valueNew;

		// re-hash if necessary
		ensureCapacity();

		// create the new element
		TableElement<K, V> element = new TableElement<K, V>(key, value);

		// get the hash value for the specified key
		int hash = hashValue(key);

		// use a simple linear probing
		// if there's something already in the same key replace it and return
		// the old value

		while (dictionary[hash] != null) {
			if (dictionary[hash].getKey().equals(key)) {
				valueNew = dictionary[hash].getValue();
				dictionary[hash].setValue(value);
				if (dictionary[hash].isRemoved())
					++numberOfElements;
				dictionary[hash].noVacancy();
				return value;
			}
			int probe = getProbed(hash);

			hash = (hash + probe) % currentCapacity;
		}
		++numberOfElements;

		dictionary[hash] = element;

		return value;
	}
	private int getProbed(int hash) {

		return (1 + Math.abs(hash)) % (currentCapacity - 2);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DictionaryInterface#get(java.lang.Object)
	 */
	public V get(K key) {
		int hash = hashValue(key);
		while (dictionary[hash] != null) {
			if (dictionary[hash].getKey().equals(key)) {
				return dictionary[hash].getValue();
			} else{
				int probe = getProbed(hash);
				hash = (hash + probe) % currentCapacity;
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
		while (dictionary[hash] != null) {
			if (dictionary[hash].getKey().equals(key)
					&& !dictionary[hash].isRemoved()) {
				return true;
			} else{
				int probe = getProbed(hash);
				hash = (hash + probe) % currentCapacity;
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

		int hash = hashValue(key);
		while (dictionary[hash] != null) {

			if (dictionary[hash].getKey().equals(key)) {
				dictionary[hash].remove();
				numberOfElements--;
				return dictionary[hash].getValue();
			} else{
				int probe = getProbed(hash);
				hash = (hash + probe) % currentCapacity;
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
			TableElement<K, V>[] NewDictionary = (TableElement<K, V>[]) new TableElement[dictionary.length * 2];

			currentCapacity = dictionary.length * 2;

			// re-mod the keys to get new hash
			for (int i = 0; i < dictionary.length; i++) {
				if (dictionary[i] != null) {
					int newHash = (Math.abs(dictionary[i].getKey().hashCode()) % currentCapacity);

					// put re-hashed keys into new array
					while (NewDictionary[newHash] != null) {
						int probe = getProbed(newHash);
						newHash = (newHash + probe) % currentCapacity;
					}
					TableElement element = dictionary[i];
					NewDictionary[newHash] = element;
				}
			}
			// set old dictionary to new dictionary
			this.dictionary = NewDictionary;
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
			for (int i = 0; i < dictionary.length; i++)
				if (dictionary[i] != null && !dictionary[i].isRemoved())
					set.add(dictionary[i].getKey());
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
			for (int i = 0; i < dictionary.length; i++)
				if (dictionary[i] != null && !dictionary[i].isRemoved())
					set.add(dictionary[i].getValue());
			return set;
		}

	}

