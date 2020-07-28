package queue;

import exception.ExceptionIsEmpty;

public interface Queud<T> {

	public void enqueue(T data);

	public T dequeue() throws ExceptionIsEmpty;

	public T getBack() throws ExceptionIsEmpty;

	public T getFront() throws ExceptionIsEmpty;

}
