
public class LinkedCollection<Employee> implements CollectionInterface<Employee>{
	
	public LLNode<Employe> head;
	public int numElements = 0;

	public boolean found;
	public LLNode<Employe> location;
	public LLNode<Employe> previous;

	public LinkedCollection(){
		numElements = 0;
		head = null;
	}
	
	public boolean add(Employe<Employee> element){
		LLNode<Employe> newNode = new LLNode<Employe>(element);
		newNode.setLink(head);
		head = newNode;
		numElements++;
		return true;
	}

	public boolean contains (Employe<Employee> target){
		find(target);
		return found;
	}

	public Employe<Employee> get(Employe<Employee> target){
		find(target);
		if (found)
			return location.getInfo();
		else
			return null;
	}

	protected void find(Employe<Employee> target){
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

	public boolean remove(Employe<Employee> target){
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
