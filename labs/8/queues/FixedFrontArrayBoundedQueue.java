package queues;

public class FixedFrontArrayBoundedQueue<T> implements QueueInterface<T>{
	protected final int DEFCAP = 100;
	protected T[] elements;
	protected int numElements = 0;
	protected int front = 0;
	protected int rear = -1;

	public FixedFrontArrayBoundedQueue(){
		elements = (T[]) new Object[DEFCAP];
//		rear = DEFCAP - 1;
	}
	
	public FixedFrontArrayBoundedQueue(int maxSize){
		elements = (T[]) new Object[maxSize];
//		rear = maxSize - 1;
	}
	
	public void enqueue(T element){
		if (isFull()) throw new QueueOverflowException("Enqueue attempted on a full queue.");
		else{
			rear = rear + 1;
			elements[rear] = element;
			numElements = numElements + 1;
		}
	}

	public T dequeue(){
		if (isEmpty()) throw new QueueUnderflowException("Dequeue attempted on empty queue.");
		else{
			T toReturn = elements[front];
			for (int i = 0; i < rear ; i++)
				elements[i] = elements[i+1];
			elements[rear] = null;
			rear = rear - 1;
			numElements = numElements - 1;
			return toReturn;
		}
	}
	
	public boolean isEmpty(){
		return (numElements == 0);
	}
	
	public boolean isFull(){
		return (numElements == elements.length);
	}

	public int size(){
		return numElements;
	}
}
