package queues;

public class ArrayUnboundedQueue<T> implements QueueInterface<T>{
	protected final int DEFCAP = 100;
	protected T[] elements;
	protected int origCap;
	protected int numElements = 0;
	protected int front = 0;
	protected int rear;

	public ArrayUnboundedQueue(){
		elements = (T[]) new Object[DEFCAP];
		rear = DEFCAP - 1;
		origCap = DEFCAP;
	}

	public ArrayUnboundedQueue(int origCap){
		elements = (T[]) new Object[DEFCAP];
		rear = origCap - 1;
		this.origCap = origCap;
	}
	
	private void enlarge(){
		T[] larger = (T[]) new Object[elements.length + origCap];

		int currSmaller = front;
		for(int currLarger = 0; currLarger < numElements; currLarger++){
			larger[currLarger] = elements[currSmaller];
			currSmaller = (currSmaller + 1) % elements.length;
		}

		elements =larger;
		front = 0;
		rear = numElements - 1;
	}
	
	public void enqueue(T element){
		if (numElements == elements.length)
			enlarge();
		rear = (rear + 1) % elements.length;
		elements[rear] = element;
		numElements = numElements + 1;
	}
	
	public T dequeue(){
		if (isEmpty()) throw new QueueUnderflowException("Dequeue attempted on empty queue.");
		else{
			T toReturn = elements[front];
			elements[front] = null;
			front = (front + 1) % elements.length;
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
