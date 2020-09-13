package list;

/**
 * 
 * @author emmajing
 *
 */
public class SqListTest {

	public static void main(String[] args) {
		SqList<String> sqlist = new SqList<>();
		sqlist.insert(sqlist.length(), "haha");
        sqlist.insert(sqlist.length(), "hehe");
        sqlist.insert(sqlist.length(), "xixi");
        System.out.println("添加元素后的顺序线性表为： " + sqlist);
        sqlist.insert(2, "heihei");
        System.out.println("在线性表的位置2插入元素： " + sqlist);
        sqlist.remove(2);
        System.out.println("删除线性表中位置2的元素： " + sqlist);
        sqlist.remove(sqlist.length() - 1);
        System.out.println("删除线性表中的最后一个元素： " + sqlist);
        System.out.println("获得线性表位置1处的元素： " + sqlist.get(1));
        System.out.println(sqlist);
        System.out.println("获取元素hehe所在位置： " + sqlist.indexOf("hehe"));
        sqlist.clear();
        System.out.println("清空线性表");
        System.out.println("清空后线性表是否为空： " + sqlist.isEmpty());
	}

}
