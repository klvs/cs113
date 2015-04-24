package edu.miracosta.cs113.hw1;
import edu.miracosta.cs113.theory.Theory;

public class Clue {

    /**
     * @param args
     */
    public static void main(String[] args) {
    	theoryChecker3();
    }
    
    
    /**
     * This method brute forces the guess
     */        
    public static void theoryChecker3()
    {
        int[][] combinations = combinationGen();
        for(int[] combo: combinations){
        	int solution = Theory.theoryTest3(combo[0],combo[1], combo[2]);
        	// System.out.println(solution);
        	if(solution == 0){
        		System.out.println("Solution is " + combo[0] + " " + combo[1] + " " + combo[2]);
        	}
        }
        Theory.checkTheory();
        
//        for(int[] combo: combinations){
//        	System.out.println(combo[0] + " " + combo[1] + " " + combo[2]);
//        }
    }
    
    public static int[][] combinationGen(){
    	int[] murder = {1,2,3,4,5,6};
    	int[] location = {1,2,3,4,5,6,7,8,9,10};
    	int[] weapon = {1,2,3,4,5,6};
    	int[][] combinations = new int[360][3];
    	
    	int i = 0;
    	for(int l =0; l < location.length; l++){
    		for(int m =0; m < murder.length; m++){
    			for(int w =0; w < weapon.length; w++){
    				combinations[i][0] = murder[m];
    				combinations[i][1] = location[l];
    				
    				combinations[i][2] = weapon[w];
    				i++;
    			}
    		}
    		
    	}

    	
    	return combinations;
    }

} 
