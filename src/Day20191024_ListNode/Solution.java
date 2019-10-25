package Day20191024_ListNode;

/**
 * 链表中倒数第k个节点 2019.10.24
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        head.addNode(listNode1);
        listNode1.addNode(listNode2);
        listNode2.addNode(listNode3);
        head.print(head);
        System.out.println(solution(head, 3).getData());
    }

    private static ListNode solution(ListNode head, int k) {
        if (head == null || k<=0)
            return null;
        ListNode p = head;
        ListNode q = head;
        int i = 0,count = 1;
        while(p.next != null) {//p先移动k-1个节点
            count++;
            if (i<k-1) {
                p = p.next;
                i++;
            } else {
                p = p.next;
                q = q.next;
            }
        }
        if (k > count)
            return null;
        return q;
    }

}
