package graph;

public class VertexNode {

	private int data;
	private EdgeNode firstEdge;
	
	public VertexNode(int data, EdgeNode firstEdge) {
		this.data = data;
		this.firstEdge = firstEdge;
	}
	
	public VertexNode(int data) {
		this(data, null);
	}
	
	public VertexNode() {
		this(0, null);
	}

	public EdgeNode getFirstEdge() {
		return firstEdge;
	}

	public void setFirstEdge(EdgeNode firstEdge) {
		this.firstEdge = firstEdge;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
