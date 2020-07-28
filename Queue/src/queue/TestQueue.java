package queue;

import exception.ExceptionIsEmpty;

public class TestQueue {

	@SuppressWarnings({ "deprecation" })
	public static void main(String[] args) throws ExceptionIsEmpty {

		QueueLinked<Integer> queue1 = new QueueLinked<Integer>();
		queue1.enqueue(new Integer(3));
		queue1.enqueue(new Integer(4));
		queue1.enqueue(new Integer(5));
		queue1.enqueue(new Integer(7));
		queue1.enqueue(new Integer(8));
		queue1.enqueue(new Integer(9));
		System.out.println(queue1.toString());
		System.out.println(queue1.getFront());
		System.out.println(queue1.getBack());
		queue1.dequeue();
		queue1.dequeue();
		System.out.println(queue1.toString());

		QueueArray<Integer> queue2 = new QueueArray<Integer>(5);
		queue2.enqueue(new Integer(1));
		queue2.enqueue(new Integer(2));
		queue2.enqueue(new Integer(3));
		queue2.enqueue(new Integer(4));
		queue2.enqueue(new Integer(5));
		System.out.println(queue2.toString());
		queue2.dequeue();
		queue2.dequeue();
		System.out.println(queue2.toString());

		QueuePriorityArray<String> queue3 = new QueuePriorityArray<String>(3);
		queue3.enqueue("José", 1);
		queue3.enqueue("Marco", 1);
		queue3.enqueue("Luis", 2);
		queue3.enqueue("Miguel", 3);
		queue3.enqueue("Fernando", 3);
		queue3.dequeue();
		System.out.println(queue3.toString());

		QueuePriorityLinked<String> queue4 = new QueuePriorityLinked<String>(3);
		queue4.enqueue("Martín", 1);
		queue4.enqueue("Raúl", 2);
		queue4.enqueue("Ray", 2);
		queue4.enqueue("Arturo", 1);
		queue4.enqueue("Yuri", 3);
		queue4.dequeue();
		System.out.println(queue4.toString());

		DiqueLink<Integer> deque1 = new DiqueLink<Integer>();
		deque1.insertFirst(1);
		deque1.insertFirst(2);
		deque1.insertFirst(3);
		deque1.insertFirst(4);
		deque1.insertLast(6);
		System.out.println(deque1.toString());
		deque1.removeFirst();
		System.out.println(deque1.removeLast());
		System.out.println(deque1.toString());

		DiqueArray<Integer> deque2 = new DiqueArray<Integer>(4);
		deque2.insertFirst(3);
		deque2.insertFirst(5);
		deque2.insertLast(7);
		deque2.insertLast(8);
		System.out.println(deque2.toString());
		deque2.removeFirst();
		System.out.println(deque2.toString());
	}

}
