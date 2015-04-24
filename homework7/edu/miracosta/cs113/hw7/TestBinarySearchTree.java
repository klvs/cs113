package edu.miracosta.cs113.hw7;

import java.util.ArrayList;
import java.util.Random;

public class TestBinarySearchTree {

	public static void main(String[] args) {

		// Insert solution to programming exercise 2, section 4, chapter 6 here
		// Insert solution to programming exercise 3, section 4, chapter 6 here
		
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
		Random rand = new Random();
		
		int testVal = 0;
		for(int i = 0; i < 20; i++) {
			int temp = rand.nextInt(99);
			test.add(temp);
			// save a value for testing
			if(i == 10){
				testVal = temp;
			}
		}
		
		System.out.println(test.toString());
		
		test.delete(testVal);
		System.out.println("---------------------------");
		System.out.println(testVal + " was removed");
		System.out.println("---------------------------");
		System.out.println(test.toString());
	}

}
