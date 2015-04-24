package edu.miracosta.cs113.hw8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public abstract class Heap extends ArrayList{
	private Comparator comparator = null;
	
	public Heap() {
		super();
	}
	
	public Heap(Comparator c) {
		super();
		comparator = c;
	}
	
	public Heap(Collection c) {
		super();
		addAll(c);
	}
	
	// removes object at index (mostly to use in remove(object))
	public Object remove(int i) {
		Object o = get(i);
		set(i, get(size()-1));
		super.remove(size()-1);
		enheap(i);
		return o;
	}
	
	// removes first occurance of object
	public boolean remove(Object o) {
		boolean isFound = false;
		for(int i = 0; i < size(); i++) {
			if((o == null && get(i) == null) || o.equals(get(i))) {
				isFound = true;
				remove(i);
				break;
			}
		}
		return isFound;
	}
	
	public boolean add(Object o) {
		boolean added = super.add(o);
		for(int n = size()-1; n > 0;){
			int comp;
			int parent = (n-1)/2;
			if(compare(n, parent) < 0) {
				// swap and reorder
				Object temp = get(n);
				set(n, get(parent));
				set(parent, temp);
			}
			
			n = parent;
		}
		
		return added;
	}
	
	public boolean addAll(Collection c) {
		boolean added = super.addAll(c);
		reheap();
		return added;
	}
	
	protected int compare(int n1, int n2) {
		int res = 0;
		if(comparator != null) { // set in constructor
			res = comparator.compare(get(n1), get(n2));
		} else { // objects are comparable
			res = ((Comparable) get(n1)).compareTo(get(n2));
		}
		return res;
	}
	
	public void reheap() {
		for(int i = size()/2; i>= 0; i--){
			enheap(i);
		}
	}
	
	// wrapper for real enheap()
	public void enheap(int node){
		enheap(node, size());
	}
	
	// recursively swaps elements to build a proper heap
	private void enheap(int node, int size) {
		if(node > size) {
			return; // Used incorrectly!!
		}
		
		int right = (node + 1) * 2;
		int left = (node + 1) * 2 - 1;
		
		int minDex = node;
		
		if(left < size && compare(left, node) <= 0)
			minDex = left;
		if(right < size && compare(right, node) <= 0 && compare(right,left) <=0)
			minDex = right;
		
		if(minDex != node) {
			// improper! Time to recurse
			Object temp = get(node);
			set(node, get(minDex));
			set(minDex, temp);
			
			enheap(minDex, node);
		}
		
	}
}
