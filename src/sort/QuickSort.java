package sort;

import java.util.Arrays;

public class QuickSort {
	
	/**
	 * Pivot = first element
	 * @param arr
	 * @param left
	 * @param right
	 */
	private void quickSort1(int arr[], int left, int right) {
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
		quickSort1(arr, left, i - 1);
		quickSort1(arr, i + 1, right);
	}
	
	/**
	 * Pivot = mid of three element
	 * @param arr
	 * @param left
	 * @param right
	 */
	private void quickSort2(int arr[], int left, int right) {
		if (left > right)
			return;
		int i = left;
		int j = right;
		
		// pivot = mid of three element
		int mid = i + (j - i) / 2;
		if (arr[i] > arr[j]) {
			int temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
		}
		if (arr[mid] > arr[j]) {
			int temp = arr[j];
			arr[j] = arr[mid];
			arr[mid] = temp;
		}
		if (arr[mid] > arr[i]) {
			int temp = arr[i];
			arr[i] = arr[mid];
			arr[mid] = temp;
		}
			
		int pivot = arr[i]; 
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
		quickSort2(arr, left, i - 1);
		quickSort2(arr, i + 1, right);
	}
	
	/**
	 * Replace rather than swap
	 * @param arr
	 * @param left
	 * @param right
	 */
	private void quickSort3(int arr[], int left, int right) {
		if (left > right)
			return;
		int i = left;
		int j = right;
		int pivot = arr[left]; 
		while (i < j) {
			while (i < j && pivot <= arr[j])
				j--;
			arr[i] = arr[j];                 //
			while (i < j && pivot >= arr[i])
				i++;
			arr[j] = arr[i];                 //
		}
		arr[i] = pivot;                      //
		quickSort3(arr, left, i - 1);
		quickSort3(arr, i + 1, right);
	}
	
	/**
	 * Reduce recursion 2 -> 1
	 * @param arr
	 * @param left
	 * @param right
	 */
	private void quickSort4(int arr[], int left, int right) {
		if (left > right)
			return;
		while (left < right) {
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
			quickSort1(arr, left, i - 1);
			left = i + 1;
		}
	}
	
	public void sort1(int[] arr) {
		long startTime = System.nanoTime();	
		quickSort1(arr, 0, arr.length - 1);
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(arr));
		System.out.println("Time: " + (endTime - startTime));
	}
	
	public void sort2(int[] arr) {
		long startTime = System.nanoTime();	
		quickSort2(arr, 0, arr.length - 1);
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(arr));
		System.out.println("Time: " + (endTime - startTime));
	}
	
	public void sort3(int[] arr) {
		long startTime = System.nanoTime();	
		quickSort3(arr, 0, arr.length - 1);
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(arr));
		System.out.println("Time: " + (endTime - startTime));
	}
	public void sort4(int[] arr) {
		long startTime = System.nanoTime();	
		quickSort4(arr, 0, arr.length - 1);
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(arr));
		System.out.println("Time: " + (endTime - startTime));
	}
}
