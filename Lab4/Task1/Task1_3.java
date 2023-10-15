package Task1;

import java.util.Arrays;

public class Task1_3 {
	public static void insertionSort(int[] array) {
		int n = array.length;
		for (int k = 1; k < n; k++) {
			int cur = array[k];
			int j = k;
			while (j > 0 && array[j - 1] < cur) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = cur;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 9, 10, 3, 5, 7 };
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));

	}
}
