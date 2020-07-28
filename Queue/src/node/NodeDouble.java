package node;

public class NodeDouble<T> {

	NodeDouble<T> next;
	NodeDouble<T> prev;
	T data;

	public NodeDouble() {
		this.next = null;
		this.prev = null;
		this.data = null;
	}

	public NodeDouble(T data, NodeDouble<T> first, NodeDouble<T> last) {

		this.next = first;
		this.prev = last;
		this.data = data;
	}

	public NodeDouble<T> getNext() {
		return next;
	}

	public void setNext(NodeDouble<T> next) {
		this.next = next;
	}

	public NodeDouble<T> getPrev() {
		return prev;
	}

	public void setPrev(NodeDouble<T> prev) {
		this.prev = prev;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
