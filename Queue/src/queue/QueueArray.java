package queue;

import exception.ExceptionIsEmpty;

public class QueueArray<T> implements Queud<T> {

	private T[] content; 
	private int currentSize; 
	private int back; 
	private int front; 
	private int maxSize; 

	@SuppressWarnings("unchecked")
	QueueArray(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("The size can't be zero.");
		}
		this.maxSize = capacity;
		content = (T[]) new Object[maxSize];
		makeEmpty();
	}

	public void makeEmpty() {
		this.currentSize = 0;
		this.front = -1;
		this.back = -1;

	}

	public boolean isEmpty() {
		return front == -1 && back == -1;
	}

	public boolean isFull() {
		return (back + 1) % maxSize == front;
	}

	@Override
	public void enqueue(T data) {

		if (isFull()) {
			throw new IllegalStateException("Queue is full.");
		}
		if (isEmpty()) {
			front = 0;
			back = 0;
		} else {
			back = (back + 1) % maxSize;
		}
		content[back] = data;
		currentSize++;

	}

	@Override
	public T dequeue() throws ExceptionIsEmpty {
		T aux;
		if (isEmpty()) {
			throw new ExceptionIsEmpty("Queue is full.");
		}
		if (front == back) {
			aux = content[front];
			front = back = -1;
			currentSize--;
		} else {
			aux = content[front];
			front = (front + 1) % maxSize;
			currentSize--;
		}
		return aux;
	}

	@Override
	public T getBack() throws ExceptionIsEmpty {
		if (isEmpty()) {
			throw new ExceptionIsEmpty("Queue is empty.");
		}
		return content[back];
	}

	@Override
	public T getFront() throws ExceptionIsEmpty {
		if (isEmpty()) {
			throw new ExceptionIsEmpty("Queue is empty.");
		}
		return content[front];

	}

	public String toString() {
//		int count = (back + maxSize - front) % maxSize + 1;
		int count = currentSize;
		StringBuilder output = new StringBuilder("[");
		for (int i = 0; i < count; i++) {
			int index = (front + i) % maxSize;
			output.append(content[index]).append(" - ");
		}
		return output.toString().trim() + "]";
	}
}
