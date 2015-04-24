package edu.miracosta.cs113.test;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList();
		l.add("Pokey");
		l.add("Campy");
//		int i = l.indexOf("happy");
//		l.set(i, "bouncy");
		l.remove(l.size() -2);
//		l.get(1);
		System.out.println(l.size());
//		System.out.println(i);

	}

}
