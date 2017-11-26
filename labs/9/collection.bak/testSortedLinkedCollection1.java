import java.io.*;
//import collection.LinkedCollection;
import support.*;

//public class testLinkedCollection extends LinkedCollection{
public class testSortedLinkedCollection1{
    
    LinkedCollection<Employee> LLCollection = new LinkedCollection<Employee>();
    private LLNode<Employee> temp_location;  

    public static void main(String[] args){
        testSortedLinkedCollection1 a = new testSortedLinkedCollection1();
        a.go();        
    }
	
    void go(){
        System.out.println();
        getEmployee();
        System.out.println();
        printLLC();
    }

    void printLLC(){
        temp_location = LLCollection.head;
        while(temp_location != null){
            System.out.println(temp_location.getInfo());      
            temp_location = temp_location.getLink();
        }
    }

    void getEmployee(){
        try{
            File file = new File("emp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null){
                addEmployee(line);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    void addEmployee(String lineToParse){
        String[] tokens = lineToParse.split(" ");
        Employee nextEmployee = new Employee(tokens[0], tokens[1]);
        LLCollection.add(nextEmployee);
        System.out.print(nextEmployee.name + " ");
        System.out.println(nextEmployee.getID());
    }
}
