package LZY.Day20200118_DataStructure.linkList.circularLinkList;

public class CircularLinkList {
    public int data; //数据域
    public CircularLinkList next = null; //指向下一个节点
    public static int count = 1; //跳出遍历链表的计数器

    public CircularLinkList(int data) {
        this.data = data;
    }

    public static void print(CircularLinkList circularLinkList, int limit) {
        System.out.println(circularLinkList.data);
        circularLinkList = circularLinkList.next;
        if (count < limit) {
            count ++;
            print(circularLinkList, limit);
        }
    }
}
