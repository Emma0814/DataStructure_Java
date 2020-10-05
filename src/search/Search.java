package search;

public class Search {

	public static void main(String[] args) {
		int[] arr1 = new int[] {52,39,67,95,70,8,25,52,4,3,7,36,56};
		int[] arr2 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
		System.out.println("******** Static Search ********");
		StaticSearch seqence = new StaticSearch();
		seqence.search(arr1.clone(), 95);
		System.out.println("******** Binary Search ********");
		BinarySearch binary = new BinarySearch();
		binary.search(arr2.clone(), 5);
		System.out.println("******** Interpolation Search ********");
		InterpolationSearch interpolation = new InterpolationSearch();
		interpolation.search(arr2.clone(), 5);
		System.out.println("******** Binary Search Search ********");
		BinarySearchTree bst = new BinarySearchTree();
		for (int i = 0; i < arr1.length; i++)
            bst.insertBST(bst.getRoot(), arr1[i]);
		System.out.println("二叉树中根遍历：");
		bst.inOrderTraverse(bst.getRoot());
		System.out.println();
        System.out.println("95存在：" + bst.searchBST1(bst.getRoot(), 95));
        System.out.println("30存在：" + bst.searchBST1(bst.getRoot(), 30));
        System.out.println("删除结点52后的二叉树中根遍历：");
        bst.deleteBST(bst.getRoot(), 52, null);
        bst.inOrderTraverse(bst.getRoot());
	}

}
