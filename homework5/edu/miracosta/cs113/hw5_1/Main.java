package edu.miracosta.cs113.hw5_1;

public class Main {

	public static void main(String[] args) throws StackNumberOutOfBoundsException {
		
		DoubleStack<String> s = new DoubleStack<String>();
		s.push(1, "hur");
		s.push(1, "dum");
		s.push(1, "dee");
		s.push(2, "dur");
		s.push(2, "dah");
		s.push(2, "doo");
		System.out.println(s.peek(1));
		System.out.println(s.peek(2));
		System.out.println(s.pop(1));
		System.out.println(s.pop(1));
		System.out.println(s.pop(2));
		System.out.println(s.pop(2));
		System.out.println(s.pop(2));
		System.out.println(s.empty(1));
		System.out.println(s.empty(2));

	}

}
