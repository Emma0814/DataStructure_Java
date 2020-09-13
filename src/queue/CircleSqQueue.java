package queue;

/**
 * Saving one empty space when the queue is full
 * @author emmajing
 *
 * @param <T>
 */
public class CircleSqQueue<T> {

	private final int MAXSIZE = 20;
	
	private Object[] data;
    private int front;
    private int rear;

    public CircleSqQueue() {
    	this.data = new Object[MAXSIZE];
        this.front = 0;
        this.rear = 0;
    }	
    
	public void clear() {
		this.front = 0;
        this.rear = 0;
	}

    public boolean isEmpty() {
    	return this.front == this.rear;
    }

    public int length() {
    	return (this.rear - this.front + MAXSIZE) % MAXSIZE;
    }

    public T peek() {
    	if (isEmpty())
    		return null;
    	return (T) this.data[this.front];
    }

    public void offer(T e) {
    	if (length() == MAXSIZE)
    		System.out.println("Queue is full");
    	else {
    		this.data[this.rear] = e;
        	this.rear = (this.rear + 1) % MAXSIZE;
    	}
    }

    public T poll() {
    	if (length() == MAXSIZE)
    		return null;
    	else {
    		Object e = this.data[this.front];
    		this.front = (this.front + 1) % MAXSIZE;
    		return (T) e;
    	}
    }

    public String toString() {
    	if (isEmpty())
            return "[]";
        else {
            StringBuilder sb = new StringBuilder("[");
            int i = this.front;
            while((i + 1) != this.rear) {
            	sb.append(this.data[i].toString() + " ");
            	i = (i + 1) % MAXSIZE;
            }
            sb.append(this.data[i].toString() + " ");
            return sb.toString().trim() + "]";
        }
    }
}
