package cs113_Roman_Alexander;

public class Main {
	public static void main(String args[]){
		KWLinkedList<String> list = new KWLinkedList<String>();
		list.add("a");
		list.add("d");
		list.add("b");
		list.add("c");
		
		
		
		

		
		
		System.out.println(list.indexOf("b"));
		System.out.println(list.indexOfMin());
//		System.out.println("abc".compareTo("ab"));
	}
}
