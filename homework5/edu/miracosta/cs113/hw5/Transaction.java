package edu.miracosta.cs113.hw5;

public class Transaction {
	String type;
	float amount;
	
	public Transaction(String type, float amount) {
		setType(type);
		setAmount(amount);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}