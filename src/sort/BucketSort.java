package sort;

import java.util.*;

public class BucketSort {
	private List<Integer> bucketSort(int[] arr, int bucketNum) {
	    HashMap<Integer, List<Integer>> buckets = new HashMap<>();
	    int min = arr[0];
	    int max = arr[0];
	    for (int i = 0; i < arr.length; i++) {
	        min = min <= arr[i] ? min : arr[i];
	        max = max >= arr[i] ? max : arr[i];
	    }
	    int space = (max - min + 1) / bucketNum;
	    for (int j = 0; j < arr.length; j++) {
	    	int bucketNo = (arr[j] - min) / space;
	    	if (buckets.containsKey(bucketNo)) {   // insert sort
	    		int pos = buckets.get(bucketNo).size();
	    		for (int i = 0; i < buckets.get(bucketNo).size(); i++)
	    			if (buckets.get(bucketNo).get(i) > arr[j]) {
	    				pos = i;
	    				break;
	    			}
	    		buckets.get(bucketNo).add(pos, arr[j]);
	    	} else {
	    		List<Integer> list = new LinkedList<>();
	    		list.add(arr[j]);
	    		buckets.put(bucketNo, list);
	    	}
	    }
	    List<Integer> result = new LinkedList<>(); 
	    for (int k = 0; k < buckets.size(); k++) 
	    	for (int i = 0; i < buckets.get(k).size(); i++) 
	    		result.add(buckets.get(k).get(i));
	    return result;
	}
	
	public void sort(int[] arr) {
		long startTime = System.nanoTime();	
		List<Integer> result = bucketSort(arr, 4);
		long endTime = System.nanoTime();
		System.out.println(result.toString());
		System.out.println("Time: " + (endTime - startTime));
	}
}
