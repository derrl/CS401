import java.io.*;
import collection.LinkedCollection;
//import support.*;

//public class testLinkedCollection extends LinkedCollection{
public class testLinkedCollection{
    
    LinkedCollection<Employee> LLCollection = new LinkedCollection<Employee>();

    public static void main(String[] args){
        testLinkedCollection a = new testLinkedCollection();
        a.go();        
    }
	
    void go(){
        System.out.println();
        getEmployee();
    }

//    public boolean add(Employee element){
//        LLNode<T> newNode = new LLNode<T>(element);
//        if(numElements == 0){
//            newNode.setLink(head);
//            head = newNode;
//        }
//        else{
//            location = head;
//            while(location != null){
//                if (location.getInfo().id >= element.id){
////                if (location.getInfo().getID() >= element.getID()){
//                    newNode.setLink(location);
//                    previous.setLink(newNode);
//                    location = null;
//                }
//                else{
//                    previous = location;
//                    location = location.getLink();
//                }
//            }
//        }
//    }

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
//        System.out.println(nextEmployee.id);
//        System.out.println(nextEmployee.getID());
    }
}
