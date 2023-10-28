package Task1;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

// creates an array of double-size if the array of elements is full

	public void growSize() {
		elements = Arrays.copyOf(elements, size * 2);

	}

// Returns the number of elements in this list.
	public int size() {
		return elements.length;
	}

// Returns whether the list is empty.
	public boolean isEmpty() {
		return (size == 0);
	}

// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i >= this.size || i < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return elements[i];

	}

// Replaces the element at index i with e, and returns the replaced element.∗/

	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i >= size || i < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return elements[i] = e;
	}

// It is used to append the specified element at the end of a list.

	public boolean add(E e) {
		elements = Arrays.copyOf(elements, size + 1);
		elements[size] = e;
		return true;
	}

// Inserts element e to be at index i, shifting all subsequent elements later.

	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i > size || i < 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			E[] newElements = Arrays.copyOf(elements, size + 1);
			for (int j = size; j > i; j--) {
				newElements[j] = elements[j - 1];
			}
			newElements[i] = e;
			elements = newElements;
			size++;
		}
	}

// Removes and returns the element at index i, shifting subsequent elements earlier.

	public E remove(int i) throws IndexOutOfBoundsException {
		if (i >= this.size || i < 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			elements[i] = null;
			elements = Arrays.copyOf(elements, size - 1);
		}
		return elements[i];

	}

// It is used to clear all elements in the list.
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;

	}

// It is used to return the index in this list of the last occurrence of the specified element, or-1 if the list does not contain this element.

	public int lastIndexOf(Object o) {
		int result = -1;
		for (int i = 0; i < size; i++) {
			elements[i].equals(o);
			return i;
		}
		return -1;
	}

	// It is used to return an array containing all of the elements in this list in
	// the correct order.

	public E[] toArray() {
		E[] array = Arrays.copyOf(elements, size);
		return array;
	}

// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> clonedList = new MyArrayList<>();
		for (int i = 0; i < size; i++) {
			clonedList.add(elements[i]);
		}
		return clonedList;
	}
// It returns true if the list contains the specified element

	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

// It is used to return the index in this list of the first occurrence of the specified element, or-1 if the List does not contain this element.

	public int indexOf(E o) {
		int index = 0;
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) {
				return index = i;
			}
		}
		return -1;
	}

// It is used to remove the first occurrence of the specified element.

	public boolean remove(E e) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(e)) {
				for (int j = i; j < size - 1; j++) {
					elements[j] = elements[j + 1];
				}
				elements = Arrays.copyOf(elements, size - 1);
				size--;
				return true;
			}
		}
		return false;
	}

// It is used to sort the elements of the list on the basis of specified comparator.

	public void sort(Comparator<E> c) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - 1 - i; j++) {
				if (c.compare(elements[j], elements[j + 1]) < 0) {
					E temp = elements[j];
					elements[j] = elements[j + 1];
					elements[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<>();
		list.add(0, "Coca");
		list.add(1, "Pepsi");
		list.add(2, "Sting");
		list.add(0, "Coffe");

//		System.out.println(list.isEmpty());
//		System.out.println(list.get(0));
//		System.out.println(list.contains("Coca"));
//		System.out.println(list.indexOf("Sting"));
		list.clear();
//		System.out.println(list.remove("Coca"));
//		System.out.println(list.lastIndexOf(list));
		System.out.println(Arrays.toString(list.toArray()));

	}

}