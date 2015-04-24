//package edu.miracosta.cs113.hw2;
//
//public class ComputeAreaAndPerimeter {
//	
//	public static void main(String args[]){
//		Shape myShape;
//		double perimeter;
//		double area;
//		myShape = getShape();
//		myShape.readShapeData();
//		perimeter = myShape.computePerimeter();
//		area = myShape.computerArea();
//		displayResult(myShape, area, perimeter);
//		System.exit(0);
//	}
//
//	public static Shape getShape() {
//		Scanner in = new Scanner(System.in);
//		System.out.println("Enter C for circle");
//		System.out.println("Enter R for rectangle");
//		System.out.println("Enter T for Right Triangle");
//		System.out.println("Enter E for Equilateral Triangle");
//		System.out.println("Enter S for Square");
//
//		String figType = in.next();
//		switch (figType) {
//			case "C":
//				return new Circle();
//			case "R":
//				return new Rectangle();
//			case "T":
//				return new RtTriangle();
//			case "E":
//				return new EqTrianlge();
//			case "S":
//				return new Square();
//			default:
//				return null;
//		}
//	}
//
//	private static void siplayResult(Shape myShape, double area, double perim) {
//		System.out.println(myShape);
//		System.out.printf("The area is %.2f%nThe perimeter is %.2f%n", area, perim);
//	}
//}
