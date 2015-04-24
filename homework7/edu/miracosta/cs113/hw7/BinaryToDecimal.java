package edu.miracosta.cs113.hw7;

public class BinaryToDecimal {

	public static void main(String[] args) {
		System.out.println(decToBin(15));

	}
	
	public static int decToBin(int decimal) {
		if(decimal == 0){
			return decimal;
		} else {
			return decimal % 2 + 10 * decToBin(decimal/2);
		}
	}

}
