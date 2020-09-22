package sort;

import java.util.Arrays;

public class QuickSort {
	
	private void quickSort(int arr[], int left, int right) {
		if (left > right)
			return;
		int i = left;
		int j = right;
		int pivot = arr[left]; 
		while (i < j) {
			while (i < j && pivot <= arr[j]) // start from right
				j--;
			while (i < j && pivot >= arr[i])
				i++;
			if (i < j) {   // swap(i, j)
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		// i == j, swap(pivot, arr[i])
		arr[left] = arr[i];
		arr[i] = pivot;
		quickSort(arr, left, j - 1);
		quickSort(arr, j + 1, right);
	}
	
	public void sort1(int[] arr) {
		long startTime = System.nanoTime();	
		quickSort(arr, 0, arr.length - 1);
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(arr));
		System.out.println("Time: " + (endTime - startTime));
	}
}
