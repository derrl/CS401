import java.io.*;

public class testCS401ArrayImpl{
    
    CS401ArrayImpl<Employe> LLCollection = new CS401ArrayImpl<Employe>();

    public static void main(String[] args){
        testCS401ArrayImpl a = new testCS401ArrayImpl();
        a.go();        
    }
	
    void go(){
        System.out.println();
        getEmployee();
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
        System.out.print(nextEmployee.name+ " ");
        System.out.println(nextEmployee.getID());
    }
}
