import java.util.*;

public class SortedLinkedCollection<Employee> extends LinkedCollection<Employee>{
	

	
	public boolean add(Employe<Employee> element){
		LLNode<Employe> newNode = new LLNode<Employe>(element);
        if(numElements == 0){
            newNode.setLink(head);
            head = newNode;
        }
        else if(Integer.parseInt(element.getID()) <= Integer.parseInt(head.getInfo().getID())){
            newNode.setLink(head);
            head = newNode;
        } 
        else{
            location = head.getLink();
            previous = head;
            while(location != null){
                if (Integer.parseInt(location.getInfo().getID()) >= Integer.parseInt(element.getID())){
                    newNode.setLink(location);
                    previous.setLink(newNode);
                    location = null;
                }
                else{ 
                    previous = location;
                    location = location.getLink(); 
                    if(location == null){
                        previous.setLink(newNode);
                        return true;
                    }
               }
            }
		}
		numElements++;
		return true;
	}

}

