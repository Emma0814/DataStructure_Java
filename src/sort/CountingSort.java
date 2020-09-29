package sort;

import java.util.*;

public class CountingSort {
	private int[] countingSort(int[] arr) {
		int[] B = new int[arr.length];
	    HashMap<Integer, Integer> C = new HashMap<>();
	    int min = arr[0];
	    int max = arr[0];
	    for (int i = 0; i < arr.length; i++) {
	    	B[i] = 0;
	        min = min <= arr[i] ? min : arr[i];
	        max = max >= arr[i] ? max : arr[i];
	        C.put(arr[i], C.getOrDefault(arr[i], 0) + 1);
	    }
	    for (int j = min; j < max; j++)
    		C.put(j + 1, C.getOrDefault(j + 1, 0) + C.getOrDefault(j, 0));
	    for (int k = arr.length - 1; k >= 0; k--) {
	    	B[C.get(arr[k]) - 1] = arr[k];
	    	C.put(arr[k], C.get(arr[k]) - 1);
	    }
	    return B;
	}
	
	public void sort(int[] arr) {
		long startTime = System.nanoTime();	
		int[] B = countingSort(arr);
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(B));
		System.out.println("Time: " + (endTime - startTime));
	}
}
