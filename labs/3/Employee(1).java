import java.util.*;
import java.lang.*;

public class Employee {
	String name; 
	String id;
	int identity;

	public void setRecord (String name, int identity) {
		this.name = name;
		this.identity = identity;
	}

	public String toString(int s) {
		return Integer.toString(s);
	}

	public void getInput() {
		System.out.print("Please insert a name: ");
		Scanner first = new Scanner(System.in);
		name = first.nextLine();
		System.out.println("Please insert a ID: ");
		Scanner second = new Scanner(System.in);
		identity = second.nextInt();
	}

	public static void main(String args[]) {
		ArrayList<Employee> L = new ArrayList<Employee>();
		for (int i = 0; i < 2; i++) {
			Employee e = new Employee();
			L.add(e);
			e.getInput();
			e.setRecord(e.name, e.identity);
			e.id = e.toString(e.identity);
		}
		if (L.get(0).name.equals(L.get(1).name)) {
			System.out.println("They have the same Employee.");
			if (L.get(0).id.equals(L.get(1).id)) {
				System.out.println("And ID number. They are same employee.");
			}
			else {
				System.out.println("But they are different employee.");
			}
		}
		else {
			System.out.println("They are different employee.");
		}
	}
}