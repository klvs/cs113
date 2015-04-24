package edu.miracosta.cs113.homework6;

public class Change {
	int pennies;
	int nickles;
	int dimes;
	int quarters;
	
	public Change(int p, int n, int d, int q){
		this.pennies = p;
		this.nickles = n;
		this.dimes = d;
		this.quarters = q;
	}
	
	public int getPennies() {
		return pennies;
	}
	public void setPennies(int pennies) {
		this.pennies = pennies;
	}
	public int getNickles() {
		return nickles;
	}
	public void setNickles(int nickles) {
		this.nickles = nickles;
	}
	public int getDimes() {
		return dimes;
	}
	public void setDimes(int dimes) {
		this.dimes = dimes;
	}
	public int getQuarters() {
		return quarters;
	}
	public void setQuarters(int quarters) {
		this.quarters = quarters;
	}
	
	
}
