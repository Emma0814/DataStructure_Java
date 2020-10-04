package graph;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 十字链表 Orthogonal List
 * @author emmajing
 *
 */
public class OLGraph {

	private GraphKind kind;
	private int numNodes;
	private int numEdges;
	private OLVertexNode[] adjList; 
	
	public OLGraph(GraphKind kind, int numNodes, int numEdges, OLVertexNode[] adjList) {
		this.kind = kind;
	    this.numNodes = numNodes;
	    this.numEdges = numEdges;
	    this.adjList = adjList;
	}
	
	public OLGraph(String kind) {
		this(GraphKind.valueOf(kind), 0, 0, null);
	}
	
	public void createGraph(BufferedReader br, int numNodes, int numEdges) throws IOException {
    	this.numNodes = numNodes;
    	this.numEdges = numEdges;
        this.adjList = new OLVertexNode[this.numNodes];
        for (int i = 0; i < this.numNodes; i++)
        	this.adjList[i] = new OLVertexNode(i);
        switch (this.kind) {
        case UDG:
        	createGraph(br, true);
            break;
        case DG:
        	createGraph(br, false);
            break;
        case UDN:
        	createGraph(br, true);
        	break;
        case DN:
        	createGraph(br, false);
            break;
        default:
            break;
        }
	}

	private void createGraph(BufferedReader br, boolean isUndirected) throws IOException {
		for (int e = 0; e < numEdges; e++) {
			String[] lineArr = br.readLine().split(" ");
            int from = Integer.parseInt(lineArr[0]);
            int to = Integer.parseInt(lineArr[1]);
            double weight = Double.parseDouble(lineArr[2]);
            // 头插法
            OLEdgeNode firstout = adjList[from].getFirstout();
            OLEdgeNode firstin = adjList[to].getFirstin();
            OLEdgeNode edge = new OLEdgeNode(from, to, weight, firstin, firstout);
            adjList[from].setFirstout(edge);
            adjList[to].setFirstin(edge);
		}
	}
	
	public void display() {
		System.out.println("Adjacency List");
		for (int i = 0; i < numNodes; i++) {
			System.out.print(adjList[i].getData());
			OLEdgeNode last = adjList[i].getFirstout();
			while (last != null) {
				System.out.print(" -> " + last.getTailvex() + "(" + last.getWeight()+ ")" + last.getHeadvex());
				last = last.getTaillink();
			}
			System.out.println();
        }	
		System.out.println("Reverse Adjacency List");
		for (int i = 0; i < numNodes; i++) {
			System.out.print(adjList[i].getData());
			OLEdgeNode last = adjList[i].getFirstin();
			while (last != null) {
				System.out.print(" -> " + last.getTailvex() + "(" + last.getWeight()+ ")" + last.getHeadvex());
				last = last.getHeadlink();
			}
			System.out.println();
        }	
	}
}

class OLEdgeNode {

	private int tailvex;
	private int headvex;
	private double weight;
	private OLEdgeNode headlink;
	private OLEdgeNode taillink;
	
	public OLEdgeNode(int tailvex, int headvex, double weight, OLEdgeNode headlink, OLEdgeNode taillink) {
		this.tailvex = tailvex;
		this.headvex = headvex;
		this.weight = weight;
		this.headlink = headlink;
		this.taillink = taillink;
	}
	
	public OLEdgeNode() {
		this(0, 0, 0.0, null, null);
	}

	public int getTailvex() {
		return tailvex;
	}

	public void setTailvex(int tailvex) {
		this.tailvex = tailvex;
	}

	public int getHeadvex() {
		return headvex;
	}

	public void setHeadvex(int headvex) {
		this.headvex = headvex;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public OLEdgeNode getHeadlink() {
		return headlink;
	}

	public void setHeadlink(OLEdgeNode headlink) {
		this.headlink = headlink;
	}

	public OLEdgeNode getTaillink() {
		return taillink;
	}

	public void setTaillink(OLEdgeNode taillink) {
		this.taillink = taillink;
	}
}

class OLVertexNode {

	private int data;
	private OLEdgeNode firstin;
	private OLEdgeNode firstout;
	
	public OLVertexNode(int data, OLEdgeNode firstin, OLEdgeNode firstout) {
		this.data = data;
		this.firstin = firstin;
		this.firstout = firstout;
	}
	
	public OLVertexNode(int data) {
		this(data, null, null);
	}
	
	public OLVertexNode() {
		this(0, null, null);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public OLEdgeNode getFirstin() {
		return firstin;
	}

	public void setFirstin(OLEdgeNode firstin) {
		this.firstin = firstin;
	}

	public OLEdgeNode getFirstout() {
		return firstout;
	}

	public void setFirstout(OLEdgeNode firstout) {
		this.firstout = firstout;
	}
}
