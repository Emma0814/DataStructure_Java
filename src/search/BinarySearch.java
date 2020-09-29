package search;

import java.util.Arrays;

public class BinarySearch {

	private int binarySearch1(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (key == arr[mid])
				return mid;
			else if (key < arr[mid])
				right = mid - 1;
			else 
				left = mid + 1;
		}
		return -1;
	}
	
	private int binarySearch2(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) * (key - arr[left]) / (arr[right] - arr[left]);
			if (key == arr[mid])
				return mid;
			else if (key < arr[mid])
				right = mid - 1;
			else 
				left = mid + 1;
		}
		return -1;
	}
	
	public void search1(int[] arr, int key) {
		long startTime = System.nanoTime();
		int result = binarySearch1(arr, key);
		long endTime = System.nanoTime(); 
		System.out.println(result);
		System.out.println("Time: " + (endTime - startTime));
	}
	
	public void search2(int[] arr, int key) {
		long startTime = System.nanoTime();
		int result = binarySearch2(arr, key);
		long endTime = System.nanoTime(); 
		System.out.println(result);
		System.out.println("Time: " + (endTime - startTime));
	}
}
