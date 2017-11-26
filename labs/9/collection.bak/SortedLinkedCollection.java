//package collection;
import support.LLNode;
//import collection.Employee;

public class SortedLinkedCollection<Employee> extends LinkedCollection<Employee>{
	
//	protected LLNode<T> head;
//	protected int numElements = 0;
//
//	protected boolean found;
//	protected LLNode<T> location;
//	protected LLNode<T> previous;
//
//	public SortedLinkedCollection(){
//		numElements = 0;
//		head = null;
//	}
	
	public boolean add(Employee element){
         Employee nextEmployee = new Employee("foo", "1111");
//       Employee c = new Employee("foo","12");
//       System.out.println(c.id);
//       System.out.println(c.getID());
		LLNode<Employee> newNode = new LLNode<Employee>(element);
        if(numElements == 0){
            newNode.setLink(head);
            head = newNode;
        }
        else{
            location = head;
            while(location != null){
//                if (location.getInfo().id >= element.id){
                if (location.getInfo().getID() >= element.getID()){
                    newNode.setLink(location);
                    previous.setLink(newNode);
                    location = null;
                }
                else{ 
                    previous = location;
                    location = location.getLink(); 
                }
            }
		}
		numElements++;
		return true;
	}

//	public boolean contains (T target){
//		find(target);
//		return found;
//	}
//
//	public T get(T target){
//		find(target);
//		if (found)
//			return location.getInfo();
//		else
//			return null;
//	}
//
//	protected void find(T target){
//		location = head;
//		found = false;
//		while(location != null){
//			if ( location.getInfo().equals(target)){
//				found = true;
//				return;
//			}
//			else{
//				previous = location;
//				location = location.getLink();
//			}
//		}
//	}
//
//	public boolean remove(T target){
//		if (found){
//			if (head == location)
//				head = head.getLink();
//			else 
//				previous.setLink(location.getLink());
//			numElements--;
//		}
//		return found;
//	}
//		
//	public int size(){
//		return numElements;
//	}
//	
//	public boolean isEmpty(){
//		return (numElements == 0);
//	}
//	
//	public boolean isFull(){
//		return false;
//	}
}

