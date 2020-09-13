package stack;

/**
 * 
 * @author emmajing
 * Two ways to implement Fibonacci 
 */
public class Fibonacci {

	public static int Fib(int i) {
		if (i < 2) 
			return i == 0 ? 0 : 1;
		return Fib(i - 1) + Fib(i - 2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		int[] arr = new int[10];  
		System.out.println("迭代显示斐波那契数列: ");
		arr[0] = 0;
		arr[1] = 1;
		System.out.printf("[ %d ", arr[0]);  
		System.out.printf("%d", arr[1]);  
		for (i = 2; i < arr.length; i++) { 
			arr[i] = arr[i-1] + arr[i-2];  
			System.out.printf(" %d",arr[i]);  
		} 
		System.out.println(" ]");
		
		System.out.println("递归显示斐波那契数列:");
		System.out.printf("[", arr[0]);  
		for (i = 0; i < 10; i++)  
			System.out.printf(" %d", Fib(i));  
		System.out.println(" ]");
	}

}
