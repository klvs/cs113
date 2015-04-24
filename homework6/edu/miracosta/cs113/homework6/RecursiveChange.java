package edu.miracosta.cs113.homework6;

import java.util.ArrayList;
import java.util.List;

public class RecursiveChange {
	static final int[] types = {25, 10, 5, 1};
	
	// initializer/wrapper 
	public static void change(int amount){
		makeChange(new ArrayList<Integer>(), 0, amount);
	}
	
	// main recursive method
	// typePos: the position that the program is in the the types array
	// coins: a list of coins that make up the change
	// valRemaning: value of change remaining
	public static void makeChange(List<Integer> coins, int typePos, int valRemaining){
		// base case
		if(valRemaining == 0){
			System.out.println(coins);
		// recursive case
		} else {
			// remaining value can be sub-divided
			if (valRemaining >= types[typePos]){
				coins.add(types[typePos]);
				makeChange(coins, typePos, valRemaining - types[typePos]);
				coins.remove(coins.size() -1);
			}
			// has not reached end of coin types
			if(typePos + 1 < types.length){
				makeChange(coins, typePos + 1, valRemaining);
			}
		}
	}
	
	public static void main(String args[]){
		change(16);
	}
}
