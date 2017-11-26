package collection;
import support.LLNode;

public class SortedLinkedCollection<T> implements CollectionInterface<T>{
	
	protected LLNode<T> head;
	protected int numElements = 0;

	protected boolean found;
	protected LLNode<T> location;
	protected LLNode<T> previous;

	public SortedLinkedCollection(){
		numElements = 0;
		head = null;
	}
	
    public boolean add(T element){
      	LLNode<T> newNode = new LLNode<T>(element);
        if(numElements == 0){
            newNode.setLink(head);
            head = newNode;
        }
        else{
            location = head;
            while(location != null){
                if (bigger(location.getInfo(), element)){
//                  if (location.getInfo().ID >= element.ID){
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


   public boolean bigger(Employee a, Employee b){
      return (a.id>=b.id);
  }

	public boolean contains (T target){
		find(target);
		return found;
	}

	public T get(T target){
		find(target);
		if (found)
			return location.getInfo();
		else
			return null;
	}

	protected void find(T target){
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

	public boolean remove(T target){
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

