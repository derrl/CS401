import support.*;

public class doublyLinkedList<E> implements DLLInterface<E>
{
	public DLLNode<E> head;
	public int numElements = 0;

	public boolean found;
	public DLLNode<E> location;

	public doublyLinkedList()
	{
		head = null;
		numElements = 0;
	}

	public boolean add(E e)
	{
		DLLNode<E> newNode = new DLLNode<E>(e);
		if(isEmpty())
			head = newNode;	
		else
		{
			newNode.setForward(head);
			head.setBack(newNode);
			head = newNode;
		}
		numElements++;
		return true;	
	}

	public E remove(int i)
	{
		if(isEmpty())
		{
			System.out.println("Error! Remove in an empty list.");
			return null;
		}

		if(i > numElements - 1)
		{
			System.out.println("Error! index number is bigger than the list size.");
			return null;
		}

		location = head;
		if(i == 0)
		{
			if(numElements == 1)
				head = head.getForward();
			else 
			{
				head = head.getForward();
				head.getForward().setBack(null);
			}
		}
		else if(i == numElements - 1)
		{
			for(int n = 0; n < i; n++)
				location = location.getForward();
			location.getBack().setForward(null);
			location.setBack(null);
		}
		else 
		{
			for(int n = 0; n < i; n++)
				location = location.getForward();
			location.getForward().setBack(location.getBack());
			location.getBack().setForward(location.getForward());
			location.setBack(null);
			location.setForward(null);
		}
		return location.getInfo();
	}

	public boolean contains (E e)
	{
        location = head;
        found = false;
        while(location != null){
            if (location.getInfo().equals(e)){
                found = true;
                return true;
            }
            else
                location = location.getForward();
        }
		return found;	
	}

	public boolean add(Where where, E e)
	{
		DLLNode<E> newNode = new DLLNode<E>(e);
		location = head;

		if(isEmpty())
			head = newNode;	
		else if (where == Where.BACK)
		{
			for(int n = 0; n < numElements - 1; n++)
				location = location.getForward();
			newNode.setBack(location);
			location.setForward(newNode);
		}
		else if (where == Where.FRONT)
		{
			head.setBack(newNode);
			newNode.setForward(head);
			head = newNode;
		}
		else if (where == Where.MIDDLE)
		{
			for(int n = 0; n < numElements/2; n++)
				location = location.getForward();
			newNode.setBack(location.getBack());
			newNode.setForward(location);
			location.getBack().setForward(newNode);
			location.setBack(newNode);
		}
		return true;	
	}

	public boolean add(Where where, int index, E e)
	{
		DLLNode<E> newNode = new DLLNode<E>(e);
		location = head;

		if(index > numElements - 1)
		{
			System.out.println("Error! index number is bigger than the list size.");
			return false;
		}

		if(isEmpty())
			head = newNode;	
		else if (where == Where.BACK)
		{
			for(int n = 0; n < index; n++)
				location = location.getForward();
			newNode.setBack(location);
			location.setForward(newNode);
		}
		else if (where == Where.FRONT)
		{
			head.setBack(newNode);
			newNode.setForward(head);
			head = newNode;
		}
		else if (where == Where.MIDDLE)
		{
			for(int n = 0; n < index; n++)
				location = location.getForward();
			newNode.setBack(location.getBack());
			newNode.setForward(location);
			location.getBack().setForward(newNode);
			location.setBack(newNode);
		}

		return true;	
	}

	public int size()
	{
		return numElements;
	}
	
	public boolean isEmpty()
	{
		return(numElements == 0);
	}

	public enum Where{ FRONT, BACK, MIDDLE}
}
