package cs113_Roman_Alexander;

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Class KWLinkedList implements a double linked list and
 * a ListIterator.
 * @author Koffman & Wolfgang
 **/
public class KWLinkedList<E> extends AbstractSequentialList<E> {
    // Data Fields

    /** A reference to the head of the list. */
    private Node<E> head = null;
    /** A reference to the end of the list. */
    private Node<E> tail = null;
    /** The size of the list. */
    private int size = 0;

    //Methods
// Insert solution to programming exercise 4, section 8, chapter 2 here
    public void addFirst(E obj){
        this.add(0, obj);
    }
    public void addLast(E obj){
    	this.add(this.size, obj);
    }
    public E getFirst(){
    	return this.head.data;
    }
    public E getLast(){
    	return this.tail.data;
    }


// Insert solution to programming exercise 3, section 8, chapter 2 here
    public Iterator<E> iterator(){
    	return new KWListIter(0);
    }
    public ListIterator<E> listIterator(){
    	return new KWListIter(0);
    }
    public ListIterator<E> listIterator(int index){
    	return new KWListIter(index);
    }
    /**
     * Add an item at the specified index.
     * @param index The index at which the object is to be
     *        inserted
     * @param obj The object to be inserted
     * @throws IndexOutOfBoundsException if the index is out
     *         of range (i < 0 || i > size())
     */
    @Override
    public void add(int index, E obj) {
        listIterator(index).add(obj);
    }

    /**
     * Get the element at position index.
     * @param index Position of item to be retrieved
     * @return The item at index
     */
    @Override
    public E get(int index) {
        return listIterator(index).next();
    }

    /**
     * Return the size of the list
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    // Inner Classes
    /** 
     * A Node is the building block for a double-linked list.
     */
    private static class Node<E> {

        /** The data value. */
        private E data;
        /** The link to the next node. */
        private Node<E> next = null;
        /** The link to the previous node. */
        private Node<E> prev = null;

        /**
         * Construct a node with the given data value.
         * @param dataItem The data value
         */
        private Node(E dataItem) {
            data = dataItem;
        }
    } //end class Node

    /** Inner class to implement the ListIterator interface. */
    private class KWListIter implements ListIterator<E> {

        /** A reference to the next item. */
        private Node<E> nextItem;
        /** A reference to the last item returned. */
        private Node<E> lastItemReturned;
        /** The index of the current item. */
        private int index = 0;

        /**
         * Construct a KWListIter that will reference the ith item.
         * @param i The index of the item to be referenced
         */
        public KWListIter(int i) {
            // Validate i parameter.
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException(
                        "Invalid index " + i);
            }
            lastItemReturned = null; // No item returned yet.
            // Special case of last item.
            if (i == size) {
                index = size;
                nextItem = null;
            } else { // Start at the beginning
                nextItem = head;
                for (index = 0; index < i; index++) {
                    nextItem = nextItem.next;
                }
            }
        }

        /**
         * Construct a KWListIter that is a copy of another KWListIter
         * @param other The other KWListIter
         */
        public KWListIter(KWListIter other) {
            KWListIter itr = new KWListIter(0);
            itr.index = other.index;
            itr.lastItemReturned = other.lastItemReturned;
            itr.nextItem = other.nextItem;
        }

        /**
         * Indicate whether movement forward is defined.
         * @return true if call to next will not throw an exception
         */
        @Override
        public boolean hasNext() {
            return nextItem != null;
        }

        /** Move the iterator forward and return the next item.
        @return The next item in the list
        @throws NoSuchElementException if there is no such object
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        /**
         * Indicate whether movement backward is defined.
         * @return true if call to previous will not throw an exception
         */
        @Override
        public boolean hasPrevious() {
            return (nextItem == null && size != 0)
                    || nextItem.prev != null;
        }

        /**
         * Return the index of the next item to be returned by next
         * @return the index of the next item to be returned by next
         */
        @Override
        public int nextIndex() {
            return index;
        }

        /**
         * Return the index of the next item to be returned by previous
         * @return the index of the next item to be returned by previous
         */
        @Override
        public int previousIndex() {
            return index - 1;
        }

