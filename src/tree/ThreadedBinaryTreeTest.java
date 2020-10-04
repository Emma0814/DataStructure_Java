package tree;

public class ThreadedBinaryTreeTest {

	public static void main(String[] args) {
		ThreadedBinaryTree tbt = new ThreadedBinaryTree("ABDH#K###E##CFI###G#J##");
		ThreadedNode root = tbt.getRoot();
		System.out.println("----------线索化前序遍历----------");
		tbt.inThreading(root);
		tbt.inOrderTraverse(root);
	}
}
