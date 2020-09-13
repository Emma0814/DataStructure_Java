package list;

/**
 * s
 * @author emmajing
 *
 */
public class LinkListTest {

	public static void main(String[] args) {
		
		LinkList<String> linklist = new LinkList<>();
		linklist.insert(linklist.length(), "haha");
        linklist.insert(linklist.length(), "hehe");
        linklist.insert(linklist.length(), "xixi");
        System.out.println("添加元素后的链表为： " + linklist);
        linklist.insert(2, "heihei");
        System.out.println("在链表的位置2插入元素： " + linklist);
        linklist.remove(2);
        System.out.println("删除链表中位置2的元素： " + linklist);
        linklist.remove(linklist.length() - 1);
        System.out.println("删除链表中的最后一个元素： " + linklist);
        System.out.println("获得链表位置1处的元素 " + linklist.get(1));
        System.out.println("获取元素hehe所在位置： " + linklist.indexOf("hehe"));
        linklist.clear();
        System.out.println("清空链表");
        System.out.println("清空后链表是否为空： " + linklist.isEmpty());
	}

}
