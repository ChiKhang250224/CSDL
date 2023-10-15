package Task2;

import java.util.Arrays;
import java.util.Random;

public class Task2_2 {
	public static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pivotIndex = getPivot_MedianOfThree(array, low, high);
			int newPivotIndex = partition(array, low, high, pivotIndex);
			quickSort(array, low, newPivotIndex - 1);
			quickSort(array, newPivotIndex + 1, high);
		}
	}

	private static int getPivot_MedianOfThree(int[] array, int low, int high) {
		int mid = low + (high - low) / 2;
		if (array[low] > array[mid])
			swap(array, low, mid);
		if (array[low] > array[high])
			swap(array, low, high);
		if (array[mid] > array[high])
			swap(array, mid, high);
		return mid;
	}

	private static int getPivot_First(int[] array) {
		return 0;
	}

	private static int getPivot_Last(int[] array) {
		return array.length - 1;
	}

	private static int getPivot_Random(int[] array) {
		Random rand = new Random();
		return rand.nextInt(array.length);
	}

	private static int partition(int[] array, int low, int high, int pivotIndex) {
		swap(array, pivotIndex, high);
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (array[j] <= array[high]) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, high);
		return (i + 1);
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 10, 7, 8, 9, 1, 5 };
		int n = array.length;
		quickSort(array, 0, n - 1);
		System.out.println(Arrays.toString(array));

	}
}
