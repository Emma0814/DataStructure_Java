package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MGraphTest {
	public static void main(String[] args) {
		try {
			String pathname = "src/graph/graph8.in";
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
		
//			double[][] arcs = new double[numNodes][numNodes];
			
			MGraph mgraph = new MGraph(kind3);
			mgraph.createGraph(br, numNodes, numEdges);
			mgraph.display();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
