package graph;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 邻接矩阵 - Adjacency Matrix
 * @author emmajing
 */
public class AMGraph {

	public final static int INFINITY = Integer.MAX_VALUE;
	private GraphKind kind;
	private int numNodes;
	private int numEdges;
	private double[][] arcs;
	
	public AMGraph(GraphKind kind, int numNodes, int numEdges, double[][] arcs){
		this.kind = kind;
	    this.numNodes = numNodes;
	    this.numEdges = numEdges;
	    this.arcs = arcs;
	}

	public AMGraph(String kind){
		this(GraphKind.valueOf(kind), 0, 0, null);
	}
	
	public GraphKind getKind() {
		return kind;
	}
	public void setKind(GraphKind kind) {
		this.kind = kind;
	}
	public int getNumNodes() {
		return numNodes;
	}
	public void setNumNodes(int numNodes) {
		this.numNodes = numNodes;
	}
	public int getNumEdges() {
		return numEdges;
	}
	public void setNumEdges(int numEdges) {
		this.numEdges = numEdges;
	}
	public double[][] getArc() {
		return arcs;
	}
	public void setArc(double[][] arcs) {
		this.arcs = arcs;
	}

	/**
	 * Create 4 kinds of graphs
	 * @throws IOException 
	 */
	public void createGraph(BufferedReader br, int numNodes, int numEdges) throws IOException {
    	this.numNodes = numNodes;
    	this.numEdges = numEdges;
        this.arcs = new double[numNodes][numNodes];
        switch (this.kind) {
        case UDG:
        	createGraph(br, 0, true);
            break;
        case DG:
        	createGraph(br, 0, false);
            break;
        case UDN:
        	createGraph(br, INFINITY, true);
        	break;
        case DN:
        	createGraph(br, INFINITY, false);
            break;
        default:
            break;
        }
    }

	/**
	 * Create undirected/directed graph
	 * @param br
	 * @param defaultValue
	 * @param isUndirected
	 * @throws IOException
	 */
	private void createGraph(BufferedReader br, int defaultValue, boolean isUndirected) throws IOException {
		// Initialize Adjacency Matrix to defaultVaule
		for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                arcs[i][j] = i == j ? 0.00 : defaultValue;
            }
        }     
        for (int e = 0; e < numEdges; e++) {
			String[] lineArr = br.readLine().split(" ");
            int i = Integer.parseInt(lineArr[0]);
            int j = Integer.parseInt(lineArr[1]);
            arcs[i][j] = Double.parseDouble(lineArr[2]);
            if (isUndirected)
            	arcs[j][i] = Double.parseDouble(lineArr[2]);
		}
	}
	
	/**
	 * Display Adjacency Matrix
	 */
	public void display() {
		for (int i = 0; i < arcs.length; i++) {
            for (int j = 0; j < arcs.length; j++) {
                if (arcs[i][j] == Integer.MAX_VALUE) 
                    System.out.print("    + "); 
                else
                    System.out.printf("%.3f ", arcs[i][j]);
            }
            System.out.println();
        }
	}
}
