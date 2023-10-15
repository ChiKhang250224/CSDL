package Task2;

import java.util.Arrays;

public class Task2_1 {
	    public static void mergeSort(int[] arr, int first, int last) {
	        if (first < last) {
	            int middle = (first + last) / 2;
	            mergeSort(arr, first, middle);
	            mergeSort(arr, middle + 1, last);
	            merge(arr, first, middle, last);
	        }
	    }

	    public static void merge(int[] arr, int first, int middle, int last) {
	        int n1 = middle - first + 1;
	        int n2 = last - middle;

	        int[] leftArr = new int[n1];
	        int[] rightArr = new int[n2];

	        for (int i = 0; i < n1; i++) {
	            leftArr[i] = arr[first + i];
	        }
	        for (int j = 0; j < n2; j++) {
	            rightArr[j] = arr[middle + 1 + j];
	        }

	        int i = 0, j = 0;
	        int k = first;

	        while (i < n1 && j < n2) {
	            if (leftArr[i] <= rightArr[j]) {
	                arr[k] = leftArr[i];
	                i++;
	            } else {
	                arr[k] = rightArr[j];
	                j++;
	            }
	            k++;
	        }

	        while (i < n1) {
	            arr[k] = leftArr[i];
	            i++;
	            k++;
	        }

	        while (j < n2) {
	            arr[k] = rightArr[j];
	            j++;
	            k++;
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = {38, 27, 43, 3, 9, 82, 10};
	        mergeSort(arr, 0, arr.length - 1);
	        System.out.println(Arrays.toString(arr));
	    }
	}



