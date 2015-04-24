package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayStack<E> {
	private ArrayList<E> data;
	
	public ArrayStack(){
		data = new ArrayList();
	}
	//push
	public void push(E obj){
		data.add(obj);
	}
	//pop
	public E pop(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return data.remove(data.size()-1);
		
	}
	//empty
	public boolean isEmpty(){
		return data.size() == 0;
	}
	
	//peek
	public E peek(){
		return data.get(data.size()-1);
	}
}
