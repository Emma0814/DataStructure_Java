package graph;

import java.io.BufferedReader;
import java.io.IOException;

public class ALGraph {
	
	private GraphKind kind;
	private int numNodes;
	private int numEdges;
	private VertexNode[] adjList; 
	
	public ALGraph(GraphKind kind, int numNodes, int numEdges, VertexNode[] adjList) {
		this.kind = kind;
	    this.numNodes = numNodes;
	    this.numEdges = numEdges;
	    this.adjList = adjList;
	}
	
	public ALGraph(String kind) {
		this(GraphKind.valueOf(kind), 0, 0, null);
	}
	
	public int getNumNodes() {
		return this.numNodes;
	}
	public void setNumNodes(int numNodes) {
		this.numNodes = numNodes;
	}
	public int getNumEdges() {
		return this.numEdges;
	}
	public void setNumEdges(int numEdges) {
		this.numEdges = numEdges;
	}
	public VertexNode[] getAdList() {
		return this.adjList;
	}
	public void setAdjList(VertexNode[] adjList) {
		this.adjList = adjList;
	}
	
	public void createGraph(BufferedReader br, int numNodes, int numEdges) throws IOException {
    	this.numNodes = numNodes;
    	this.numEdges = numEdges;
        this.adjList = new VertexNode[this.numNodes];
        for (int i = 0; i < this.numNodes; i++)
        	this.adjList[i] = new VertexNode(i);
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
            EdgeNode firstEdge = adjList[from].getFirstEdge();
            EdgeNode edge = new EdgeNode(to, weight, firstEdge);
            adjList[from].setFirstEdge(edge);
            if (isUndirected) {
            	EdgeNode firstEdge2 = adjList[to].getFirstEdge();
                EdgeNode edge2 = new EdgeNode(from, weight, firstEdge2);
                adjList[to].setFirstEdge(edge2);
            }
		}
	}
	
	public void display() {
		for (int i = 0; i < numNodes; i++) {
			System.out.print(adjList[i].getData());
			EdgeNode last = adjList[i].getFirstEdge();
			while (last != null) {
				System.out.print(" -> " + last.getAdjvex() + "(" + last.getWeight()+ ")");
				last = last.getNext();
			}
			System.out.println();
        }	
	}
}
