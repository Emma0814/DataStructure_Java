package search;

public class InterpolationSearch {

	private int interpolationSearch(int[] arr, int key) {
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
	
	public void search(int[] arr, int key) {
		long startTime = System.nanoTime();
		int result = interpolationSearch(arr, key);
		long endTime = System.nanoTime(); 
		System.out.println(result);
		System.out.println("Time: " + (endTime - startTime));
	}
}
