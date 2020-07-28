package queue;

import exception.ExceptionIsEmpty;

public interface Diqueud<T> {

	public void insertFirst(T data);

	public void insertLast(T data);

	public T removeFirst() throws ExceptionIsEmpty;

	public T removeLast() throws ExceptionIsEmpty;

	public boolean isEmpty();

	public int size();

}
