import java.util.*;

public class CalculateArea {
	public static void main (String args[]) {
		double area;
		Circle a = new Circle();
	    System.out.print("Enter radius of a circle: \n");
		Scanner s = new Scanner(System.in); // scan input
		String	r = s.nextLine();	//set input number to radius
	    area=a.calculateArea(r);	//calculate area of the circle 
	    System.out.println("Area of the circle is: \n" + area);	//output calculation outcome
		
	}
}
