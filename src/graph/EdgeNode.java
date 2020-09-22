package graph;

public class EdgeNode {

	private int adjvex;
	private double weight;
	private EdgeNode next;
	
	public EdgeNode(int adjvex, double weight, EdgeNode next) {
		this.adjvex = adjvex;
		this.weight = weight;
		this.next = next;
	}
	
	public EdgeNode() {
		this(0, 0.0, null);
	}

	public int getAdjvex() {
		return adjvex;
	}

	public void setAdjvex(int adjvex) {
		this.adjvex = adjvex;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public EdgeNode getNext() {
		return next;
	}

	public void setNext(EdgeNode next) {
		this.next = next;
	}
}
