package search;

public class BinarySearch {

	private int binarySearch(int[] arr, int key) {
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
	
	public void search(int[] arr, int key) {
		long startTime = System.nanoTime();
		int result = binarySearch(arr, key);
		long endTime = System.nanoTime(); 
		System.out.println(result);
		System.out.println("Time: " + (endTime - startTime));
	}
}
