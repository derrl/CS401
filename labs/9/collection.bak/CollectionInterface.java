//package collection;

public interface CollectionInterface<Employee>{
	
	boolean add(Employee element);

	Employee get(Employee target);

	boolean contains(Employee target);

	boolean remove(Employee target);

	boolean isFull();

	boolean isEmpty();

	int size();
}
