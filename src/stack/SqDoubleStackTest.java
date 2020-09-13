package stack;

/**
 * 
 * @author emmajing
 *
 */
public class SqDoubleStackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqDoubleStack<String> sds = new SqDoubleStack<>();
        System.out.println("原栈中的元素： " + sds);
        System.out.println("----------进栈啦----------");
        //压栈
        sds.push("haha", 1);
        sds.push("hehe", 1);
        sds.push("xixi", 2);
        sds.push("hiahia", 1);
        sds.push("heihei", 2);
        System.out.println("压栈后栈中所含元素： " + sds);
        //获取栈顶元素
        System.out.println("栈1顶元素为： " + sds.peek(1));
        //获取栈中元素个数
        System.out.println("当前栈中元素个数为： " + sds.length());
        //出栈
        System.out.println("----------栈1出栈啦----------");
        sds.pop(1);
        System.out.println("出栈后栈中所含元素： " + sds);
        //获取栈顶元素
        System.out.println("栈2顶元素为： " + sds.peek(2));
        //获取栈中元素个数
        System.out.println("当前栈中元素个数为： " + sds.length());
	}

}
