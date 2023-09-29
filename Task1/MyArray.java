package Task1;

import java.util.Arrays;
import java.util.Iterator;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	// Task 1_1
	public int[] mirror() {
		int[] result = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[i];
			result[result.length - 1 - i] = array[i];
		}
		return result;
	}

	public int[] removeDuplicates() {
		int newLength = 0;
		boolean[] isDuplicated = new boolean[array.length];
		for (int i = 0; i < array.length; i++) {
			if (!isDuplicated[i]) {
				for (int j = i + 1; j < array.length; j++) {
					if (array[i] == array[j]) {
						isDuplicated[j] = true;
					}
				}
				newLength++;
			}

		}
		int[] result = new int[newLength];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (!isDuplicated[i]) {
				result[index++] = array[i];
			}
		}
		return result;
	}

	public int[] getMissingValues() {
		int missingCount = 0;
		int min = array[0];
		int max = array[array.length - 1];
		for (int i = min + 1; i < max; i++) {
			boolean isMissing = true;
			for (int j = 0; j < array.length; j++) {
				if (array[j] == i) {
					isMissing = false;
					break;
				}
			}
			if (isMissing) {
				missingCount++;
			}
		}

		int[] missingValues = new int[missingCount];
		int index = 0;

		for (int i = min + 1; i < max; i++) {
			boolean isMissing = true;
			for (int j = 0; j < array.length; j++) {
				if (array[j] == i) {
					isMissing = false;
					break;
				}
			}
			if (isMissing) {
				missingValues[index] = i;
				index++;
			}
		}

		return missingValues;
	}

	public static void main(String[] args) {
		int[] array = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		MyArray ma = new MyArray(array);
		// System.out.println(Arrays.toString(ma.mirror()));
		System.out.println(Arrays.toString(ma.getMissingValues()));

	}
}
