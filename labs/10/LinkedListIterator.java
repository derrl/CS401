import java.util.*;
import support.*;

public class LinkedListIterator<E> implements LLIteratorInterface<E>
{
	return new LinkedListIterator<E>()
	{
		public doublyLinkedList<E> a;
		public DLLNode<E> cursor;
		public DLLNode<E> head;
		private int index = 0;
	
		
		public LinkedListIterator()
		{
			cursor.setForward(head);
			cursor.setBack(null);
		}
	
		public void add(E e){;	
		}
		
	
		public boolean hasNext()
		{
			return (cursor.getForward() != null);
		}
	
		public boolean hasPrevious()
		{
			return (cursor.getBack() != null);
		}
	
		public E next()
		{
			if(hasNext())
			{
				a = cursor.getForward().getInfo();
				cursor.setBack(cursor.getForward());
				cursor.setForward(cursor.getForward().getForward());
				index++;
			}
			else 
			{
				System.out.println("Error! Has not next one.");
				a = null;
			}
			return a;
		}
		
		public  int nextIndex()
		{
			return index;
		}
	
		public E previous()
		{
			if(hasPrevious())
			{
				a = cursor.getBack().getInfo();
				cursor.setForward(cursor.getBack());
				cursor.setBack(cursor.getBack().getBack());
				index--;
			}
			else
			{
				System.out.println("Error! Has not previous one.");
				a = null;
			}
			return a;
		}
		
		public  int previousIndex()
		{
			return index - 1;
		}
	
		public void remove(){;
		}
	
		public void set(E e){;
		}
		
		public void print_from_beginning()
		{
			cursor.setForward(head);
			cursor.setBack(null);
			while(hasNext())
			{
				System.out.println(next());
			}
			System.out.println();
		}
	
		public void print_from_end()
		{
			while(!hasNext())
			{
				cursor.setBack(cursor.getForward());
				cursor.setForward(cursor.getForward().getForward());
			}
			while(hasPrevious())
			{
				System.out.println(previous());
			}
			System.out.println();
		}
	}
}
