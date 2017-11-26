public class Employe<Employee> {
    String id;
	String name;

	public Employe(String name,String id){
		setEmployee(name, id);
	}

    public Employe() {
          this.id = id;
          this.name = name;
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
