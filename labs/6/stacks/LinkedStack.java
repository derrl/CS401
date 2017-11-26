package stacks;
import support.LLNode;

public class LinkedStack<T> implements StackInterface<T>{
	protected LLNode<T> top;
	private int size=0;

	public LinkedStack(){
		top = null;
	}

	public void push(T element){
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(top);
		top = newNode;
		size++;
	}
//		public T pop(){
//		if (isEmpty())
//			throw new StackUnderflowException("Pop a attempted on an empty stack.");
//		else{
//			T obj;
//			obj = peek();
//			top = top.getLink();
//			size--;
//		return obj;
//		}
//	}


	public void pop(){
		if (isEmpty())
			throw new StackUnderflowException("Pop a attempted on an empty stack.");
		else{
			top = top.getLink();
			size--;
		}
	}

	public T peek(){
		if (isEmpty())
			throw new StackUnderflowException("Peek a attempted on an empty stack.");
		else
			return top.getInfo();
	}
	
	public boolean isEmpty(){
		return (top == null);
	}

	public boolean isFull(){
		return false;
	}
	
	public int getSize(){
		return size;
	}

}

