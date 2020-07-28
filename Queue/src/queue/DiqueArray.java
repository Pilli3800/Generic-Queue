package queue;

import exception.ExceptionIsEmpty;

public class DiqueArray<T> implements Diqueud<T> {

	private T content[];
	private int front;
	private int back;

	@SuppressWarnings("unchecked")
	public DiqueArray(int capacity) {
		this.content = (T[]) new Object[capacity];
	}

	@Override
	public void insertLast(T data) {
		isFull();
		this.content[(front + back++) % content.length] = data;
	}

	@Override
	public void insertFirst(T data) {
		isFull();
		if (front == 0) {
			this.content[(front = content.length - 1)] = data;
		} else {
			this.content[(--front) % content.length] = data;
		}

		back++;
	}

	@Override
	public T removeFirst() throws ExceptionIsEmpty {
		isEmpty();
		T aux = this.content[front];
		front = (front + 1) % content.length;
		back--;
		return aux;
	}

	@Override
	public T removeLast() throws ExceptionIsEmpty {
		isEmpty();

		T aux = this.content[(front + back - 1) % content.length];
		back--;
		return aux;
	}

	@Override
	public int size() {
		return back;
	}

	private void isFull() {
		if (content.length == back) {
			throw new IllegalStateException("No more space is available.");
		}
	}

	@Override
	public boolean isEmpty() {
		if (back == 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("[");

		for (int i = 0; i < back; ++i) {
			output.append(content[(front + i) % content.length]);

			if (i < back - 1) {
				output.append(" - ");
			}
		}

		return output.append("]").toString();
	}

}
