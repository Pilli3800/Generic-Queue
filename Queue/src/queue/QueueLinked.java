package queue;

import exception.ExceptionIsEmpty;
import node.Node;

public class QueueLinked<T> implements Queud<T> {

	private Node<T> back, front;
	private int size;

	QueueLinked() {
		this.back = this.front = null;
		this.setSize(0);
	}

	@Override
	public void enqueue(T data) {
		if (isEmpty()) {
			Node<T> aux = new Node<T>(data);
			front = back = aux;
			aux.setNext(front);
		} else {
			Node<T> aux = new Node<T>(data);
			back.setNext(aux);
			aux.setNext(front);
			back = aux;
		}
//		if (back == null) {
//			back = new Node<T>(data, null);
//			back.setNext(back);
//		} else {
//			Node<T> toInsert = new Node<T>(data, back.getNext());
//			back.setNext(toInsert);
//			back = toInsert;
//		}
		size++;

	}

	public boolean isEmpty() {
		return (this.back == this.front && this.back == null);
	}

	@Override
	public T dequeue() throws ExceptionIsEmpty {
		T aux = null;
		Node<T> temp = this.front;
		if (isEmpty()) {
			if (front == back) {
				aux = this.front.getData();
				front = back = null;
			}
		} else {
			aux = this.front.getData();
			this.front = null;
			this.back.setNext(temp.getNext());
			this.front = temp.getNext();
		}
		size--;
		return aux;
	}

//	public void remove() {
//		Node<T> aux = this.front;
//		if (isEmpty()) {
//			if (front == back) {
//				front = back = null;
//			}
//		} else {
//			this.front = null;
//			this.back.setNext(aux.getNext());
//			this.front = aux.getNext();
//		}
//
//	}

	@Override
	public T getBack() throws ExceptionIsEmpty {
		if (isEmpty()) {
			throw new ExceptionIsEmpty("Queue Empty");
		}
		return back.getData();
	}

	@Override
	public T getFront() throws ExceptionIsEmpty {
		if (isEmpty()) {
			throw new ExceptionIsEmpty("Queue Empty");
		}
		return front.getData();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String toString() {
		String queue = "[";
		if (isEmpty()) {
			queue = "Empty";
			return queue;
		} else {
			Node<T> aux = front;
			while (aux != back) {
				queue = queue + aux.getData().toString() + " - ";
				aux = aux.getNext();
			}
			queue = queue + back.getData().toString() + "]";
		}
		return queue;
//		if (back == null) {
//			return "Empty";
//		} else {
//			return toString(back.getNext(), size);
//
//		}

	}

//	private String toString(Node<T> node, int nodesLeft) {
//		if (nodesLeft == 0) {
//			return "";
//		} else {
//			return node.getData() + " - " + toString(node.getNext(), nodesLeft - 1);
//		}
//	}

	public Node<T> setFront(Node<T> front) {
		this.front = front;
		return front;
	}
}
