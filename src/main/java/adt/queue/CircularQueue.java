package adt.queue;

import static org.junit.Assert.fail;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
	}

	@Override
	
	public void enqueue(T element) throws QueueOverflowException {
   		if (isFull()) {
       		throw new QueueOverflowException();
    	} else if (isEmpty()) {
        	head = 0;
        	tail = 0;
    	} else {
        	tail = (tail + 1) % array.length;
    	}
    	array[tail] = element;
}


	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException();
		T element = array[head];
		if (head + 1 == array.length) {
			head = 0;
		} else if (head == tail) {
			head = -1;
			tail = -1;
		} else {
			head++;
		}
		return element;
	}

	@Override
	public T head() {
		T header = null;
		if (!(isEmpty()))
			header = array[head];
		return header;
	}

	@Override
	public boolean isEmpty() {
		return head == -1;
	}

	@Override
	public boolean isFull() {
		return (tail + 1) % array.length == head;
	}

}
