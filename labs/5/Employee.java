import java.util.*;
import java.lang.*;

public class Employee {
	private String id;
	private String name;

	public Employee(String name,String id){
		setEmployee(name, id);
	}


	public void setEmployee(String name,String id){
		this.name = name;
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public String getID(){
		return id;
	}
	
	public String toString(){
		return name + " " + id;
	}
}