        /**
         * Move the iterator backward and return the previous item.
         * @return The previous item in the list
         * @throws NoSuchElementException if there is no such object
         */
        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (nextItem == null) { // Iterator past the last element
                nextItem = tail;
            } else {
                nextItem = nextItem.prev;
            }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }

        /**
         * Add a new item between the item that will be returned
         * by next and the item that will be returned by previous.
         * If previous is called after add, the element added is
         * returned.
         * @param obj The item to be inserted
         */
        @Override
        public void add(E obj) {
            if (head == null) { // Add to an empty list.
                head = new Node<E>(obj);
                tail = head;
            } else if (nextItem == head) { // Insert at head.
                // Create a new node.
                Node<E> newNode = new Node<E>(obj);
                // Link it to the nextItem.
                newNode.next = nextItem; // Step 1
                // Link nextItem to the new node.
                nextItem.prev = newNode; // Step 2
                // The new node is now the head.
                head = newNode; // Step 3
            } else if (nextItem == null) { // Insert at tail.
                // Create a new node.
                Node<E> newNode = new Node<E>(obj);
                // Link the tail to the new node.
                tail.next = newNode; // Step 1
                // Link the new node to the tail.
                newNode.prev = tail; // Step 2
                // The new node is the new tail.
                tail = newNode; // Step 3
            } else { // Insert into the middle.
                // Create a new node.
                Node<E> newNode = new Node<E>(obj);
                // Link it to nextItem.prev.
                newNode.prev = nextItem.prev; // Step 1
                nextItem.prev.next = newNode; // Step 2
                // Link it to the nextItem.
                newNode.next = nextItem; // Step 3
                nextItem.prev = newNode; // Step 4
            }
            // Increase size and index and set lastItemReturned.
            size++;
            index++;
            lastItemReturned = null;
        } // End of method add.

// Insert solution to programming exercise 1, section 8, chapter 2 here
        public void remove(){
        	if(lastItemReturned == null){
        		throw new IllegalStateException();
        	} 
        	
        	lastItemReturned.next.prev=lastItemReturned.prev;
        	lastItemReturned.prev.next=lastItemReturned.next;
        	lastItemReturned=null;
        }
// Insert solution to programming exercise 2, section 8, chapter 2 here
        public void set(E data){
        	if(lastItemReturned == null){
        		throw new IllegalStateException();
        	} 
        	lastItemReturned.data = data;
        }


    } //end class KWListIter

// Insert solution to programming exercise 1, section 7, chapter 2 here
    // why can't this be E objective??
    public int indexOf(Object target){
    	int index = 0;
    	Node<E> node = this.head; // start at beg
    	if(node.data.equals(target)){
    		return 0;
    	}
    	while(node.next != null){
    		if(node.data.equals(target)){
    			return index;
    		}else{
    			index++;
    			node=node.next;
    		}
    	}
    	if(this.tail.data.equals(target)){
    		return index;
    	}
    	return -1; // not found
    }
 // Insert solution to programming exercise 2, section 7, chapter 2 here 
    public int lastIndexOf(Object objective){
    	int index = this.size() -1;
    	Node<E> node = this.tail;
    	if(node.data.equals(objective)){
    		return 0;
    	}
    	while(node.prev != null){
    		if(node.data.equals(objective)){
    			return index;
    		}else{
    			index--;
    			node=node.prev;
    		}
    	}
    	return -1; // not found
    }
    
// Insert solution to programming exercise 3, section 7, chapter 2 here
    public int indexOfMin() {
    	Iterator<E> iter = this.iterator();
    	int mindex = 0;
    	int index = 0;
    	Comparable<E> minItem = null;
    	
    	if(iter.hasNext()) {
    		minItem = (Comparable<E>) iter.next();
    	} else {
    		return -1;
    	}
    	
    	while(iter.hasNext()){
    		index++;
    		Comparable<E> item = (Comparable<E>) iter.next();
    		if(item.compareTo((E) minItem) <= 0){
    			item = (Comparable<E>) minItem;
    			mindex = index;
    		}
    	}
    	
    	return mindex;
    	
    }
// Insert solution to programming exercise 1, section 6, chapter 2 here
    
    public static void exercise1(){
		Node tom = new Node<String>("Tom");
		Node dick = new Node<String>("Dick");
		Node harry = new Node<String>("Harry");
		Node sam = new Node<String>("Sam");
		Node head;
		Node tail;
		
		head = tom;
		tail = sam;
		tom.next = dick;
		dick.prev = tom;
		dick.next = harry;
		harry.prev = dick;
		harry.next = sam;
		sam.prev = harry;
		sam.next = tom;
		
		// insert bill before tom
		Node bill = new Node<String>("Bill");
		bill.next = tom;
		tom.prev = bill;
		head = bill;
		
		// insert sue before sam
		Node sue = new Node<String>("Sue");
		sue.next = sam;
		sue.prev = harry;
		harry.next = sue;
		
		// rm bill
		head = head.next;
		head.prev = null;
		bill.next = null;
		
		//rm sam
		tail = sue;
		sue.next = null;
    }
}
/*</listing>*/