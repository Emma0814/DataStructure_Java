package sort;

import java.util.Arrays;

public class ShellSort {
	
	/**
	 * if(i < i-gap) -> swap
	 * @param arr
	 */
	public void sort(int[] arr) {
		long startTime = System.nanoTime();
		int gap = arr.length;
		int temp = 0;
		do {
			gap = gap / 5 + 1;
			for (int i = gap; i < arr.length; i++) {
				int j = i - gap;   
				if (arr[i] < arr[j]) { // compare(i, j) -> swap
					temp = arr[i];
					for (; j >= 0 && temp < arr[j]; j -= gap)
						arr[j + gap] = arr[j];
					arr[j + gap] = temp;
				}
			}	
		} while (gap > 1);  // gap == 1, break
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(arr));
		System.out.println("Time: " + (endTime - startTime));
	}
}
