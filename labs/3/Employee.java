import java.util.*;
import java.lang.*;
 
public class Employee implements Comparable<Employee>,Comparator<Employee> { //Create Employee class and use Comparable, Comparator interfaces.
    String name; 
    String id;
    int identity;
 
    public int compareTo(Employee another) {
    	return (this.name).compareTo(another.name);
    }
    
    public int compare(Employee one, Employee another) {
    	return one.identity - another.identity;
    }

    public void setRecord (String name, int identity) {
        this.name = name;
        this.identity = identity;
    }
 
    public String toString(int s) {
        return Integer.toString(s);
    }
  
    public void getInput() {
        System.out.print("Please input a name: ");
        Scanner first = new Scanner(System.in);
        name = first.nextLine();
        System.out.println("Please input a ID: ");
        Scanner second = new Scanner(System.in);
        identity = second.nextInt();
    }
 
    public static void main(String args[]) {
        ArrayList<Employee> L = new ArrayList<Employee>();  //Use an ArrayList to save Employee information.

        for (int i = 0; i < 2; i++) {
            Employee e = new Employee();
            L.add(e);
            e.getInput();
            e.setRecord(e.name, e.identity);
            e.id = e.toString(e.identity);
        }

        if (L.get(0).name.compareTo(L.get(1).name)==0) {	//Compare Employee records based on names.
            System.out.println("They have the same name.");
            if (L.get(0).id.equals(L.get(1).id)) {		//Compare Employee records based on IDs.
                System.out.println("And ID number is same. They are same employee.");
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
