package edu.miracosta.cs113;
import java.lang.StringBuilder;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]){
		System.out.println(reverse("racecar"));
		System.out.println(reverse("the quick brown fox jumped over the lazy dog"));
		ArrayStack<String> stack = new ArrayStack();
		stack.push("hur");
		stack.push("dur");
		stack.push("dur");
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		
	}
	
	public static String reverse(String s){
		StringBuilder str = new StringBuilder();
		Stack stack = new Stack();
		int index =0;
		do{
			stack.push(s.charAt(index));
			index++;
		} while (index < s.length());
		do{
			str.append(stack.pop());
		} while (!stack.isEmpty());
		
		return str.toString();
	}
	

}
