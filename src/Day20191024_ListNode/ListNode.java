package Day20191024_ListNode;

/**
 * 定义链表 2019.10.25
 */
public class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int data) {
        this.data = data;
    }

    public void addNode(ListNode listNode) {
        if (this.next == null) {
            this.next = listNode;
        } else {
            this.next.addNode(listNode);
        }
    }

    public ListNode getNextListNode() {
        return this.next;
    }

    public int getData() {
        return this.data;
    }

    public void print(ListNode listNode) { //从根节点开始打印链表
        System.out.println(listNode.getData());
        if (listNode.getNextListNode() != null)
            print(listNode.getNextListNode());
    }
}
