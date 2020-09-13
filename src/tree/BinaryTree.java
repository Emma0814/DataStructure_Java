package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Node<T>: Node<Character>
 * @author emmajing
 *
 */
public class BinaryTree {
	
	private Node<Character> root;
	private static int index = 0;
	
	public BinaryTree() {
		this.root = null;
	}
	
	public BinaryTree(Node root) {
		this.root = root;
	}

	/**
	 * Create a binary tree under a string of preOrderTraverse including empty subtrees
	 * e.g.: "ABDH#K###E##CFI###G#J###""
	 * @param preStr - preOrderTraverse with '#'
	 */
	public BinaryTree(String preStr) {
		char ch = preStr.charAt(index++);
		if (ch != '#'){
            this.root = new Node(Character.valueOf(ch));
            this.root.setLeftNode(new BinaryTree(preStr).getRoot());
            this.root.setRightNode(new BinaryTree(preStr).getRoot());
        }  else
            this.root = null; 
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void setRoot(Node current) {
		this.root = current;
	}
	
	public int getDepth(Node current) {
		if (current != null) {
			int depthL = getDepth(current.getLeftNode());
			int depthR = getDepth(current.getRightNode());
			return 1 + (depthL > depthR ? depthL : depthR);
		}
		return 0;
	}
	
	public boolean isEqual(Node T1, Node T2) {
		if (T1 == null && T2 == null)
			return true;
		if (T1 != null && T2 != null) {
			if (T1.getData() == T2.getData()) { // root equal?
				if (isEqual(T1.getLeftNode(), T2.getLeftNode()) && isEqual(T1.getRightNode(), T2.getRightNode()))
					return true;
			}
		}
		return false;
	}
	
	public boolean isEmpty(Node current) {
		if (index == 0)
			return true;
		return false;
	}
	
	/**
	 * Count node number using preOrderTraverse
	 * Recursive version
	 * @param current
	 * @return 
	 */
	public int countNode(Node current) {
		int count = 0;
		if (current != null) {
			count++;
			count += countNode(current.getLeftNode());
			count += countNode(current.getRightNode());
		}
		return count;
	}
	
	/**
	 * Count node number using levelTraverse
	 * @param current
	 * @return
	 */
	public int countNode2(Node current) {
		if (current == null)
    		return 0;
		int count = 0;
		Queue<Node> queue = new LinkedList<>();
    	queue.add(current);
    	while (!queue.isEmpty()) {
    		current = queue.poll();
    		count++;
    		if (current.getLeftNode() != null)
    			queue.add(current.getLeftNode());
             if (current.getRightNode() != null)
            	 queue.add(current.getRightNode());
    	}
    	return count;
	}
	
	public Node find(Node current, char key) {
		while (current != null) {
			if (key == (char) current.getData()) {
				return current;
			} else {
				Node leftNode = find(current.getLeftNode(), key);
				return leftNode != null ? leftNode : find(current.getRightNode(), key);
			}
		}
		return null;
	}
    
    /**
     * PreOrder Traverse: root -> left -> right 
     * Recursive version
     * @param current - current root
     */
    public void preOrderTraverse(Node current) {
    	if (current == null) 
    		return;
    	System.out.print(current.getData());
    	preOrderTraverse(current.getLeftNode());
    	preOrderTraverse(current.getRightNode());
    }
    
    /**
     * PreOrder Traverse
     * Stack version
     * @param current
     */
    public void preOrderTraverse2(Node current) {
    	if (current == null)
    		return;
    	Stack<Node> stack = new Stack<>();
    	stack.push(current);
    	while (!stack.isEmpty()) {
    		Node temp = stack.pop();
    		System.out.print(temp.getData());
    		if (temp.getRightNode() != null)
    			stack.push(temp.getRightNode());
    		if (temp.getLeftNode() != null)
    			stack.push(temp.getLeftNode());
    	}   	
    }
    
    /**
     * InOrder Traverse: left -> root -> right
     * Recursive version
     * @param current
     */
    public void inOrderTraverse(Node current) {
    	if (current == null) 
    		return;
    	inOrderTraverse(current.getLeftNode());
    	System.out.print(current.getData());
    	inOrderTraverse(current.getRightNode());
    }
    
    /**
     * InOrder Traverse: left -> root -> right
     * Stack version
     * @param current
     */
    public void inOrderTraverse2(Node current) {
    	if (current == null) 
    		return;
    	Stack<Node> stack = new Stack<>();
    	while (!stack.isEmpty() || current != null) {
    		if (current != null){
                stack.push(current);
                current = current.getLeftNode();
            } else {
                Node temp = stack.pop();
                System.out.print(temp.getData());
                current = temp.getRightNode();
            }
    	}  
    }
    
    /**
     * PostOrder Traverse: left -> right -> root
     * Recursive version
     * @param current
     */
    public void postOrderTraverse(Node current) {
    	if (current == null) 
    		return;
    	postOrderTraverse(current.getLeftNode());
    	postOrderTraverse(current.getRightNode());
    	System.out.print(current.getData());
    }
    
    /**
     * PostOrder Traverse: left -> right -> root
     * Stack version
     * @param current
     */
    public void postOrderTraverse2(Node current) {
    	if (current == null) 
    		return;
    	Stack<Node> stack = new Stack<>();
    	stack.push(current);
    	Node print = null;
    	while (!stack.isEmpty()) {
    		current = stack.peek();
    		char ch = (char) current.getData();
    		//如果一个结点的左子结点存在且该结点的左右子节点均未被打印，则说明这个结点是新的，将其压入栈
            if (current.getLeftNode() != null && print != current.getLeftNode() && 
            		(current.getRightNode() == null || print != current.getRightNode())){
                stack.push(current.getLeftNode());
            }
            //如果一个结点左子结点为空或者已被打印，而且该结点的右子结点存在且未被打印，则将其压入栈中
            else if (current.getRightNode() != null && print != current.getRightNode()){
                stack.push(current.getRightNode());
            }
            //若以上两个均不满足，说明该结点不能存在左右结点或者该结点的子结点均已被打印，则将该结点弹出并打印
            else {
                System.out.print(stack.pop().getData());
                //更新已被打印过的结点
                print = current;
            }
    	}  
    }
    
    /**
     * Level Traverse
     * @param current
     */
    public void levelTraverse() {
    	if (root == null)
    		return;
    	Node temp = root;
    	Queue<Node> queue = new LinkedList<>();
    	queue.add(temp);
    	while (!queue.isEmpty()) {
    		temp = queue.poll();
    		System.out.print(temp.getData());
    		 if (temp.getLeftNode() != null)
                 queue.add(temp.getLeftNode());
             if (temp.getRightNode() != null)
            	 queue.add(temp.getRightNode());
    	}
    }
}
