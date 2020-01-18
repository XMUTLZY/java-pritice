package LZY.Day20200118_DataStructure.linkList.doubleLinkList;

public class DoubleLinkList {
    public int data; //数据域
    public DoubleLinkList front = null; //指向上一个节点
    public DoubleLinkList next = null; //指向下一个节点

    public DoubleLinkList(int data) {
        this.data = data;
    }
}
