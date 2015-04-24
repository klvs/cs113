package edu.miracosta.cs113.hw8;

public class HeapTester {

	public static void main(String[] args) {
		
		System.out.println("Adding 9, 18, 11, 2, 4, 3, 20 to Max");
		System.out.println("Removing root node at a time");

		MaxHeap maxHeap = new MaxHeap();
		int[] testNums = {9, 18, 11, 2, 4, 3, 20};
		
		for(int num: testNums) {
			maxHeap.add(new Integer(num));
		}
		
		for(int num: testNums) {
			System.out.println(maxHeap.remove(0));
		}
		

		System.out.println("Adding 9, 18, 11, 2, 4, 3, 20 to MinHeap");
		System.out.println("Removing root node at a time");

		MinHeap minHeap = new MinHeap();
		for(int num: testNums) {
			minHeap.add(new Integer(num));
		}
		
		for(int num: testNums) {
			System.out.println(minHeap.remove(0));
		}
		
		
	}

}
