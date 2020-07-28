package queue;

import java.util.ArrayList;

import exception.ExceptionIsEmpty;

public class QueuePriorityArray<T> {

	private ArrayList<QueueArray<T>> content;
	private int numberPriority;

	public QueuePriorityArray(int numberPriority) {
		super();
		this.numberPriority = numberPriority;
		this.content = new ArrayList<QueueArray<T>>(this.numberPriority);
		for (int i = 0; i < this.numberPriority; i++) {
			this.content.add(null);
		}
	}

	public void enqueue(T data, int p) {
		if (this.content.get(p - 1) == null) {
			this.content.set(p - 1, new QueueArray<T>(5));
		}
		this.content.get(p - 1).enqueue(data);
	}

	public T dequeue() throws ExceptionIsEmpty {
		T item = null;
		boolean flag = true;
		for (int i = 0; i < this.numberPriority; i++) {
			if (this.content.get(i) != null) {
				item = this.content.get(i).dequeue();
				flag = false;
				break;
			}
		}
		if (flag == true) {
			throw new ExceptionIsEmpty("Empty");
		}

		return item;
	}

	public T getBack() throws ExceptionIsEmpty {
		T item = null;
		boolean flag = true;
		for (int i = 0; i < this.numberPriority; i++) {
			if (this.content.get(i) != null) {
				item = this.content.get(i).getBack();
				flag = false;
				break;
			}
		}
		if (flag == true) {
			throw new ExceptionIsEmpty("Empty");
		}
		return item;
	}

	public T getFront() throws ExceptionIsEmpty {
		T item = null;
		boolean flag = true;
		for (int i = 0; i < this.numberPriority; i++) {
			if (this.content.get(i) != null) {
				item = this.content.get(i).getFront();
				flag = false;
				break;
			}
		}
		if (flag == true) {
			throw new ExceptionIsEmpty("Empty");
		}
		return item;
	}

	public boolean isEmpty() {
		for (int i = 0; i <= this.numberPriority - 1; i++) {
			if (this.content.get(i) != null) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		StringBuilder string = new StringBuilder("");
		for (int i = 0; i < this.numberPriority; i++) {
			if (this.content.get(i) != null) {
				string.append("Priority ").append(i + 1 + " ").append(content.get(i).toString()).append("\n");
			}

		}
		return string.toString().trim() + "";
	}

}
