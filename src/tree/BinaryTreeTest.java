package tree;

/**
 * 
 * @author emmajing
 *
 */
public class BinaryTreeTest {

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree("ABDH#K###E##CFI###G#J###");
		Node root = bt.getRoot();
		System.out.println("----------递归前序遍历----------");
        bt.preOrderTraverse(root);
        System.out.println();
        System.out.println("----------非递归前序遍历--------");
        bt.preOrderTraverse2(root);
        System.out.println();
        System.out.println("----------递归中序遍历----------");
        bt.inOrderTraverse(root);
        System.out.println();
        System.out.println("----------非递归中序遍历--------");
        bt.inOrderTraverse2(root);
        System.out.println();
        System.out.println("----------递归后序遍历----------");
        bt.postOrderTraverse(root);
        System.out.println();
        System.out.println("----------非递归后序遍历--------");
        bt.postOrderTraverse2(root);
        System.out.println();
        System.out.println("----------非递归层序遍历--------");
        bt.levelTraverse();
        System.out.println();
        System.out.println();
        System.out.println("Depth: " + bt.getDepth(root));
        System.out.println("Node number(recursive): " + bt.countNode(root));
        System.out.println("Node number: " + bt.countNode(root));
        System.out.println("Is empty?: " + bt.isEmpty(root));
	}

}
