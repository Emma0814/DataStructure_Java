package list;

/**
 * 
 * @author emmajing
 *
 * @param <T>
 */
public class LinkList<T> {
	
	private class Node {
		
	    private T data;
	    private Node next;

	    public Node() {
	        this(null);
	    }

	    public Node(T data) {
	        this(data, null);
	    }

	    public Node(T data, Node next) {
	        this.data = data;
	        this.next = next;
	    }
	}

	private Node head;

	/* Initialize LinkList */
    public LinkList() {
        this.head = new Node();
    }
    
    public void clear() { 
        this.head.next = null;
    }

    public boolean isEmpty() {
        return this.head.next == null;
    }

    public int length() {
        Node p = this.head.next;
        int i = 0;
        while (p != null) {
        	i++;
            p = p.next;
        }
        return i;
    }

    /* Return the value of element at index i */
    public T get(int i) {
        Node p = this.head.next;
        int j = 0;
        while (p != null && j < i) {
            p = p.next;
            j++;
        }
        if (j > i || p == null) {
            System.out.println("Element does not exist");
        }
        return p.data;
    }

    /* Insert a new element in the front of index i */
    public void insert(int i, T e) {
        Node p = this.head;
        int j = -1;
        // Find node at index i-1
        while (p != null && j < i - 1) {
            p = p.next;
            j++;
        }
        if (p == null || j != i - 1)
        	System.out.println("Illegal insert position");
        // p -> s -> p.next
        Node s = new Node(e);
        s.next = p.next;
        p.next = s;
    }

    /* Delete element at index i */
    public void remove(int i) {
        Node p = this.head;
        int j = -1;
        // Find node p at index i-1
        while (p.next != null && j < i - 1) {
            p = p.next;
            j++;
        }
        if (p.next == null || j != i - 1)
        	System.out.println("Illegal delete position");
        p.next = p.next.next;
    }

    /* Return the index of the first occurrence of the specified element */
    public int indexOf(T e) {
        Node p = this.head.next; // First node
        int j = 0;
        while (p != null && !p.data.equals(e)) {
            p = p.next;
            j++;
        }
        if (p != null)
            return j;
        else
            return -1;
    }

    public String toString() {
        Node node = this.head.next; // first node
        StringBuilder sb = new StringBuilder("[");
        while (node != null) {
        	sb.append(node.data.toString() + " ");
        	node = node.next;
        }
        return sb.toString().trim() + "]";
    }
}
