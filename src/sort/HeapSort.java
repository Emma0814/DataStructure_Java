package sort;

import java.util.Arrays;

public class HeapSort {
	
	private void heapAdjust(int[] arr, int start, int end) {
		int temp = arr[start];
		for (int i = 2 * start + 1; i <= end;) {
			if (i < end && arr[i] < arr[i + 1])
				i++;
			if (temp >= arr[i])
				break;
			arr[start] = arr[i];
			start = i;
			i = i * 2 + 1;
		}
		arr[start] = temp;		
	}

	public void sort(int[] arr) {
		long startTime = System.nanoTime();	
	    for (int i = arr.length / 2 - 1; i >= 0; i--) 
	        heapAdjust(arr, i, arr.length - 1);
	    for (int i = arr.length - 1; i >= 1;) {
	    	int temp = arr[0];
	    	arr[0] = arr[i];
	    	arr[i] = temp;
	    	heapAdjust(arr, 0, --i);
	    }
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(arr));
		System.out.println("Time: " + (endTime - startTime));
	}
}
