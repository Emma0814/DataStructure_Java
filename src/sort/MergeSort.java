package sort;

import java.util.*;

public class MergeSort {
	
	private void merge(int[] arr, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		ArrayList<Integer> temp = new ArrayList<>();
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j])
				temp.add(arr[i++]);
			else 
				temp.add(arr[j++]);
		}
		while (i <= mid) 
			temp.add(arr[i++]);
		while (j <= right) 
			temp.add(arr[j++]);
		for (int num : temp)
			arr[left++] = num;
	}
	
	/**
	 * Top-down divide
	 * @param arr
	 * @param left
	 * @param right
	 */
	private void mergeSort1(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort1(arr, left, mid);
			mergeSort1(arr, mid + 1, right);
			merge(arr, left, mid, right);
		} 
	}
	
	/**
	 * Recursive version
	 * @param arr
	 */
	public void sort1(int[] arr) {
		long startTime = System.nanoTime();	
		mergeSort1(arr, 0, arr.length - 1);
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(arr));
		System.out.println("Time: " + (endTime - startTime));
	}
	
	/**
	 * Bottom-up
	 * @param arr
	 * @param width
	 */
	private void mergePass(int[] arr, int width) {
		int left = 0;
		while (left + 2 * width - 1 < arr.length) {
			int mid = left + width - 1;
			int right = left + 2 * width - 1;
			merge(arr, left, mid, right);
			left += 2 * width;
		}
		if(left + width - 1 < arr.length)
            merge(arr, left, left + width - 1, arr.length - 1);
	}
	
	/**
	 * Without recursive
	 * @param arr
	 */
	public void sort2(int[] arr) {
		long startTime = System.nanoTime();
		int width = 1;
		while (width < arr.length) {
			mergePass(arr, width);
			width *= 2;
		}
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(arr));
		System.out.println("Time: " + (endTime - startTime));
	}
}
