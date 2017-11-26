package queues;
import support.*;

public class LinkedQueue<T> implements QueueInterface<T>{
	protected LLNode<T> front;
	protected LLNode<T> rear;
	protected int numElements = 0;
	
	public LinkedQueue(){
		front = null;
		rear = null;
	}

	public void enqueue(T element){
		LLNode<T> newNode = new LLNode<T>(element);
		if (rear == null)
			front = newNode;
		else
			rear.setLink(newNode);
		rear = newNode;
		numElements++;
	}

	public T dequeue(){
		if (isEmpty()) throw new QueueUnderflowException("Dequeue attempted on empty queue.");
		else{
			T element;
			element = front.getInfo();
			front = front.getLink();
			if (front == null)
				rear = null;
			numElements--;
			return element;
		}
	}

 	public boolean isEmpty(){
                return (numElements == 0);
        }

    public boolean isFull(){
                return false;
        }

    public int size(){
                return numElements;
        }
}
