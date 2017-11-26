//package collection;
import support.LLNode;
//import collection.Employee;

public class LinkedCollection<Employee> implements CollectionInterface<Employee>{
	
	protected LLNode<Employee> head;
	protected int numElements = 0;

	protected boolean found;
	protected LLNode<Employee> location;
	protected LLNode<Employee> previous;

	public LinkedCollection(){
		numElements = 0;
		head = null;
	}
	
	public boolean add(Employee element){
//        String a="11";
 //       Employee<String> nextEmployee = new Employee<String>(a, a);
		LLNode<Employee> newNode = new LLNode<Employee>(element);
		newNode.setLink(head);
		head = newNode;
		numElements++;
		return true;
	}

	public boolean contains (Employee target){
		find(target);
		return found;
	}

	public Employee get(Employee target){
		find(target);
		if (found)
			return location.getInfo();
		else
			return null;
	}

	protected void find(Employee target){
		location = head;
		found = false;
		while(location != null){
			if ( location.getInfo().equals(target)){
				found = true;
				return;
			}
			else{
				previous = location;
				location = location.getLink();
			}
		}
	}

	public boolean remove(Employee target){
		if (found){
			if (head == location)
				head = head.getLink();
			else 
				previous.setLink(location.getLink());
			numElements--;
		}
		return found;
	}
		
	public int size(){
		return numElements;
	}
	
	public boolean isEmpty(){
		return (numElements == 0);
	}
	
	public boolean isFull(){
		return false;
	}
}
