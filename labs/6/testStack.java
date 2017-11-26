import java.io.*;
import stacks.LinkedStack;

public class testStack{
	
	LinkedStack<Employee> LLStackList = new LinkedStack<Employee>();

	public static void main(String arg[]){
		testStack b = new testStack();
		b.go();
	}	
	void go(){
		System.out.println();
		System.out.println("Now we push data into stack:");
		getEmployee();
		System.out.println();
		System.out.println("The top element from stack:");
		System.out.println(LLStackList.peek());
		System.out.println();
		System.out.println("And then we pop two items from stack.");
		LLStackList.pop();
		LLStackList.pop();
		System.out.println("Peek again to check the top element from stack:");
		System.out.println(LLStackList.peek());
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
	    	LLStackList.push(nextEmployee);
	    	//System.out.println(LLStackList.push(nextEmployee));
	    	System.out.println(nextEmployee);
	}
}
