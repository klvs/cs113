package edu.miracosta.cs113.lab1;

public class Main {
	 public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        System.out.println(powerOfTwo(64));
	        System.out.println(powerOfTwo(63));
	        System.out.println(powerOfTwo(8));
	        System.out.println(powerOfTwo(0));
	        fizzBuzz(9);
	        fizzBuzz(15);
	        fizzBuzz(10);
	       
	}

	
	public static boolean powerOfTwo(int x){
	        // zero is not a power of two
	        if(x == 0)
	                return false;
	        // neg nums will fail next condition so take abs val
	        // check if greater than 1 and if even
	        while(Math.abs(x) > 1 && x%2 == 0){
	                x = x/2;
	        }
	       
	        if(x == 1)
	                return true;
	        else
	                return false;
	}
	
	public static void fizzBuzz(int i){
	        if(i%3 == 0 && i%5 == 0){
	                System.out.println("FizzBuzz");
	                return;
	        }
	        if(i%3 == 0){
	                System.out.println("Fizz");
	                return;
	        }
	        if(i%5 == 0){
	                System.out.println("Buzz");
	                return;
	        } else
	                return;
	}
}
