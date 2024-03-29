package edu.miracosta.cs113.hw9;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Hash table implementation using chaining.
 *  @author Koffman and Wolfgang
 **/
public class HashtableChain<K, V> extends AbstractMap<K,V> {

    /** The table */
    private LinkedList<Entry<K, V>>[] table;
    /** The number of keys */
    private int numKeys;
    /** The capacity */
    private static final int CAPACITY = 101;
    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;

    /** Contains key-value pairs for a hash table. */
    private static class Entry<K, V> implements Map.Entry<K, V> {

        /** The key */
        private K key;
        /** The value */
        private V value;

        /**
         * Creates a new key-value pair.
         * @param key The key
         * @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Retrieves the key.
         * @return The key
         */
        @Override
        public K getKey() {
            return key;
        }

        /**
         * Retrieves the value.
         * @return The value
         */
        @Override
        public V getValue() {
            return value;
        }

        /**
         * Sets the value.
         * @param val The new value
         * @return The old value
         */
        @Override
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
// Insert solution to programming exercise 3, section 4, chapter 7 here
        public String toString(){
        	return key.toString() + " : " + value.toString();
        }
    }

    // Constructor
    public HashtableChain() {
        table = new LinkedList[CAPACITY];
    }

    /*<listing chapter="7" number="9">*/
    /**
     * Method get for class HashtableChain.
     * @param key The key being sought
     * @return The value associated with this key if found;
     *         otherwise, null
     */
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            return null; // key is not in the table.
        }
        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index]) {
            if (nextItem.key.equals(key)) {
                return nextItem.value;
            }
        }

        // assert: key is not in the table.
        return null;
    }
    /*</listing>*/

    /*<listing chapter="7" number="10">*/
    /**
     * Method put for class HashtableChain.
     * @post This key-value pair is inserted in the
     *       table and numKeys is incremented. If the key is already
     *       in the table, its value is changed to the argument
     *       value and numKeys is not changed.
     * @param key The key of item being inserted
     * @param value The value for this key
     * @return The old value associated with this key if
     *         found; otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            // Create a new linked list at table[index].
            table[index] = new LinkedList<Entry<K, V>>();
        }

        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index]) {
            // If the search is successful, replace the old value.
            if (nextItem.key.equals(key)) {
                // Replace value for this key.
                V oldVal = nextItem.value;
                nextItem.setValue(value);
                return oldVal;
            }
        }

        // assert: key is not in the table, add new item.
        table[index].addFirst(new Entry<K, V>(key, value));
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length)) {
            rehash();
        }
        return null;
    }
    /*</listing>*/

    private void rehash() {
    	// save old table
    	LinkedList<Entry<K,V>>[] oldtable = table;
    	
    	// Double capacity
    	table = new LinkedList[oldtable.length * 2 +1];
    	
    	for(int i=0; i< oldtable.length; i++){
    		if(oldtable[i] != null){
    			put(((java.util.Map.Entry<K, V>) oldtable[i]).getKey(), ((java.util.Map.Entry<K, V>) oldtable[i]).getValue());
    		}
    	}
	}

	// Insert solution to programming exercise 4, section 4, chapter 7 here
    public String toString(){
    	String retStr = "";
    	for(LinkedList<Entry<K, V>> e: table){
    		int i = 0;
    		if(e != null){
        		while(! e.isEmpty() && i < e.size()){
        			retStr += e.get(i).toString() + "\n";
        			i++;
        		}
    		}
    	}
    	
    	return retStr;
    }

// Insert solution to programming exercise 5, section 4, chapter 7 here
    public int size(){
    	return numKeys;
    }

    /** Returns true if empty */
    public boolean isEmpty() {
        return numKeys == 0;
    }

// Insert solution to programming exercise 2, section 4, chapter 7 here
    public V remove(Object key){
    	for(LinkedList<Entry<K, V>> list: table){
    		if(list != null){
    			int i =0;
    			for(Entry<K,V> e: list){
    				if(e.getKey().equals(key)){
    					return (V) list.remove(i);
    				}
    				i++;
    			}
    		}
    	}
    	return null;
    }

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		return new EntrySet();
	}
	
    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {

        /** Return the size of the set. */
        @Override
        public int size() {
            return numKeys;
        }

        /** Return an iterator over the set. */
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new SetIterator();
        }
    }
    
    private class SetIterator implements Iterator<Map.Entry<K, V>> {
        int index = 0;
        Iterator<Entry<K, V>> localIterator = null;
        @Override
        public boolean hasNext() {
            if (localIterator != null) {
                if (localIterator.hasNext()) {
                    return true;
                } else {
                    localIterator = null;
                    index++;
                }
            }
            while (index < table.length
                    && table[index] == null) {
                index++;
            }
            if (index == table.length) {
                return false;
            }
            localIterator = table[index].iterator();
            return localIterator.hasNext();
        }
        @Override
        public Map.Entry<K, V> next() {
        	return localIterator.next();
        }
        @Override
        public void remove() { 
        	localIterator.remove();
        }
        }


// Insert solution to programming project 7, chapter -1 here
}
/*</listing>*/