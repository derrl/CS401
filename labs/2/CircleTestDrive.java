import java.io.*;
import java.util.*;

public class CircleTestDrive {
	public static void main (String args[]) {
		double area;
		Circle a = new Circle();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		    System.out.print("Enter radius of a circle: \n");
		    String r = reader.readLine();
		    area = a.calculateArea(r);
		    System.out.println("Area of a circle is: \n" + area);
		}
		catch (IOException e) {
			System.out.println("IOEception " + e);
		}
	}
}