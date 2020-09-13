package stack;

/**
 * 
 * @author emmajing
 *
 */
public class SqStackTest {

	public static void main(String[] args) {
		
		SqStack<String> ss = new SqStack<>();
        System.out.println("原栈中的元素： "+ss);
        System.out.println("----------进栈啦----------");
        //压栈
        ss.push("haha");
        ss.push("hehe");
        ss.push("xixi");
        ss.push("hiahia");
        ss.push("heihei");
        System.out.println("压栈后栈中所含元素： " + ss);
        //获取栈顶元素
        System.out.println("栈顶元素为： " + ss.peek());
        //获取栈中元素个数
        System.out.println("当前栈中元素个数为： " + ss.length());
        //出栈
        System.out.println("----------出栈啦----------");
        ss.pop();
        System.out.println("出栈后栈中所含元素： " + ss);
        //获取栈顶元素
        System.out.println("栈顶元素为： " + ss.peek());
        //获取栈中元素个数
        System.out.println("当前栈中元素个数为： " + ss.length());
	}

}
