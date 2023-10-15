package Task1;

import java.util.Arrays;

public class Task1_1 {
	// sort by descending order
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int max = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[max] < array[j]) {
					max = j;
				}
			}
				swap(array, i, max);
			}
		}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;

	}

	public static void main(String[] args) {
		int[] arr = { 9, 10, 7, 5, 7 };
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
