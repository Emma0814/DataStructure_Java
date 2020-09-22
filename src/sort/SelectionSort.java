package sort;

import java.util.Arrays;

public class SelectionSort {
	
	/**
	 * Traverse minimum and replace with the first unsorted
	 * @param arr
	 */
	public void sort(int[] arr) {
		long startTime = System.nanoTime();
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++)
				min = arr[min] > arr[j] ? j : min;
			if (i != min) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}	
		long endTime = System.nanoTime(); 
		System.out.println(Arrays.toString(arr));
		System.out.println("Time: " + (endTime - startTime));
	}
}
