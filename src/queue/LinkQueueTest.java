package queue;

/**
 * 
 * @author emmajing
 *
 */
public class LinkQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkQueue<String> lq = new LinkQueue<>();
        System.out.println("原队列中的元素： " + lq);
        System.out.println("----------入队列啦----------");
        //入队列
        lq.offer("haha");
        lq.offer("hehe");
        lq.offer("xixi");
        lq.offer("hiahia");
        lq.offer("heihei");
        System.out.println("入队列后队列中所含元素： " + lq);
        //获取队列头元素
        System.out.println("队列中队列头元素为： " + lq.peek());
        //获取栈中元素个数
        System.out.println("当队列中元素个数为： "+lq.length());
        //出栈
        System.out.println("----------出队列啦----------");
        lq.poll();
        System.out.println("出队列后队列中所含元素： " + lq);
        //获取栈顶元素
        System.out.println("队列头元素为： " + lq.peek());
        //获取栈中元素个数
        System.out.println("当前队列中元素个数为： " + lq.length());
        //清空线队列
        lq.clear();
        System.out.println("清空队列");
        System.out.println("清空后队列是否为空： " + lq.isEmpty());
	}

}
