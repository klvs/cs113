//package edu.miracosta.cs113.lab3;
//import java.util.ArrayList;
//
//public class Main {
//	public static void main(String[] args) {
//		ArrayList<String> al = new ArrayList();
//		al.add("C");
//	    al.add("A");
//	    al.add("E");
//	    al.add("F");
//	    al.add("D");
//	    al.add("F");
//	    
//	    System.out.println(al);
//	    replace(al, "F", "G");
//	    System.out.println(al);
//
//	}
//	// pg 69 problem 1
//	public static void replace(ArrayList<String> alist, String oldItem, String newItem){
//		while(alist.indexOf(oldItem) != -1){
//			alist.set(alist.indexOf(oldItem), newItem);
//		}
//	}
//	// pg 69 problem 2
//	public static void delete(ArrayList<String> alist, String target){
//		alist.remove(target);
//	}
//	
//	// pg 71 problem 1
//	public String addOrChangeEntry(String aName, String newNumber){
//		boolean found = false;
//		for(DirectoryEntry entry: theDirectory){
//			if(entry.getName() == aName){
//				entry.setNumber(newNumber);
//			}
//		}
//		if(!found){
//			theDirectory.add(new DirectoryEntry(aName, newNumber));
//			return null;
//		} else{
//			return newNumber;
//		}
//	}
//	
//	// pg 71 problem 2
//	public DirectoryEntry removeEntry(String aName){
//		theDirectory.remove(theDirectory.indexOf(new DirectoryEntry(aName, "")));
//	}
//	
//	// pg 77 problem 1
//	public int indexOf(E entry){
//		int index = 0;
//		for(E datum: theData){
//			if(datum.equals(entry)){
//				return index;
//			}
//			index++;
//		}
//		return -1;
//	}
//	// pg 77 problem 2
//	public KWArrayList<E>(int capacity) {
//		this.capacity = capacity;
//		theData = (E[]) Object[capacity];
//	}
//}
