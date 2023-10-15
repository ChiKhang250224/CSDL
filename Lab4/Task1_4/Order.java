package Task1_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}

	public OrderItem[] getItems() {
		return items;
	}

	public void setItems(OrderItem[] items) {
		this.items = items;
	}

	public double cost() {
		double totalcost = 0.0;
		for (int i = 0; i < items.length; i++) {
			OrderItem item = items[i];
			totalcost += item.getQuality() * item.getP().getPrice();
		}
		return totalcost;
	}

//using binary search approach
	public boolean contains(Product p) {
		Comparator<OrderItem> comparator = new Comparator<OrderItem>() {
			@Override
			public int compare(OrderItem o1, OrderItem o2) {
				return o1.getP().getId().compareTo(o2.getP().getId());
			}
		};
		Arrays.sort(items, comparator);

		OrderItem target = new OrderItem(p, 0);
		int index = Arrays.binarySearch(items, target, comparator);
		return index >= 0;
	}

// selection sort
	public void selectionSort(OrderItem[] items) {
		for (int i = 0; i < items.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < items.length; j++) {
				if (items[j].compareTo(items[minIndex]) < 0) {
					minIndex = j;
				}
			}
			OrderItem temp = items[i];
			items[i] = items[minIndex];
			items[minIndex] = temp;
		}
	}

// bubble sort
	public void bubbleSort(OrderItem[] items) {
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items.length - 1 - i; j++) {
				if (items[j].compareTo(items[j + 1]) < 0) {
					OrderItem temp = items[j];
					items[j] = items[j + 1];
					items[j + 1] = temp;
				}
			}
		}
	}

// insertion sort
	public void insertionSort(OrderItem[] items) {
		int n = items.length;
		for (int k = 1; k < n; k++) {
			OrderItem cur = items[k];
			int j = k;
			while (j > 0 && cur.compareTo(items[j - 1]) < 0) {
				items[j] = items[j - 1];
				j--;
			}
			items[j] = cur;
		}
	}
}
