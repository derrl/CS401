public class Circle { //define circle class
	double radius;	//set instance variable radius
	public double calculateArea(String b) {
		setRadius(b);
		return (radius* radius * 3.14);	//calculate the circle area
	}

	void setRadius (String b) {	//set radius
		radius = Double.parseDouble(b); 	//convert string to double
	}

	double getRadius() {	//get radius from circle
		return radius;
	}
}
