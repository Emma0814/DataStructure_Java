package stack;

/**
 * 
 * @author emmajing
 *
 * @param <T>
 */
public class LinkStack<T> {

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
	
    private Node top;
    private int count;

    public LinkStack() {
    	this.top = null;
    	this.count = 0;
    }
    
    public void clear() {
    	this.top = null;
    }

    public boolean isEmpty() {
    	return this.top.next == null;
    }

    public int length() {
    	return this.count;
    }

    public T peek() {
    	if (isEmpty())
    		System.out.println("Empty stack");
    	return this.top.data;
    }

    public void push(T e) {
    	Node s = new Node(e);
    	s.next = this.top;
    	this.top = s;
    	this.count++;
    }

    public T pop() {
    	if (isEmpty())
    		return null;
    	Node p = this.top;
    	this.top = p.next;
    	p.next = null;
    	this.count--;
    	return (T) p.data;
    }

    public String toString() {
    	Node current = this.top;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
        	sb.insert(1, current.data.toString() + " ");
        	current = current.next;
        }
        return sb.toString().trim();
    }
}
