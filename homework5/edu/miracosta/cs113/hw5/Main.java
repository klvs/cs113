package edu.miracosta.cs113.hw5;

public class Main {
		
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.add(new Customer("Alex", 9001, new Transaction("Withdrawl", 200)));
		bank.add(new Customer("John", 9434, new Transaction("Deposit", 332)));
		bank.add(new Customer("Mirah", 443, new Transaction("Desposite", 3444)));
		bank.add(new Customer("Samantha", 934001, new Transaction("Withdrawl", 1112)));
		bank.add(new Customer("Eira", 43455, new Transaction("Desposite", 3444)));
		bank.add(new Customer("Austin", 1344, new Transaction("Withdrawl", 1112)));
		
		System.out.println(bank.getSize());
		System.out.println(bank.peek());
		bank.nextCustomer();
		bank.nextCustomer();
		bank.nextCustomer();
		bank.nextCustomer();
		bank.nextCustomer();
		System.out.println(bank.getSize());
		System.out.println(bank.peek());
	}
	
	
}
