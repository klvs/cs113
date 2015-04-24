package edu.miracosta.cs113.lab5;

public class Tester {

	public static void main(String[] args) {
		MyQueue<String> q = new MyQueue<String>();
		q.offer("test1");
		q.offer("test2");
		q.offer("test3");
		q.offer("test4");

		System.out.println(q.peek());
		System.out.println(q.poll());

		System.out.println(q.size());
		System.out.println(q.remove());
		

	}

}
