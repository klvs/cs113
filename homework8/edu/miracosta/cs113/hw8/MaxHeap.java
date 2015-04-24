package edu.miracosta.cs113.hw8;

import java.util.Collection;
import java.util.Comparator;

public class MaxHeap extends Heap {
	
	public MaxHeap(){
		super();
	}
	
	public MaxHeap(Comparator c) {
		super(c);
	}
	
	public MaxHeap(Collection c) {
		super(c);
	}
	
	// abstract heap is by default a minHeap
	// by overriding MaxHeap's compare method
	// super.enheap() will enheap correctly
	protected int compare(int n1, int n2) {
		return -super.compare(n1, n2);
	}
	
	
}
