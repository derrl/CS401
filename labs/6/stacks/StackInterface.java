package stacks;

public interface StackInterface<T>
{
	void push(T element) throws StackOverflowException;

	void pop() throws StackUnderflowException;

	T peek() throws StackUnderflowException;

	boolean isFull();

	boolean isEmpty();
}
