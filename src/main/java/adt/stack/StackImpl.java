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
		if (isEmpty())
			throw new RuntimeException("Pilha vazia");
		return array[top];
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
			throw new RuntimeException("Pilha cheia!");
		array[top++] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) 
			throw new RuntimeException("Não há elemento para ser removido");
		T element = array[top];
		top--;
		return element;
	}

}
