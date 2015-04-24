package edu.miracosta.cs113.hw5_1;

public class DoubleStack<E> {
	final int CAPACITY = 30;
	Object[] array = new Object[CAPACITY];
	int index1 = 0; // stack 1 index
	int index2 = CAPACITY -1; // stack 2 index
	
	
	public DoubleStack(){
//		System.out.println(index1);
//		System.out.println(index2);
	}
	
	public E pop(int stackNo) throws StackNumberOutOfBoundsException {
		if(stackNo == 1) {
			if(index1 > 0) {
				index1--;
				E temp = (E) array[index1]; // store before returning
				array[index1] = null; // remove element
				return temp;
			} else {
				return null;
			}
		} else if (stackNo == 2) {
			if(index2 > 0) {
				index2++;
				E temp = (E) array[index2];
				array[index2] = null; 
				return temp;
			} else {
				return null;
			}
		} else{
			throw new StackNumberOutOfBoundsException("Stack number out of bounds");
		}
	}
	
	public void push(int stackNo, E val) throws StackNumberOutOfBoundsException {
		if(stackNo == 1) {
			this.array[index1] = val;
			index1++;
		} else if (stackNo == 2) {
			this.array[index2] = val;
			index2--;
		} else{
			throw new StackNumberOutOfBoundsException("Stack number out of bounds");
		}
		
//		System.out.println(array[index1]);
//		System.out.println(val);
	}
	
	public E peek(int stackNo) throws StackNumberOutOfBoundsException {
		if(stackNo == 1 ) {
			if(index1 > 0) {
				E temp = (E) array[index1-1]; // store before returning
				return temp;
			} else {
				return null;
			}
		} else if (stackNo == 2) {
			if(index2 > 0) {
				E temp = (E) array[index2+1]; // store before returning
				return temp;
			} else {
				return null;
			}
		} else{
			throw new StackNumberOutOfBoundsException("Stack number out of bounds");
		}
	}
	
	public boolean empty(int stackNo) throws StackNumberOutOfBoundsException {
		if(stackNo == 1) {
			for(int i = 0; i < index1; i++){
				if(array[i] == null){
					continue;
				} else {
					return false;
				}
			}
		} else if (stackNo == 2) {
			for(int i = index2; i < CAPACITY; i++){
				if(array[i] == null){
					continue;
				} else {
					return false;
				}
			}
		} else{
			throw new StackNumberOutOfBoundsException("Stack number out of bounds");
		}
		return true; 
	}
}


