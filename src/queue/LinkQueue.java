package queue;

/**
 * 
 * @author emmajing
 *
 * @param <T>
 */
public class LinkQueue<T> {
	
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
	
	private Node front;
    private Node rear;
    
	public LinkQueue() {
		this.front = this.rear = null;
	}
	
	public void clear() {
		this.front = this.rear = null;
	}

    public boolean isEmpty() {
    	return this.front == null;
    }

    public int length() {
    	int length = 0;
    	if (!isEmpty()) {
    		Node p = this.front;
    		while (p != null) {
    			p = p.next;
    			length++;
    		}
    	}
    	return length;
    }

    public T peek() {
    	if (isEmpty())
    		return null;
    	else
    		return this.front.data;
    }

    public void offer(T e) {
    	Node s = new Node(e);
    	if (this.front == null)
    		this.rear = this.front = s;
        else {
        	this.rear.next = s;
        	this.rear = s;
        }
    }

    public T poll() {
    	if (this.front == this.rear)
    		return (T) "Empty queue";
    	if (this.front != null) {
    		Node p = this.front;
    		this.front = this.front.next;
    		return (T) p.data;
    	} else
    		return null; 		
    }

    public String toString() {
    	if (isEmpty())
            return "[]";
        else {
            StringBuilder sb = new StringBuilder("[");
            for (Node s = this.front; s != null; s = s.next)
            	sb.append(s.data.toString() + " ");
            return sb.toString().trim() + "]";
        }
    }
}
