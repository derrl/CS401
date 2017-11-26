import java.util.*;
import java.io.*;

public class BubbleSort {

	ArrayList<Employee> employeeList = new ArrayList<Employee>();

	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		bs.runBubbleSort();
	}

	public void runBubbleSort() {
		double start, end;
		getEmployee();
//		System.out.println(employeeList);
	start = System.currentTimeMillis();
//		Collections.sort(employeeList);
		sort(employeeList);
	end = System.currentTimeMillis() - start;
		writeInFile();
		for(int i = 0; i < employeeList.size(); i++) 
			System.out.println(employeeList.get(i));
//		System.out.println(employeeList.get(0).id);
		System.out.println("Running time is " + end + "ms");
	}


	void sort(ArrayList<Employee> qqq){
		int n,i;
		Employee c = new Employee(null, null);
		for(n = 1; n <= qqq.size() - 1; n++) {
			for(i = 0; i <= qqq.size() - n - 1; i++) {
//				long a = Long.parseLong(qqq.get(i+1).id, 10);
//				long b = Long.parseLong(qqq.get(i+1).id, 10);
				if(Long.parseLong(qqq.get(i).id, 10) > Long.parseLong(qqq.get(i+1).id, 10)) {
					c = qqq.get(i);
					qqq.set(i, qqq.get(i+1));
					qqq.set(i+1, c);
				}
			}
		}
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
		employeeList.add(nextEmployee);
	}

	void writeInFile() {
		String[] output = new String[employeeList.size()];
		for (int i = 0; i < employeeList.size(); i++) {
			try {
				output[i] = employeeList.get(i).toString();
			}
			catch (NullPointerException e) {
				e.printStackTrace();
			}
		}

		try {
			File file = new File("sorted_emp.txt");
			FileOutputStream fos = new FileOutputStream(file);

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

			for (String str: output) {
				writer.write(str);
				writer.newLine();
			}
			writer.close();
		}
		catch (Exception a) {
			a.printStackTrace();
		}
	}
}


