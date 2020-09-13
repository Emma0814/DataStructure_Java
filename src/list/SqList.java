package list;

/**
 * 
 * @author emmajing
 *
 * @param <T>
 */
public class SqList<T>{
	
	private final int MAXSIZE = 20;

    private Object[] data;  //Array, store data element
    private int length;     //Current length

    /* Initialize SqList */
    public SqList() {
    	this.length = 0;
    	this.data = new Object[MAXSIZE];
    }

    public void clear() {
    	this.length = 0;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int length() {
        return this.length;
    }

    /* Return the value of element at index i */
    public T get(int i) {
        if (isEmpty() || i < 0 || i > this.length - 1)
            System.out.println("Empty SqList OR there is no element at index i");
        return (T)this.data[i];
    }

    /* Insert a new element e in the front of index i */
    public void insert(int i, T e) {
        if (this.length == MAXSIZE)
            System.out.println("No space in SqList");
        if (i < 0 || i > this.length)
            System.out.println("Illegal insert position");
        for (int j = this.length; j > i; j--)
        	this.data[j] = this.data[j - 1];
        this.data[i] = e;
        this.length++;   
    }

    /* Delete element at index i */
    public T remove(int i) {
    	if (isEmpty())
    		System.out.println("Empty SqList");
        if (i < 0 || i > this.length - 1)
            System.out.println("Illegal delete position");
        Object e = this.data[i];
        for (int j = i; j < this.length - 1; j++)
        	this.data[j] = this.data[j + 1];
        this.length--;
        return (T)e;
    }
    
    /* Return the index of the first occurrence of the specified element */
    public int indexOf(T e) {
    	if (isEmpty())
           System.out.println("Empty SqList");
    	for (int i = 0; i < this.length; i++) {
        	if (this.data[i].equals(e))
        		return i;
        }
        return -1;
    }
    
    public String toString() {
    	if (isEmpty())
            return "[]";
        else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < this.length; i++)
                sb.append(this.data[i].toString() + " ");
            return sb.toString().trim() + "]";
        }
    }
    
    public void union(SqList<T> La, SqList<T> Lb) {
    	for (int i = 0; i < Lb.length(); i++) {
    		T e = Lb.get(i);
    		if (La.indexOf(e) < 0)
    			La.insert(La.length(), e);
    	}
    }

}