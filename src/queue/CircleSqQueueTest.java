package queue;

/**
 * 
 * @author emmajing
 *
 */
public class CircleSqQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleSqQueue<String> caq = new CircleSqQueue<>();
        System.out.println("原队列中的元素： "+caq);
        System.out.println("----------入队列啦----------");
        //入队列
        caq.offer("haha");
        caq.offer("hehe");
        caq.offer("xixi");
        caq.offer("hiahia");
        caq.offer("heihei");
        System.out.println("入队列后队列中所含元素： " + caq);
        //获取队列头元素
        System.out.println("队列中队列头元素为： " + caq.peek());
        //获取栈中元素个数
        System.out.println("当队列中元素个数为： "+caq.length());
        //出队
        System.out.println("----------出队列啦----------");
        caq.poll();
        System.out.println("出队列后队列中所含元素： " + caq);
        //获取栈顶元素
        System.out.println("队列头元素为： " + caq.peek());
        //获取栈中元素个数
        System.out.println("当前队列中元素个数为： "+caq.length());
        //清空线队列
        caq.clear();
        System.out.println("清空队列");
        System.out.println("清空后队列是否为空： " + caq.isEmpty());
	}

}
