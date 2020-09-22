package sort;

import java.util.Arrays;

public class BubbleSort {
	
	/**
	 * 冒泡排序
	 * 比较相邻元素，if 第一个比第二个大，交换
	 * @param arr
	 */
	public void sort1(int[] arr) {
		long startTime = System.nanoTime();
		for (int i = arr.length - 1; i > 0; i--) {
		    for (int j = 0; j < i; j++) {
			    if (arr[j] > arr[j + 1]) {
			    	int temp = arr[j + 1];
			        arr[j + 1] = arr[j];
			        arr[j] = temp;
			    }
		    }
	    }
		long endTime = System.nanoTime(); 
		System.out.println(Arrays.toString(arr));
		System.out.println("Time: " + (endTime - startTime));
	}
	
	/**
	 * 改进冒泡排序
	 * 设置一标志性变量 pos,用于记录每趟排序中最后一次进行交换的位置
	 * @param arr
	 */
	public void sort2(int[] arr) {
		long startTime = System.nanoTime();
		for (int i = arr.length - 1; i > 0;) {
			int pos = 0;
		    for (int j = 0; j < i; j++) {
			    if (arr[j] > arr[j + 1]) {
			    	int temp = arr[j + 1];
			        arr[j + 1] = arr[j];
			        arr[j] = temp;
			        pos = j;
			    }
		    }
		    i = pos;
	    }
		long endTime = System.nanoTime(); 
		System.out.println(Arrays.toString(arr));
		System.out.println("Time: " + (endTime - startTime));
	}
	
	/**
	 * 改进冒泡排序2
	 * 每趟都排序进行正反两遍冒泡，得到 max & min
	 * @param arr
	 */
	public void sort3(int[] arr) {
		long startTime = System.nanoTime(); 
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			for (int j = low; j < high; j++) {
	            if (arr[j] > arr[j + 1]) {
	            	int temp = arr[j + 1];
			        arr[j + 1] = arr[j];
			        arr[j] = temp;
	            }
			}
	        high--;
	        for (int j = high; j > low; j--) {
	            if (arr[j] < arr[j - 1]) {
	            	int temp = arr[j - 1];
			        arr[j - 1] = arr[j];
			        arr[j] = temp;
	            }
			}
	        low++;
		}
		long endTime = System.nanoTime(); 
		System.out.println(Arrays.toString(arr));
		System.out.println("Time: " + (endTime - startTime));
	}
}