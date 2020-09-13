package stack;

/**
 * 
 * @author emmajing
 *
 * @param <T>
 */
public class SqStack<T> {

	private final int MAXSIZE = 20;
	
	private Object[] data;
    private int top;

    public SqStack() {
    	this.data = new Object[MAXSIZE];
        this.top = -1;
    }
    
	public void clear() {
		this.top = -1;
	}

    public boolean isEmpty() {
    	return this.top == -1;
    }

    public int length() {
    	return this.top + 1;
    }

    public T peek() {
    	if (isEmpty())
    		return null;
    	return (T) this.data[this.top];
    }

    public void push(T e) {
    	if (this.top + 1 == MAXSIZE)
    		System.out.println("Stack is full");
    	else
    		this.data[++this.top] = e;
    }

    public T pop() {
    	if (isEmpty())
    		return null;
    	return (T) this.data[--this.top];
    }

    public String toString() {
    	if (isEmpty())
            return "[";
        else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < length(); i++)
            	sb.append(this.data[i].toString() + " ");
            return sb.toString().trim();
        }
    }	
}
