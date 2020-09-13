package list;

/**
 * 
 * @author emmajing
 *
 * @param <T>
 */
public class DulLinkList<T> {

	private class DulNode {
			
	    private T data;
	    private DulNode prior;
	    private DulNode next;

	    public DulNode() {
	        this(null);
	    }

	    public DulNode(T data) {
	    	this(data, null, null);
	    }
	    
	    public DulNode(T data, DulNode prior, DulNode next) {
	    	this.data = data;
	        this.prior = prior;
	        this.next = next;
	    }
	}
	
	private DulNode head;

	/* Initialize LinkList */
    public DulLinkList() {
        this.head = new DulNode();
        this.head.prior = this.head;
        this.head.next = this.head;
    }
    
    public void clear() { 
    	this.head.prior = this.head;
        this.head.next = this.head;
    }

    public boolean isEmpty() {
        return this.head.next.equals(this.head);
    }

    public int length() {
    	DulNode p = this.head.next;
        int i = 0;
        while (!p.equals(this.head)) {
        	i++;
            p = p.next;
        }
        return i;
    }
    
    /* Return the value of element at index i */
    public T get(int i) {
        DulNode p = this.head.next;
        int j = 0;
        while (!p.equals(this.head) && j < i) {
            p = p.next;
            j++;
        }
        if (j > i || p.equals(this.head)) {
            System.out.println("Element does not exist");
        }
        return p.data;
    }

    /* Insert a new element in the front of index i */
    public void insert(int i, T e) {
        DulNode p = this.head.next;
        int j = 0;
        // Find node at index i
        while (!p.equals(this.head) && j < i) {
            p = p.next;
            j++;
        }
        if (j != i)
            System.out.println("Illegal insert position");
        // p.prior <-> s <-> p
        DulNode s = new DulNode(e);
        p.prior.next = s;
        s.prior = p.prior;
        s.next = p;
        p.prior = s;
    }

    /* Delete element at index i */
    public void remove(int i) {
        DulNode p = this.head.next;
        int j = 0;
        // Find node p at index i
        while (!p.equals(this.head) && j < i) {
            p = p.next;
            j++;
        }
        if (p.equals(this.head) || j != i)
            System.out.println("Illegal delete position");
        p.next.prior = p.prior;
        p.prior.next = p.next;
        
    }

    /* Return the index of the first occurrence of the specified element */
    public int indexOf(T e) {
        DulNode p = this.head.next; // First node
        int j = 0;
        while (!p.equals(this.head) && !p.data.equals(e)) {
            p = p.next;
            j++;
        }
        if (!p.equals(this.head))
            return j;
        else
            return -1;
    }

    public String toString() {
        DulNode node = this.head.next; // first node
        StringBuilder sb = new StringBuilder("[");
        while (!node.equals(this.head)) {
        	sb.append(node.data.toString() + " ");
        	node = node.next;
        }
        return sb.toString().trim() + "]";
    }
}
