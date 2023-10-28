package Task2;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

	// Returns the number of elements in the list.
	public int size() {
		return size;
	}

	// Returns true if the list is empty, and false otherwise.
	public boolean isEmpty() {
		return (size == 0);
	}

	// Returns (but does not remove) the first element in the list.
	public E first() {
		if (isEmpty() == false) {
			return head.getData();
		}
		return null;
	}

	// Returns (but does not remove) the last element in the list.
	public E last() {
		if (isEmpty() == false) {
			return tail.getData();
		}
		return null;
	}

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		head = new Node<E>(e, head);
		if (size == 0) {
			tail = head;
			size++;
		}

	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e, null);
		if (size == 0) {
			head = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
			size++;
		}
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		if (isEmpty())
			return null;
		E element = head.getData();
		head = head.getNext();
		size--;
		if (size == 0)
			tail = null;
		return element;
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		if (isEmpty())
			return null;
		E element = tail.getData();
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			Node<E> current = head;
			for (int i = 0; i < size - 2; i++) {
				current = current.getNext();
			}
			current.setNext(null);
			tail = current;
		}
		size--;
		return element;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		System.out.println(list.first() + ", " + list.last());

		list.addLast(4);
		list.addLast(5);
		System.out.println(list.first() + ", " + list.last());

		list.removeFirst();
		System.out.println(list.first() + ", " + list.last());

		list.removeLast();
		System.out.println(list.first() + ", " + list.last());
	}

}
