package edu.miracosta.cs113.hw8;

import java.util.Collection;
import java.util.Comparator;

public class MinHeap extends Heap {
	
	public MinHeap(){
		super();
	}
	
	public MinHeap(Comparator c) {
		super(c);
	}
	
	public MinHeap(Collection c) {
		super(c);
	}
	
	
}
