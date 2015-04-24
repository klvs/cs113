package edu.miracosta.cs113.homework6_1;

public class PrintJob {
	String name;
	int noPages;
	
	public PrintJob(String name, int noPages) {
		this.name = name;
		this.noPages = noPages;
	}
	
	public int decrementPages(){
		noPages = noPages -1;
		return noPages;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNoPages() {
		return noPages;
	}
	
	public void setNoPages(int noPages) {
		this.noPages = noPages;
	}
	
	
}
