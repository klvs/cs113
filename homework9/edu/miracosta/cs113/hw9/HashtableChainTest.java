package edu.miracosta.cs113.hw9;

import java.util.Map.Entry;
import java.util.Set;



public class HashtableChainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashtableChain<String, Integer> t = new HashtableChain<String, Integer>();
		
//		t.put("test", new Integer(1));
//		t.put("hur", new Integer(8));
//		t.put("dur", new Integer(1));

		System.out.println(t.toString());
		
		String content = "This was pretty disappointing, to say the least, to those who brought her in to Nebolon's office, myself included, more than once. The disappointment was her";
		String[] words = content.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		
		
		for(String s: words){
			Integer n = t.get(s);
			if(n == null){
				n = 1;
			} else {
				n += 1;
			}
			t.put(s, n);
		} 

		Set<Entry<String, Integer>> set = t.entrySet();
		
		System.out.println(set);
	}

}
