package sort;

import java.util.*;

public class RadixSort {

	private int[] radixSort(int[] arr, int maxDigit) {
		int mod = 10;
		int dev = 1;
		HashMap<Integer, Queue<Integer>> counter = new HashMap<>();
		for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
	        for(int j = 0; j < arr.length; j++) {
	            int bucket = (arr[j] % mod) / dev;
	            if(!counter.containsKey(bucket))
	            	counter.put(bucket, new LinkedList<>());
	            counter.get(bucket).add(arr[j]);
	        }
	        int pos = 0;
	        int j = 0;
	        while (pos < arr.length) {
	            if(counter.containsKey(j)) {
	            	while (counter.get(j).peek() != null) 
	                	arr[pos++] = counter.get(j).poll();
	            }
	            j++;
	        }
	    }
		return arr;
	}
	
	public void sort(int[] arr, int maxDigit) {
		long startTime = System.nanoTime();	
		int[] B = radixSort(arr, maxDigit);
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(B));
		System.out.println("Time: " + (endTime - startTime));
	}
}
