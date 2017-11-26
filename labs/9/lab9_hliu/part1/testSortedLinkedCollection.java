import java.io.*;

public class testSortedLinkedCollection{
    
    SortedLinkedCollection<Employe> LLCollection = new SortedLinkedCollection<Employe>();
    private LLNode<Employe> temp_location;  

    public static void main(String[] args){
        testSortedLinkedCollection a = new testSortedLinkedCollection();
        a.go();        
    }
	
    void go(){
        System.out.println("Now we put employee into Linkedlist collection:");
        getEmployee();
        System.out.println();
        System.out.println("Check the sorted elements in the Linkedlist collection:");
        printLLC();
    }

    void printLLC(){
        temp_location = LLCollection.head;
        while(temp_location != null){
            System.out.print(temp_location.getInfo().id+"\t");      
            System.out.println(temp_location.getInfo().name);      
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
        Employe nextEmployee = new Employe(tokens[0], tokens[1]);
        LLCollection.add(nextEmployee);
        System.out.print(nextEmployee.getID() + "\t");
        System.out.println(nextEmployee.name);
    }
}
