package edu.miracosta.cs113;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class Pg200 {
	
	public static void main(String args[]){
		
		// problem 1
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] nums = {-1, 15,23,44,4,99};
		for(int num: nums){
			stack1.push(num);
		}
		
		//problem 2
		do{
			int val = stack1.pop();
			queue.offer(val);
			stack2.push(val);
		} while (!stack1.isEmpty());
		
		for(int num: nums){
			System.out.println("stack: " + stack2.pop() );
			System.out.println("queue: " + queue.poll());
		}
	}
}
