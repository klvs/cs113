package edu.miracosta.cs113.homework3;
import java.util.ArrayList;

 class Term implements Comparable<Term> {
	public Term(int coeff, int degree){
		this.coeff = coeff;
		this.degree = degree;
	}
	public int coeff;
	public int degree;
	public int compareTo(Term compTerm){
		if(compTerm.degree > this.degree){
			return -1;
		} else if(compTerm.degree < this.degree){
			return 1;
		} else{
			System.out.println(compTerm.degree + "=" + this.degree);
			System.out.println(compTerm.coeff + "+" + this.coeff);
			return 0;
		}
	}
}

class Polynomial {
	private ArrayList<Term> terms = new ArrayList<Term>();
	public String stringRepresentation;
	
	// in: "0 + x + 3x^2 + 4x^3" 
	public Polynomial(String S){
		this.stringRepresentation = S;
		String[] rawStr = S.split("\\+");

		for(int i=0; i <= rawStr.length - 1; i++){
			rawStr[i] = rawStr[i].replaceAll("\\s+","");
		}
		
		for(int i=0; i <= rawStr.length - 1; i++){
			int indexOfX = rawStr[i].indexOf('x');
			int indexOfDeg = rawStr[i].indexOf('^'); // index of degree indicator
			int degree = 0;
			int coeff = 0;
			if(indexOfDeg > 0){ // if degree indicator exists
				degree = Integer.parseInt(rawStr[i].substring(indexOfDeg + 1, rawStr[i].length() ));
			}
			if(indexOfX < 0){
				// no coef
				degree = 0;
			} else if(indexOfX == 0){
				degree = 1;
				coeff = 1;
			} else {
				coeff = Integer.parseInt(rawStr[i].substring(0, indexOfX));
			}
			terms.add(new Term(coeff, degree));

		}
//		for(Term t: terms){
//			System.out.println("c " + t.coeff + " || " + "d " + t.degree);
//		}

	}
	
	public String toString(){
		// string rep != null
		if(this.stringRepresentation == null){
			this.stringRepresentation = "";
			for(Term t: terms){
				if(t.degree == 0){
					stringRepresentation += Integer.toString(t.coeff);
				}else if(t.degree >= 1){
					stringRepresentation += Integer.toString(t.coeff) + "x^" + Integer.toString(t.degree); 
				}
				stringRepresentation += " + ";
			}
		}
		
		return this.stringRepresentation;
	}
	
	public Polynomial add(Polynomial poly2){
		Polynomial poly1 = this;
		for(Term s: poly1.terms){
			for(Term t: poly2.terms){
				int comp = s.compareTo(t);
				System.out.println("comparison:" + comp);

				if(comp == 0){
					int termVal = s.coeff + t.coeff;

					System.out.println("summed coeffs: " + termVal);
				}

			}
		}
		
		return new Polynomial("0");
	}
	
}
public class Main {
	public static void main(String args[]){
		Polynomial testVar = new Polynomial("0 + x + 3x^2 + 2x^4");
		Polynomial poly2 = new Polynomial("1 + x + 8x^3");
		testVar.add(poly2);
		
//		Term term1 = new Term(1, 2);
//		Term term2 = new Term(1, 2);
//		System.out.println(term1.compareTo(term2));
//		System.out.println(testVar);
	}
}

