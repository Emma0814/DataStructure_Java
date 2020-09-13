package tree;

/**
 * 
 * @author emmajing
 *
 */
public class HuffmanTreeTest {

	public static void main(String[] args) {
		String msg = "BADCADFEED";
		System.out.println("Message: " + msg);
		HuffmanTree ht = new HuffmanTree();
		String code = ht.encode(msg);
		System.out.println("Encode: " + code);
		System.out.println("Code Map:");
		ht.printCharCode();
		ht.decode(code, ht.getRoot());
		System.out.println("Decode: " + ht.getMsg());
	}

}
