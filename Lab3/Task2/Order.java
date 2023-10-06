package Task2;

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

//get all products based on the given type using linear search

	public Product[] filter(String type) {
		List<Product> filteredProducts = new ArrayList<>();

		for (OrderItem item : items) {
			Product product = item.getP();
			if (product.getType().equalsIgnoreCase(type)) {
				filteredProducts.add(product);
			}
		}

		Product[] result = new Product[filteredProducts.size()];
		for (int i = 0; i < filteredProducts.size(); i++) {
			result[i] = filteredProducts.get(i);
		}

		return result;
	}

}