public interface CollectionInterface<Employee>{
	
	boolean add(Employe<Employee> element);

	Employe<Employee> get(Employe<Employee> target);

	boolean contains(Employe<Employee> target);

	boolean remove(Employe<Employee> target);

	boolean isFull();                       

	boolean isEmpty();

	int size();
}
