package tree;

public class ThreadedNode<T> {

	private T data;
	private int leftTag;    // 0: leftNode, 1: front-node
	private int rightTag;   // 0: rightNode, 1: rear-node
	private ThreadedNode leftNode;
	private ThreadedNode rightNode;
	
	public ThreadedNode(T data, int leftTag, int rightTag, ThreadedNode leftNode, ThreadedNode rightNode){
		this.data = data;
		this.leftTag = leftTag;
		this.rightTag = rightTag;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

	public ThreadedNode(T data) {
		this(data, 0, 0, null, null);
	}
	
	public ThreadedNode() {
		this(null);
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}

	
	public int getLeftTag() {
		return leftTag;
	}

	public void setLeftTag(int leftTag) {
		this.leftTag = leftTag;
	}

	public int getRightTag() {
		return rightTag;
	}

	public void setRightTag(int rightTag) {
		this.rightTag = rightTag;
	}

	public ThreadedNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(ThreadedNode leftNode) {
		this.leftNode = leftNode;
	}

	public ThreadedNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(ThreadedNode rightNode) {
		this.rightNode = rightNode;
	}

	public void display() {
		System.out.println(data);
	}
}
