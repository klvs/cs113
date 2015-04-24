package edu.miracosta.cs113.hw5;

public class Customer {
	String name;
	float balance;
	Transaction transaction;
	
	public Customer(String name, float balance, Transaction transaction) {
		setName(name);
		setBalance(balance);
		setTransaction(transaction);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
