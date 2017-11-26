import java.io.*;
import queues.*;

public class testLinkedQueue{
	
	LinkedQueue<Employee> LLQueueList = new LinkedQueue<Employee>();

	public static void main(String arg[]){
		testQueue b = new testQueue();
		b.go();
	}	

	void go(){
		System.out.println();
		System.out.println("Now we enqueue data:");
		getEmployee();
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
	    	LLQueueList.enqueue(nextEmployee);
	    	//System.out.println(LLQueueList.push(nextEmployee));
	    	System.out.println(nextEmployee);
	}
}
