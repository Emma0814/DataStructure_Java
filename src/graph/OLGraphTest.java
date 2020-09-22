package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class OLGraphTest {

	public static void main(String[] args) {
		try {
			String pathname = "src/graph/graph8.in";
			File filename = new File(pathname);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); 
			BufferedReader br = new BufferedReader(reader); 
			String line = br.readLine();
			
			String kind1 = "DG";
			String kind2 = "DN";
			
			int numNodes = Integer.parseInt(line);
			int numEdges = Integer.parseInt(br.readLine());
			
			OLGraph algraph = new OLGraph(kind1);
			algraph.createGraph(br, numNodes, numEdges);
			algraph.display();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
