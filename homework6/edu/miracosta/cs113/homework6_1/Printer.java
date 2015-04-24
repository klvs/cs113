package edu.miracosta.cs113.homework6_1;

public class Printer {
	String name;
	PrintJob job;
	PrintQueue queue;
	
	public Printer(String n, PrintQueue q) {
		name = n;
		queue = q;
	}
	
	public void getJob() {
		if(! queue.isEmpty()){
			job = queue.poll();
			System.out.println("Print " + name + " got job " + job.name);
		}
	}
	
	public boolean isDone() {
		if(job.getNoPages() > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void print(){
//		System.out.println(queue.highPriority.size());
//		System.out.println(queue.mediumPriority.size());
//		System.out.println(queue.lowPriority.size());
		
		if( job == null) {
			getJob();
		}
		if(! isDone()){
			getJob();
			job.decrementPages();
		} else {
			getJob();
		}
	}
	
}
