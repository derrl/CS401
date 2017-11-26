import java.util.*;
import java.io.*;

public class testStack{
	
	Stack<Employee> stackList = new Stack<Employee>();

	public static void main(String arg[]){
		testStack b = new testStack();
		System.out.println();
		System.out.println("Now we push data into stack:");
		b.getEmployee();
		System.out.println();
		System.out.println("The top element from stack:");
		System.out.println(b.stackList.peek());
		System.out.println();
		System.out.println("And then we pop two items from stack.");
		b.stackList.pop();
		b.stackList.pop();
		System.out.println("Peek again to check the top element from stack:");
		System.out.println(b.stackList.peek());
		System.out.println();
	}	

    void getEmployee() {
        try {
            File file = new File("emp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null) {
                addEmployee(line);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void addEmployee(String lineToParse) {
        String[] tokens = lineToParse.split(" ");
        Employee nextEmployee = new Employee(tokens[0], tokens[1]);
		System.out.println(stackList.push(nextEmployee));
    }
}
