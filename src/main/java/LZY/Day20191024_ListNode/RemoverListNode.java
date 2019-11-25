package LZY.Day20191024_ListNode;

/**
 * 删除单链表中的某个节点 2019.10.25
 */
public class RemoverListNode {

    private boolean removeListNode(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return false;
        }
        listNode = listNode.next;   //只允许访问当前节点， 所以要删除只能让当前节点等于下一个节点
        return true;
    }
}
