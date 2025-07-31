package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T topo = null;
		if (!(isEmpty()))
			topo = array[top];
		return topo;
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return this.top + 1 == array.length;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull())
			throw new StackOverflowException();
		array[++top] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) 
			throw new StackUnderflowException();
		T element = array[top];
		top--;
		return element;
	}

}
