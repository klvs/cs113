package edu.miracosta.cs113.lab5;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.LinkedList;

public class MyQueue<E> {
	LinkedList<E> list = new LinkedList<E>();

	public MyQueue() {
		
	}
	
	public int size() {
		return list.size();
		
	}

	public boolean offer(Object e) {
		return list.add((E) e);
	}

	public Object remove() {
		if(list.isEmpty()){
			throw new NoSuchElementException();
		}
		return list.remove(0);
	}

	public Object poll() {
		if(list.isEmpty()){
			return null;
		}
		return list.remove(0);
	}

	public Object element() {
		return list.element();
	}

	public Object peek() {
		return list.peek();
	}
	
}
