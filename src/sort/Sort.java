package sort;

public class Sort {

	public static void main(String[] args) {
		int[] arr = new int[]{3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
		System.out.println("******** Bubble Sort ********");
		BubbleSort bubble = new BubbleSort();
		bubble.sort1(arr.clone());
		bubble.sort2(arr.clone());
		bubble.sort3(arr.clone());
		System.out.println("******** Selection Sort ********");
		SelectionSort selection = new SelectionSort();
		selection.sort(arr.clone());
		System.out.println("******** Insert Sort ********");
		InsertSort insert = new InsertSort();
		insert.sort1(arr.clone());
		insert.sort2(arr.clone());
		System.out.println("******** Shell Sort ********");
		ShellSort shell = new ShellSort();
		shell.sort(arr.clone());
		System.out.println("******** Merge Sort ********");
		MergeSort merge = new MergeSort();
		merge.sort1(arr.clone());
		merge.sort2(arr.clone());
		System.out.println("******** Quick Sort ********");
		QuickSort quick = new QuickSort();
		quick.sort1(arr);
	}
}
