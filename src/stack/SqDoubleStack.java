package stack;

/**
 * 
 * @author emmajing
 *
 * @param <T>
 */
public class SqDoubleStack<T> {
	
	private final int MAXSIZE = 10;
	
	private Object[] data;
    private int top1;
    private int top2;

    public SqDoubleStack() {
    	this.data = new Object[MAXSIZE];
        this.top1 = -1;
        this.top2 = MAXSIZE;
    }
    
	public void clear() {
		this.top1 = -1;
		this.top2 = MAXSIZE;
	}

    public boolean isEmpty() {
    	return this.top1 == -1 && this.top2 == MAXSIZE;
    }

    public int length() {
    	return this.top1 + 1 + MAXSIZE - this.top2;
    }

    public T peek(int stackNumber) {
    	if (isEmpty())
    		return null;
    	return stackNumber == 1 ? (T) this.data[this.top1] : (T) this.data[this.top2];
    }

    public void push(T e, int stackNumber) {
    	if (this.top1 + 1 == this.top2)
    		System.out.println("Stack is full");
    	else if (stackNumber == 1)
    		this.data[++this.top1] = e;
    	else
    		this.data[--this.top2] = e;
    }

    public T pop(int stackNumber) {
    	if (isEmpty())
    		return null;
    	return stackNumber == 1 ? (T) this.data[this.top1--] : (T) this.data[this.top2++];

    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < MAXSIZE; i++) {
        	if (i <= top1)
        		sb.append(this.data[i].toString() + " ");
        	else if (i >= top2)
        		sb.append(this.data[i].toString() + " ");
        	else
        		sb.append("  "); 		
        }
        return sb.toString().trim() + "]";
    }	
}
