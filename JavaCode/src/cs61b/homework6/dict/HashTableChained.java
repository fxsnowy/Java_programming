/* HashTableChained.java */

package cs61b.homework6.dict;

import java.util.ArrayList;
import java.util.Iterator;

import JavaCollections.list.DblyLinkList;

/*
 * The load factor represents at what level the HashMap/HashTable 
 * capacity should be doubled.
 * 
 * Default initial capacity of the 'HashMap' takes is 16 and load 
 * factor is 0.75f (i.e 75% of current map size). The load factor 
 * represents at what level the HashMap capacity should be doubled.
 *
 * For example product of capacity and load factor as 16 * 0.75 = 12.
 * This represents that after storing the 12th key – value pair into
 * the HashMap , its capacity becomes 32.
 * 
 * 
 */

/**
 * HashTableChained implements a Dictionary as a hash table with chaining. All
 * objects used as keys must have a valid hashCode() method, which is used to
 * determine which bucket of the hash table an entry is stored in. Each object's
 * hashCode() is presumed to return an int between Integer.MIN_VALUE and
 * Integer.MAX_VALUE. The HashTableChained class implements only the compression
 * function, which maps the hash code to a bucket in the table's range.
 *
 * This data model can be used in tree recursion using memoization to avoid re-visits.
 * 
 **/

public class HashTableChained<K, V> implements Dictionary<K, V> {
	
	/**
	 * Place any data fields here.
	 **/
	private long tableSize;
	private ArrayList<DblyLinkList<Entry<K, V>>> defTable;

	/*
	 * In order to not lose O(1) time.
	 */
	static final float DEFAULT_LOAD_FACTOR = 0.75f;
    
	/**
	 * Construct a new empty hash table intended to hold roughly sizeEstimate
	 * entries. (The precise number of buckets is up to you, but we recommend
	 * you use a prime number, and shoot for a load factor between 0.5 and 1.)
	 **/

	public HashTableChained(long sizeEstimate) {

		if (!(isPrime(sizeEstimate) && (sizeEstimate > 0L))) {
			sizeEstimate = nextPrime(sizeEstimate);
		}

		tableSize = sizeEstimate;
		defTable = new ArrayList<DblyLinkList<Entry<K, V>>>((int) sizeEstimate);
		

		for (int i = 0; i < (int) sizeEstimate; i++) {
			defTable.add(i, new DblyLinkList<Entry<K, V>>());
		}
		
	}

	
	/**
	 * Construct a new empty hash table with a default size. Say, a prime in the
	 * neighborhood of 100.
	 **/

	public HashTableChained() {
		tableSize = 101;
		defTable = new ArrayList<DblyLinkList<Entry<K, V>>>((int) tableSize);
		for (int i = 0; i < tableSize; i++) {
			defTable.add(i, new DblyLinkList<Entry<K, V>>());
		}
		
	}

	
	/**
	 * isPrime() helper function
	 * @param n
	 * @return
	 */
	private static boolean isPrime(long n) {
		if (n < 2)
			return false;
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		long sqrtN = (long) Math.sqrt(n) + 1;
		for (long i = 6L; i <= sqrtN; i += 6) {
			if (n % (i - 1) == 0 || n % (i + 1) == 0)
				return false;
		}
		return true;
	}

	
	/**
	 * nextPrime() helper function
	 * @param previous
	 * @return
	 */
	private static long nextPrime(long previous) {
		  if (previous < 2L) { return 2L; }
		  if (previous == 2L) { return 3L; }
		  long next = 0L;
		  int increment = 0;
		  switch ((int)(previous % 6L)) {
		    case 0: next = previous + 1L; increment = 4; break;
		    case 1: next = previous + 4L; increment = 2; break;
		    case 2: next = previous + 3L; increment = 2; break;
		    case 3: next = previous + 2L; increment = 2; break;
		    case 4: next = previous + 1L; increment = 2; break;
		    case 5: next = previous + 2L; increment = 4; break;
		  }
		  while (!isPrime(next)) {
		    next += increment;
		    increment = 6 - increment;   // 2, 4 alternating
		  }
		  return next;
		}

	
	/**
	 * Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
	 * to a value in the range 0...(size of hash table) - 1.
	 *
	 * This function should have package protection (so we can test it), and
	 * should be used by insert, find, and remove.
	 **/

	int compFunction(int code) {
		return code % (int) tableSize;
	}

