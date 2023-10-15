package Task1;

import java.util.Arrays;

public class Task1_2 {
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] < array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
		}
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;

	}

	public static void main(String[] args) {
		int[] arr = { 9, 10, 3, 5, 7 };
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}