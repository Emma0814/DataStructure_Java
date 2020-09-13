package stack;

/**
 * 
 * @author emmajing
 *
 */
public class LinkStackTest {

	public static void main(String[] args) {
		LinkStack<String> ls = new LinkStack<>();
        System.out.println("原栈中的元素： " + ls);
        System.out.println("----------进栈啦----------");
        //压栈
        ls.push("haha");
        ls.push("hehe");
        ls.push("xixi");
        ls.push("hiahia");
        ls.push("heihei");
        System.out.println("压栈后栈中所含元素： " + ls);
        //获取栈顶元素
        System.out.println("栈顶元素为： " + ls.peek());
        //获取栈中元素个数
        System.out.println("当前栈中元素个数为： " + ls.length());
        //出栈
        System.out.println("----------出栈啦----------");
        ls.pop();
        System.out.println("出栈后栈中所含元素： " + ls);
        //获取栈顶元素
        System.out.println("栈顶元素为： " + ls.peek());
        //获取栈中元素个数
        System.out.println("当前栈中元素个数为： " + ls.length());
	}

}
