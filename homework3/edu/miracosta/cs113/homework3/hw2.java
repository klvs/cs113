package edu.miracosta.cs113.homework3;
import java.util.ArrayList;
import java.util.Scanner;

public class hw2 {
	
	public static void main(String args[]){
		Course course = new Course();
		Scanner sc = new Scanner(System.in);
		System.out.println("Options add[end beg], rm[beg end name] ");

		String name;
		String cont = "y";
		
		while(cont.equals("y")){
			System.out.println("Enter an option: ");
			String option = sc.nextLine().toLowerCase();
			switch(option){
				case "add end":
					System.out.println("Enter name: ");
					name = sc.nextLine().toUpperCase();
					course.addToEnd(name);
					break;
				case "add beg":
					System.out.println("Enter name: ");
					name = sc.nextLine().toUpperCase();
					course.addToBeginning(name);
					break;
				case "rm beg":
					course.removeFromBeginning();
					break;
				case "rm end":
					course.removeFromEnd();
					break;
				case "rm name":
					System.out.println("Enter name: ");
					name = sc.nextLine().toUpperCase();
					course.removeByName(name);
					break;
			}
			
			course.listStudents();
			System.out.println("Continue [y/n]");
			cont = sc.nextLine().toLowerCase();
		}

		
		
			
	}
}

class Course{
	public ArrayList<String> students = new ArrayList<String>();
	
	public Course(){
	}
	
	public void addToEnd(String student){
		students.add(student.toUpperCase());
	}
	
	public void addToBeginning(String student){
		students.add(0, student.toUpperCase());
	}
	
	public void removeByName(String student){
		students.remove(student.toUpperCase());
	}
	
	public void removeFromEnd(){
		students.remove(students.size() -1);
	}
	
	public void removeFromBeginning(){
		students.remove(0);
	}
	
	public void listStudents(){
		for(String student: students){
			System.out.println(student);
		}
	}
	
}