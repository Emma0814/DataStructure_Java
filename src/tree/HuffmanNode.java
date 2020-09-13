package tree;

/**
 * 
 * @author emmajing
 *
 * @param <T>
 */
public class HuffmanNode<T> {
	
	private T data;
	private int weight;
	private HuffmanNode leftNode;
	private HuffmanNode rightNode;
	
	public HuffmanNode(T data, int weight, HuffmanNode leftNode, HuffmanNode rightNode) {
		this.data = data;
		this.weight = weight;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	public HuffmanNode(T data, int weight) {
		this(data, weight, null, null);	
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public HuffmanNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(HuffmanNode leftNode) {
		this.leftNode = leftNode;
	}

	public HuffmanNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(HuffmanNode rightNode) {
		this.rightNode = rightNode;
	}	
}
