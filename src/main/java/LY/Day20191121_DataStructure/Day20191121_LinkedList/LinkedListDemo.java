package LY.Day20191121_DataStructure.Day20191121_LinkedList;


/**
 * @Auther: liuyang
 * @Date: 2019/11/21 16:20
 * @Description: 链表基本操作
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        Node head = new Node();
        Node index = head;
        int a[] = {1,2,3,4,5,6};
        for(int i=0;i<a.length;i++){
            index.setData(a[i]);
            index.setNext(new Node());
            index = index.getNext();
        }
        index = head;
        while(index.getNext()!=null){
            System.out.println(index.getData());
            index = index.getNext();
        }
    }
}
class Node{
    private Node next = null;
    private int data;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}
