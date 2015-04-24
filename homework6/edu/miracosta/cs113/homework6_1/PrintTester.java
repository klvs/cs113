package edu.miracosta.cs113.homework6_1;

import java.util.ArrayList;
import java.util.Random;

public class PrintTester {

	public static void main(String[] args) {
		PrintQueue queue = new PrintQueue();
		
		Random rn = new Random();
		// generate jobs
		for(int i=1; i<= 100; i++) {
			// "job i" w/ # of pages random between 1 and 50
			queue.add(new PrintJob("job" + i, rn.nextInt(50) +1 ));
		}
		
		// create printers
		Printer p1 = new Printer("Printer 1", queue);
		Printer p2 = new Printer("Printer 2", queue);
		Printer p3 = new Printer("Printer 3", queue);
		
		// each is iteration is 6 seconds
		int noSeconds = 0;
		while(! queue.isEmpty()) {
			noSeconds += 6;
			p1.print();
			p2.print();
			p3.print();
		}
		
		System.out.println("Took " + noSeconds / 60 + " minutes " + noSeconds % 60 + " seconds");
	}

}
