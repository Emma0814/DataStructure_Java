package tree;

/**
 * 
 * @author emmajing
 *
 */
public class ThreadedBinaryTree {

	private ThreadedNode<Character> root;
	private static int index = 0;
	private ThreadedNode<Character> pre = null;
	
	/**
	 * Create a threaded binary tree according to the string of preOrderTraverse 
	 * including empty subtrees
	 * e.g.: "ABDH#K###E##CFI###G#J##"
	 * @param preStr - preOrderTraverse with '#'
	 */
	public ThreadedBinaryTree(String preStr) {
		char ch = preStr.charAt(index++);
		if (ch != '#'){
            this.root = new ThreadedNode(Character.valueOf(ch));
            this.root.setLeftNode(new ThreadedBinaryTree(preStr).getRoot());
            this.root.setRightNode(new ThreadedBinaryTree(preStr).getRoot());
        } else 
        	this.root = null; 
	}
	
	public ThreadedNode getRoot() {
		return root;
	}
	
	public void setRoot(ThreadedNode root) {
		this.root = root;
	}
	
	/**
	 * InOrder threading process
	 * @param root
	 */
	public void inThreading (ThreadedNode root) {
		if (root == null) 
    		return;
		inThreading(root.getLeftNode());
    	if (root.getLeftNode() == null) {
    		root.setLeftTag(1);
    		root.setLeftNode(pre);
    	}
    	if (pre != null && pre.getRightNode() == null) {
    		pre.setRightTag(1);
    		pre.setRightNode(root);
    	} 
    	pre = root;
    	inThreading(root.getRightNode());
	}
	
	public void inOrderTraverse(ThreadedNode root) {
		ThreadedNode cur = this.root;
		Boolean jump = false;          //表示是否是从子树跳跃过来的
		while (cur != null) {
			while (cur != null && cur.getLeftTag() == 0 && !jump) 
				cur =cur.getLeftNode();
			System.out.print(cur.getData());
			jump = cur.getRightTag() == 1 ? true : false;
			cur = cur.getRightNode();
		}
	}
}
