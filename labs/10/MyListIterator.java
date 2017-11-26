import java.util.ListIterator;
import java.util.LinkedList;

public class MyListIterator 
{
    public static void main(String args[])
	{
        LinkedList<Integer> li = new LinkedList<Integer>();
        ListIterator<Integer> iter = null;
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
		list.remove(2);
        iter=list.listIterator();
        System.out.println("Print from beginning:");
		list.location = list.head;
		while(list.location != null)
		{
			System.out.println(list.location.getInfo());
			list.location = list.location.getForward();
		}
		if(list.contains(3))
			System.out.println("contains number 3.");
		else
			System.out.println("no number 3.");
//		print_from_beginning(iter);
		System.out.println();
        System.out.println("Print from end:");
//		print_from_end(iter);
    }
	
	public static void print_from_beginning(ListIterator a)
	{
        while(a.hasNext()){
            System.out.println(a.next());
        }
	}

	public static void print_from_end(ListIterator a)
	{
        while(a.hasPrevious()){
            System.out.println(a.previous());
        }
	}
}
