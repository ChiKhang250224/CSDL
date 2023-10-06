package Task2;

public class Test {
	public static void main(String[] args) {
		Product p1 = new Product("001", "CocaCola", 10000, "Loai 1");
		Product p2 = new Product("002", "CocaCola", 15000, "Loai 2");
		Product p3 = new Product("003", "Pepsi", 10000, "Loai 1");
		Product p4 = new Product("004", "Sting", 12000, "Loai 1");
		
		OrderItem o1 = new OrderItem(p1, 2);
		OrderItem o2 = new OrderItem(p2, 3);
		OrderItem o3 = new OrderItem(p3, 1);
		OrderItem o4 = new OrderItem(p4, 4);
		
		OrderItem[] items = {o1,o2,o3,o4}; 
		Order order = new Order(items);
		
		System.out.println("Don hang co chua Product 4: "+ order.contains(p4));
		
		Product[] filteredProducts = order.filter("Loai 2");
        System.out.println("San pham Loai 1 trong don hang:");
        for (Product product : filteredProducts) {
            System.out.println(product.toString());
        }
    }
	}


