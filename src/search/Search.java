package search;

public class Search {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
		System.out.println("******** Binary Search ********");
		BinarySearch binary = new BinarySearch();
		binary.search1(arr, 5);
		binary.search2(arr, 5);
	}

}
