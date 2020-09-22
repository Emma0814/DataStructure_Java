package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * DFS， DFS
 * @author emmajing
 *
 */
public class TraverseGraph {

	private static ArrayList<Integer> visited = new ArrayList<>();
	
	/**
	 * Traverse in order of BFS
	 * @param G - Graph stored in Adjacency list
	 * @throws Exception
	 */
	public static void BFSTraverse(ALGraph G, int start) throws Exception {
		visited.clear();
        BFS(G, start);
        // If Graph is not connected, do BFS on each unvisited node
        if(visited.size() < G.getNumNodes()) {
        	for (int i = 0; i < G.getNumNodes(); i++) {
        		if (!visited.contains(G.getAdList()[i].getData()))
        			BFS(G, G.getAdList()[i].getData());
            }
        }
        System.out.println();
    }
	
	/**
	 * One turn BFS, traverse a connected graph started from start
	 * @param G - Graph stored in Adjacency list
	 * @param start - start vertex
	 * @throws Exception
	 */
	private static void BFS(ALGraph G, int start) throws Exception { 
		Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
        	int top = queue.poll();
        	System.out.print(top + "->");
        	EdgeNode next = G.getAdList()[top].getFirstEdge();
        	while (next != null) {
        		if(!visited.contains(next.getAdjvex())) {
        			visited.add(next.getAdjvex());
            		queue.add(next.getAdjvex());
        		}
        		next = next.getNext();
        	}
        }
    }
	
	/**
	 * Traverse in order of DFS
	 * @param G
	 * @param start
	 * @throws Exception
	 */
	public static void DFSTraverse(ALGraph G, int start) throws Exception {
		visited.clear();
        DFS(G, start);
        // If Graph is not connected, do DFS on each unvisited node
        if(visited.size() < G.getNumNodes()) {
        	for (int i = 0; i < G.getNumNodes(); i++) {
        		if (!visited.contains(G.getAdList()[i].getData()))
        			DFS(G, G.getAdList()[i].getData());
            }
        }
        System.out.println();
    }
	
	/**
	 * One turn DFS, traverse a connected graph started from start
	 * @param G
	 * @param start
	 */
	private static void DFS(ALGraph G, int start) {
		visited.add(start);
        System.out.print(G.getAdList()[start].getData()+ "->");
        EdgeNode next = G.getAdList()[start].getFirstEdge();
    	while (next != null) {
    		if(!visited.contains(next.getAdjvex()))
    			DFS(G, next.getAdjvex());
    		next = next.getNext();
    	}
	}

	public static void main(String[] args) {
		try {
			String pathname = "src/graph/graph16.in";
			File filename = new File(pathname);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); 
			BufferedReader br = new BufferedReader(reader); 
			String line = br.readLine();
			
			String kind1 = "UDG";
			String kind2 = "DG";
			String kind3 = "UDN";
			String kind4 = "DN";
			
			int numNodes = Integer.parseInt(line);
			int numEdges = Integer.parseInt(br.readLine());
			
			ALGraph algraph = new ALGraph(kind2);
			algraph.createGraph(br, numNodes, numEdges);
			algraph.display();
			BFSTraverse(algraph, 0);
			DFSTraverse(algraph, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
