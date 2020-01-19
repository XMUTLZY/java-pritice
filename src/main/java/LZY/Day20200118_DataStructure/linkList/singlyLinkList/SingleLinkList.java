package LZY.Day20200118_DataStructure.linkList.singlyLinkList;

public class SingleLinkList {
    public int data; //数据域
    public SingleLinkList next = null; //指向下一个节点

    public SingleLinkList(int data) {
        this.data = data;
    }

    public static void print(SingleLinkList singleLinkList) { // 从根节点打印数据
        System.out.println(singleLinkList.data);
        singleLinkList = singleLinkList.next;
        if (singleLinkList != null) {
            print(singleLinkList);
        }
    }
}
