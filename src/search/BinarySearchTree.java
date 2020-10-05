package search;

import tree.Node;

import java.util.Stack;

public class BinarySearchTree {

	private Node<Integer> root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public BinarySearchTree(Node root) {
		this.root = root;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
	
	/**
	 * Insert new key, 
	 * 	 if not exist, insert and return true
	 *   else, return false
	 * @param key
	 * @return
	 */
	public boolean insertBST(Node root, int key) {
		Node newNode = new Node(Integer.valueOf(key));
	    if (root == null) {
	        this.root = newNode;
	        return true;
	    } else {
	        Node current = root;
	        Node parentNode = null;
	        while (current != null) {
	        	if (key == (int) current.getData())
	        		return false;
	            parentNode = current;
	            if ((int) current.getData() > key) {
	                current = current.getLeftNode();
	                if (current == null) {
	                    parentNode.setLeftNode(newNode);
	                    return true;
	                }
	            } else {
	                current = current.getRightNode();
	                if (current == null) {
	                    parentNode.setRightNode(newNode);
	                    return true;
	                }
	            }
	        }
	    }
	    return false;
	}
	
	/**
	 * 删除操作。若删除成功，则返回 true
     * 1.若删除的是叶子结点，则直接删除该结点即可。若同时也是根结点，则删除后二叉排序树为空树
     * 2.若被删除结点只有左子树而无右子树 ，可直接将其左子树的根结点替代被删除结点的位置
     * 3.若删除结点只有右子树而无左子树，可直接将其右子树的根结点替代被删除结点的位置
     * 4.若删除结点有左、右子树，可将被删除结点在中序遍历下的前驱结点（或者后继结点）去代替被删除的结点
	 * @param root
	 * @param key
	 * @param parent
	 * @return
	 */
	public boolean deleteBST(Node root, int key, Node parent) {
		if (root == null)
			return false;
		if (key < (int) root.getData()) {                     //在左子树中删除
			return deleteBST(root.getLeftNode(), key, root);
		} else if (key > (int) root.getData()) {              //在右子树中删除
			return deleteBST(root.getRightNode(), key, root);
		} else if (root.getLeftNode() != null && root.getRightNode() != null){    //相等且有左右子树
			Node next = root.getRightNode();                  //寻找root在中序遍历下的后继结点next
			while (next.getLeftNode() != null)                //寻找右子树中的最左孩子就是root的中序后继结点
				next = next.getLeftNode();
			root.setData(next.getData());
			return deleteBST(root.getRightNode(), (int) root.getData(), root);
		} else {                                              //root是1度或者叶子结点
			if (parent == null) {                             //root是根
                if (root.getLeftNode() != null)
                    root = root.getLeftNode();
                else
                    root = root.getRightNode();
                return true;
            }
			if (root == parent.getLeftNode()){                //root是左孩子
                if (root.getLeftNode() != null)
                    parent.setLeftNode(root.getLeftNode());
                else
                    parent.setLeftNode(root.getRightNode());
            } else if (root == parent.getRightNode()){        //root是右孩子
                if (root.getLeftNode() != null)
                    parent.setRightNode(root.getLeftNode());
                else
                    parent.setRightNode(root.getRightNode());
            }
            return true;
		}
	}
	
	/**
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	public boolean searchBST1(Node root, int key) {
		if (root != null) {
			if (key == (int) root.getData())
				return true;
			else if (key < (int) root.getData()) 
				return searchBST1(root.getLeftNode(), key);
			else
				return searchBST1(root.getRightNode(), key);
		}
		return false;
	}
	
	/**
	 * Improve by reducing one-turn recursive
	 * @param root
	 * @param key
	 * @return
	 */
	public Node searchBST2(Node root, int key) {
		while (root != null) {
			if (key == (int) root.getData()) {
				return root;
			} else {
				Node leftNode = searchBST2(root.getLeftNode(), key);
				return leftNode != null ? leftNode : searchBST2(root.getRightNode(), key);
			}
		}
		return null;
	}
    
    /**
     * InOrder Traverse: left -> root -> right
     * Recursive version
     * @param current
     */
    public void inOrderTraverse(Node root) {
    	if (root == null) 
    		return;
    	inOrderTraverse(root.getLeftNode());
    	System.out.print(root.getData() + " ");
    	inOrderTraverse(root.getRightNode());
    }
    
    /**
     * InOrder Traverse: left -> root -> right
     * Stack version
     * @param current
     */
    public void inOrderTraverse2(Node root) {
    	if (root == null) 
    		return;
    	Stack<Node> stack = new Stack<>();
    	while (!stack.isEmpty() || root != null) {
    		if (root != null){
                stack.push(root);
                root = root.getLeftNode();
            } else {
                Node temp = stack.pop();
                System.out.print(temp.getData() + " ");
                root = temp.getRightNode();
            }
    	}  
    }
}
	
