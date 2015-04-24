package edu.miracosta.cs113.homework6_1;

import java.util.LinkedList;
import java.util.Queue;

public class PrintQueue {
	Queue<PrintJob> highPriority = new LinkedList<PrintJob>();
	Queue<PrintJob> mediumPriority = new LinkedList<PrintJob>();
	Queue<PrintJob> lowPriority = new LinkedList<PrintJob>();
	
	public PrintQueue(){
		
	}
	
	// adds job to proper queue based on page size
	public boolean add(PrintJob p){
		System.out.println( p.getName()  + " recieved");
		if(p.getNoPages() <= 10 && p.getNoPages() >= 1 ){
			highPriority.add(p);
			return true;
		} else if(p.getNoPages() <= 20){
			mediumPriority.add(p);
			return true;
		} else if(p.getNoPages() > 20){
			lowPriority.add(p);
			return true;
		} else {
			return false;
		}
	}
	
	// retrieves job from proper queue based on size of next highest priority queue
	public PrintJob poll(){
		if(highPriority.size() >= 1) {
			PrintJob p = highPriority.poll();
			return p;
		} else if(mediumPriority.size() >= 1) {
			PrintJob p = mediumPriority.poll();
			return p;
		} else {
			PrintJob p = lowPriority.poll();
			return p;
		}
	}
	
	public boolean isEmpty(){
		if(lowPriority.size() == 0 && mediumPriority.size() == 0 && highPriority.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
