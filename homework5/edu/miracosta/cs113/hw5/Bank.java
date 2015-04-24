package edu.miracosta.cs113.hw5;
import java.util.Stack;

public class Bank {
	Stack<Customer> stack = new Stack<Customer>();
	
	public Bank(){
		
	}
	
	public int getSize() {
		return stack.size();
	}
	
	public Customer nextCustomer() {
		return stack.pop();
	}
	
	public void add(Customer c) {
		stack.add(c);
	}
	
	public String peek(){
		return stack.peek().getName();
	}
}