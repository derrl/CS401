class Employee implements Comparable<Employee> {
	String name;
	String id;

	public int compareTo(Employee s) {
		return this.id.compareTo(s.getID());
	}

	Employee(String n, String i) {
		name = n;
		id = i;
	}

	public String getName() {
		return name;
	}

	public String getID() {
		return id;
	}

	public String toString() {
		return name + " " + id;
	}
}