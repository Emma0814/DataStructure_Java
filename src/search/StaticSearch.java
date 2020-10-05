package search;

public class StaticSearch {

    public int staticSearch(int[] arr, int key){
        for (int i = 0; i < arr.length; i++)
        	if (arr[i] == key)
        		return i;
        return -1;
    }
    
    public void search(int[] arr, int key) {
		long startTime = System.nanoTime();
		int result = staticSearch(arr, key);
		long endTime = System.nanoTime(); 
		System.out.println(result);
		System.out.println("Time: " + (endTime - startTime));
	}
}
