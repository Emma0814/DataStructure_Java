package tree;

/**
 * @author emmajing
 *
 */
public class Node<T> {

	private T data;
	private Node leftNode;
	private Node rightNode;
	
	public Node(T data, Node leftNode, Node rightNode){
		this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

	public Node(T data) {
		this(data, null, null);
	}
	
	public Node() {
		this(null);
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	
	public void display() {
		System.out.println(data);
	}
}