	/**
	 * Returns the number of entries stored in the dictionary. Entries with the
	 * same key (or even the same key and value) each still count as a separate
	 * entry.
	 * 
	 * @return number of entries in the dictionary.
	 **/

	public int size() {
		int totalCount = 0;
		
		for(int index = 0; index < this.tableSize; index++){
			DblyLinkList<Entry<K, V>> keyValueList = defTable.get(index);
			if(keyValueList.size() > 0){
				totalCount += keyValueList.size();
			}
		}
		
		return totalCount;
	}

	/**
	 * Tests if the dictionary is empty.
	 *
	 * @return true if the dictionary has no entries; false otherwise.
	 **/

	public boolean isEmpty() {
		
		for(int index = 0; index < this.tableSize; index++){
			DblyLinkList<Entry<K, V>> keyValueList = defTable.get(index);
			if(keyValueList.size() > 0){
				return true;
			}
		}
		return false;
		
	}
	
	

	/**
	 * Create a new Entry object referencing the input key and associated value,
	 * and insert the entry into the dictionary. Return a reference to the new
	 * entry. Multiple entries with the same key (or even the same key and
	 * value) can coexist in the dictionary.
	 *
	 * This method should run in O(1) time if the number of collisions is small.
	 *
	 * Enlarge the hash table when the load factor becomes too large
	 * 
	 * @param key
	 *            the key by which the entry can be retrieved.
	 * @param value
	 *            an arbitrary object.
	 * @return an entry containing the key and value.
	 **/

	public Entry<K, V> insert(K key, V value) {
		
		/* Managing load factor  */
		if (this.size() / this.tableSize > 0.75){
			//then resize defTable - Enlarge
		}
		
		Entry<K, V> entry = new Entry<K, V>();
		entry.key = key;
		entry.value = value;

		DblyLinkList<Entry<K, V>> keyValueList = defTable.get(compFunction(key
				.hashCode()));
		keyValueList.insertBack(entry);
		return entry;
	}

	/**
	 * Search for an entry with the specified key. If such an entry is found,
	 * return it; otherwise return null. If several entries have the specified
	 * key, choose one arbitrarily and return it.
	 *
	 * This method should run in O(1) time if the number of collisions is small.
	 *
	 * @param key
	 *            the search key.
	 * @return an entry containing the key and an associated value, or null if
	 *         no entry contains the specified key.
	 **/

	public Entry<K, V> find(K key) {
		
		DblyLinkList<Entry<K, V>> keyValueList = defTable.get(compFunction(key
				.hashCode()));
		
		Iterator<Entry<K, V>> itr = keyValueList.iterator();
		while (itr.hasNext()) {
			Entry<K, V> element = itr.next();
			if (element.key().equals(key)){
				return element;
			}
		}

		return null;
	}

	/**
	 * Remove an entry with the specified key. If such an entry is found, remove
	 * it from the table and return it; otherwise return null. If several
	 * entries have the specified key, choose one arbitrarily, then remove and
	 * return it.
	 *
	 * This method should run in O(1) time if the number of collisions is small.
	 *
	 * Shrink hash tables (e.g., when n/N < 0.25) to free memory,
	 * 
	 * @param key
	 *            the search key.
	 * @return an entry containing the key and an associated value, or null if
	 *         no entry contains the specified key.
	 */

	public Entry<K, V> remove(K key) {
		
		/* Managing load factor  */
		if (this.size() / this.tableSize < 0.75){
			//then resize defTable - Shrink
		}
		
		DblyLinkList<Entry<K, V>> keyValueList = defTable.get(compFunction(key
				.hashCode()));
		
		Iterator<Entry<K, V>> itr = keyValueList.iterator();
		Entry<K, V> element = null;
		while (itr.hasNext()) {
			element = itr.next();
			if (element.key().equals(key)){
				itr.remove();
			}
		}
		
		return element;
	}

	/**
	 * Remove all entries from the dictionary.
	 */
	public void makeEmpty() {
		for(int index = 0; index < this.tableSize; index++){
			
			DblyLinkList<Entry<K, V>> keyValueList = defTable.get(index);
			if(keyValueList.size() > 0){
				Iterator<Entry<K, V>> itr = keyValueList.iterator();
				while (itr.hasNext()) {
					itr.next();
					itr.remove();
				}
			}
			
		}
	}
	
}
