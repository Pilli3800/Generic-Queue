package queue;

import java.util.ArrayList;

import exception.ExceptionIsEmpty;

public class QueuePriorityLinked<T> {

	private ArrayList<QueueLinked<T>> content;
	private int numberPriority;
	private int count;

	public QueuePriorityLinked(int numberPriority) {
		super();
		this.numberPriority = numberPriority;
		this.content = new ArrayList<QueueLinked<T>>(this.numberPriority);
		for (int i = 0; i < this.numberPriority; i++) {
			this.content.add(new QueueLinked<T>());
		}
		this.count = 0;
	}

	public void enqueue(T data, int p) {
		this.content.get(p - 1).enqueue(data);
		this.count++;
	}

	public T dequeue() throws ExceptionIsEmpty {
		T item = null;
		if (this.isEmpty())
			throw new ExceptionIsEmpty();
		for (int i = 0; i < this.numberPriority; i++) {
			if (!this.content.get(i).isEmpty()) {
				item = this.content.get(i).dequeue();
				break;
			}
		}
		this.count--;
		return item;
	}

	public T getBack() throws ExceptionIsEmpty {
		T item = null;
		if (this.isEmpty())
			throw new ExceptionIsEmpty("Queue Priority Empty");
		for (int i = 0; i < this.numberPriority; i++) {
			if (!this.content.get(i).isEmpty()) {
				item = this.content.get(i).getBack();
				break;
			}
		}
		return item;
	}

	public T getFront() throws ExceptionIsEmpty {
		T item = null;
		if (this.isEmpty())
			throw new ExceptionIsEmpty("Queue Priority Empty");
		for (int i = 0; i < this.numberPriority; i++) {
			if (!this.content.get(i).isEmpty()) {
				item = this.content.get(i).getFront();
				break;
			}
		}
		return item;
	}

	public boolean isEmpty() {
		if (this.count == 0) {
			return true;
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
