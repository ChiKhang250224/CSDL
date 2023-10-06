package Task1;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (target == array[i]) {
				return i;
			}
		}
		return -1;
	}

	public int recursiveLinearSearch(int target) {
		return f(target, 0);

	}

	public int f(int target, int num) {
		if (num >= array.length) {
			return -1;
		}
		for (int i = 0; i < array.length; i++) {
			if (target == array[i]) {
				return i;
			}
			f(target, num + 1);
		}
		return -1;
	}

	// Task 1_2
	public int interativeBinarySearch(int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == array[mid]) {
				return mid;
			} else if (target < array[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public int recursiveBinarySearch(int target) {
		int low = 0;
		int high = array.length - 1;
		return f(array, target, low, high);
	}

	public int f(int[] arr, int target, int low, int high) {
		if (low > high) {
			return -1;
		} else {
			int mid = (low + high) / 2;
			if (target == arr[mid]) {
				return mid;
			} else if (target < arr[mid]) {
				return f(arr, target, low, mid - 1);
			} else {
				return f(arr, target, mid + 1, high);
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int[] arr = { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
		MyArray ma = new MyArray(array);
		MyArray m1 = new MyArray(arr);
		System.out.println(ma.iterativeLinearSearch(45));
		System.out.println(ma.recursiveLinearSearch(15));
		System.out.println(m1.interativeBinarySearch(23));
		System.out.println(m1.recursiveBinarySearch(23));
	}
}
	