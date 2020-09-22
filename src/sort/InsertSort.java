package sort;

import java.util.Arrays;

public class InsertSort {

	/**
	 * Insert first unsorted into sorted array, shift each element greater
	 * @param arr
	 */
	public void sort1(int[] arr) {
		long startTime = System.nanoTime();
		for (int i = 1; i < arr.length; i++) {
			int first = arr[i];
			int lastIndex = i - 1;
			while (lastIndex >= 0 && arr[lastIndex] > first)
				arr[lastIndex + 1] = arr[lastIndex--];
			arr[lastIndex + 1] = first;
		}
		long endTime = System.nanoTime(); 
		System.out.println(Arrays.toString(arr));
		System.out.println("Time: " + (endTime - startTime));
	}

	/**
	 * Improved insert sort
	 * Binary search to find insert position 
	 * @param arr
	 */
	public void sort2(int[] arr) {
		long startTime = System.nanoTime();
		for (int i = 1; i < arr.length; i++) {
			int first = arr[i];
			int left = 0;
			int right = i - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (first < arr[mid])
					right = mid - 1;
				else 
					left = mid + 1;
			}
			for (int j = i - 1; j >= left; j--)
                arr[j + 1] = arr[j];
			arr[left] = first;
		}
		long endTime = System.nanoTime(); 
		System.out.println(Arrays.toString(arr));
		System.out.println("Time: " + (endTime - startTime));
	}
}
