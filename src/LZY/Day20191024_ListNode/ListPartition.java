package LZY.Day20191024_ListNode;


/**
 * 链表分割 2019.10.25
 */
public class ListPartition {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(6);
        head.addNode(listNode1);
        listNode1.addNode(listNode2);
        listNode2.addNode(listNode3);
        ListNode listNode = partition(head, 3);
    }

    private static ListNode partition(ListNode pHead, int x) { //小于等于x的数据放在x之前
        ListNode leftListNode = new ListNode(-1);
        ListNode rightListNode = new ListNode(-1);
        if (pHead.next == null || pHead == null)
            return pHead;
        while (pHead != null) {
            if (pHead.data <= x) {
                leftListNode.next = pHead;
                leftListNode = leftListNode.next;
            }
            if (pHead.data > x) {
                rightListNode.next = pHead;
                rightListNode = rightListNode.next;
            }
            pHead = pHead.next;
        }
        return rightListNode;
    }
}
