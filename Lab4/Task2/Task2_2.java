package Task2;

import java.util.Random;

public class Task2_2 {

	public static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(array, low, high);
			quickSort(array, low, pivotIndex);
			quickSort(array, pivotIndex + 1, high);
		}
	}

	private static int partition(int[] array, int low, int high) {
		int pivot = getPivot_MedianOfThree(array, low, high);
		int i = low - 1;
		int j = high + 1;
		while (true) {
			do {
				i++;
			} while (array[i] < pivot);
			do {
				j--;
			} while (array[j] > pivot);
			if (i >= j) {
				return j;
			}
			swap(array, i, j);
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static int getPivot_MedianOfThree(int[] array, int low, int high) {
		int mid = low + (high - low) / 2;
		if (array[low] > array[mid])
			swap(array, low, mid);
		if (array[low] > array[high])
			swap(array, low, high);
		if (array[mid] > array[high])
			swap(array, mid, high);
		return array[mid];
	}

	private static int getPivot_First(int[] array) {
		return array[0];
	}

	private static int getPivot_Last(int[] array) {
		return array[array.length - 1];
	}

	private static int getPivot_Random(int[] array) {
		Random rand = new Random();
		return array[rand.nextInt(array.length)];
	}
	public static void main(String[] args) {
		
	}
}
