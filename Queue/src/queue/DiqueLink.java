package queue;

import node.NodeDouble;

public class DiqueLink<T> implements Diqueud<T> {

	private NodeDouble<T> head;
	private NodeDouble<T> tail;
	private int size;

	public DiqueLink() {
		this.head = new NodeDouble<T>();
		this.tail = new NodeDouble<T>();
		this.head.setNext(tail);
		this.tail.setPrev(head);
		this.size = 0;
	}

	public NodeDouble<T> getHead() {
		return head;
	}

	public void setHead(NodeDouble<T> head) {
		this.head = head;
	}

	public NodeDouble<T> getTail() {
		return tail;
	}

	public void setTail(NodeDouble<T> tail) {
		this.tail = tail;
	}
	
	@Override
	public int size() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public void insertFirst(T data) {
		NodeDouble<T> control = this.head;
		NodeDouble<T> toInsert = new NodeDouble<T>();
		if (isEmpty()) {
			this.tail = toInsert;
		}
		toInsert.setData(data);
		toInsert.setNext(control);
		control.setPrev(toInsert);
		this.head = toInsert;
		size++;

	}

	@Override
	public void insertLast(T data) {
		NodeDouble<T> control = this.tail;
		NodeDouble<T> toInsert = new NodeDouble<T>();
		if (isEmpty()) {
			head = toInsert;
		}
		toInsert.setData(data);
		toInsert.setPrev(control);
		control.setNext(toInsert);
		this.tail = toInsert;
		size++;
	}

	@Override
	public T removeFirst() {
		if (head == null)
			return null;
		T aux = this.head.getData();
		this.head = this.head.getNext();
		size--;
		return aux;
	}

	@Override
	public T removeLast() {
		if (this.tail == null) {
			return null;
		}
		T aux = this.tail.getData();
		this.tail = tail.getPrev();
		size--;
		return aux;
	}

	public String toString() {
		StringBuilder output = new StringBuilder("[");
		NodeDouble<T> aux = this.head;
		for (int i = 0; i < this.size(); i++) {
			output = output.append(aux.getData()).append(" - ");
			if (aux == tail) {
				break;
			}
			aux = aux.getNext();
		}
		return output.toString().trim() + "]";
	}

}
