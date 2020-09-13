package list;

/**
 * 
 * @author emmajing
 *
 */
public class DulLinkListTest {

	public static void main(String[] args) {
		
		DulLinkList<String> dullinklist = new DulLinkList<>();
		dullinklist.insert(dullinklist.length(), "haha");
        dullinklist.insert(dullinklist.length(), "hehe");
        dullinklist.insert(dullinklist.length(), "xixi");
        System.out.println("添加元素后的双向链性表为： " + dullinklist);
        dullinklist.insert(2, "heihei");
        System.out.println("在双向链表的位置2插入元素： " + dullinklist);
        dullinklist.remove(2);
        System.out.println("删除双向链表中位置2的元素： " + dullinklist);
        dullinklist.remove(dullinklist.length() - 1);
        System.out.println("删除双向链表中的最后一个元素： " + dullinklist);
        System.out.println("获得双向链表位置1处的元素 " + dullinklist.get(1));
        System.out.println("获取元素hehe所在位置： " + dullinklist.indexOf("hehe"));
        dullinklist.clear();
        System.out.println("清空双向链表");
        System.out.println("清空后双向链表是否为空： " + dullinklist.isEmpty());
	}
}
