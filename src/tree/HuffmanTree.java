package tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author emmajing
 * 
 * T = Character
 */
public class HuffmanTree {
	
	private HashMap<Character, String> charCode = new HashMap<>();
	private HuffmanNode<Character> root;
	private String msg = "";
	
	public HuffmanTree() {
		this.root = null;
	}
	
	public HuffmanNode getRoot() {
		return this.root;
	}
	
	/**
	 * Count char frequency
	 * @param str
	 */
	public HashMap<Character, Integer> countFrequency(String str) {
		HashMap<Character, Integer> charMap = new HashMap<>();
		if (str.length() != 0)
			for (int i = 0; i < str.length(); i++)
				charMap.put(str.charAt(i), charMap.getOrDefault(str.charAt(i), 1) + 1);
		return charMap;
	}
	
	/**
	 * Sort charMap
	 * @param charMap
	 * @return
	 */
	public PriorityQueue<HuffmanNode> sort(HashMap<Character, Integer> charMap){
		PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new Comparator<HuffmanNode>() {
			@Override
			public int compare(HuffmanNode n1, HuffmanNode n2) {
				if (n1.getWeight() < n2.getWeight()) 
					return -1;
				else if(n1.getWeight() > n2.getWeight())
					return 1;
				else
					return 0;
			}
		});
		for (char ch : charMap.keySet())
			pq.offer(new HuffmanNode(ch, charMap.get(ch)));
		return pq;
	}
	
	/**
	 * Create a Huffman Tree
	 * @param pq
	 */
	public void createTree(PriorityQueue<HuffmanNode> pq) {
		if (pq.size() == 1)
			return;
		HuffmanNode node1 = pq.poll();
		HuffmanNode node2 = pq.poll();
		HuffmanNode newNode = new HuffmanNode(null, node1.getWeight() + node2.getWeight(),
				node1, node2);
		pq.offer(newNode);
		createTree(pq);
	}
	
	/**
	 * Encode node char to binary
	 * @param current
	 * @param code
	 */
	public void encoding(HuffmanNode current, String code) {
		if (current.getData() != null) {  // 叶子
			charCode.put((char) current.getData(), code);
			return;
		}
		encoding(current.getLeftNode(), code + "0");
		encoding(current.getRightNode(), code + "1");	
	}
	
	/**
	 * Return binary code of node char
	 * @param str
	 * @return
	 */
	public String encode(String str) {
		if (charCode.isEmpty()) {
			HashMap<Character, Integer> charMap = countFrequency(str);
			PriorityQueue<HuffmanNode> pq = sort(charMap);
			createTree(pq);
			this.root = pq.peek();
			encoding(this.root, "");
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++)
			sb.append(charCode.get(str.charAt(i)));
		return sb.toString();	
	}
	
	/**
	 * Decode binary string to char string
	 * @param code
	 * @param current
	 */
	public void decode(String code, HuffmanNode current) {
		if (code.length() == 0) {
			setMsg(getMsg() + current.getData());
			return;
		}
		if (current.getData() != null) {
			setMsg(getMsg() + current.getData());
			current = this.root;
		}
		if (code.charAt(0) == '0' )
			decode(code.substring(1), current.getLeftNode());
		if (code.charAt(0) == '1' ) 
			decode(code.substring(1), current.getRightNode());
	}
	
	public void printCharCode() {
		System.out.print("[");
		for (char ch : charCode.keySet())
			System.out.printf("%c: %s; ", ch, charCode.get(ch));
		System.out.println("]");
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
