package LZY.Day20200118_DataStructure.linkList;

import LZY.Day20200118_DataStructure.linkList.circularLinkList.CircularLinkList;
import LZY.Day20200118_DataStructure.linkList.doubleLinkList.DoubleLinkList;
import LZY.Day20200118_DataStructure.linkList.singlyLinkList.SingleLinkList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        int arr2[] = {0, 15, 25, 35};
        SingleLinkList singleLinkListHead = new SingleLinkList(arr[0]); //头结点
        SingleLinkList singleLinkListHead2 = new SingleLinkList(arr2[0]); //头结点
        solution.initSingleLinkList(singleLinkListHead, arr);
        solution.initSingleLinkList(singleLinkListHead2, arr2);
        System.out.println("该单链表的长度为:" + solution.count(singleLinkListHead));
//        SingleLinkList.print(solution.reverse(singleLinkListHead));//反转单链表
//        SingleLinkList.print(solution.getSingleLinkListByK(9, singleLinkListHead)); //获取倒数第K个节点
//        SingleLinkList.print(solution.getMiddle(singleLinkListHead)); //获取中间节点
//        solution.print(singleLinkListHead);//从尾到头打印单链表
//        SingleLinkList.print(solution.sort(singleLinkListHead, singleLinkListHead2));//两个有序链表的排序

        DoubleLinkList doubleLinkList = new DoubleLinkList(arr[0]); //头结点
        solution.initDoubleLinkList(doubleLinkList, arr);

        CircularLinkList circularLinkList = new CircularLinkList(arr[0]);
        solution.initCircularLinkList(circularLinkList, arr);

    }

    public void initSingleLinkList(SingleLinkList singleLinkList, int[] arr) {
        for (int i = 1; i<arr.length; i++) {
            if (singleLinkList.next == null) {
                singleLinkList.next = new SingleLinkList(arr[i]);
            }
            singleLinkList = singleLinkList.next;
        }
    }

    public void initDoubleLinkList(DoubleLinkList doubleLinkList, int[] arr) {
        for (int i = 1; i<arr.length; i++) {
            if (doubleLinkList.next == null) {
                doubleLinkList.next = new DoubleLinkList(arr[i]);
            }
            DoubleLinkList frontNodes = doubleLinkList;
            doubleLinkList = doubleLinkList.next;
            doubleLinkList.front = frontNodes;
        }
    }

    public void initCircularLinkList(CircularLinkList circularLinkList, int[] arr) {
        CircularLinkList head = circularLinkList;// 记录下头结点
        for (int i = 1; i<arr.length; i++) {
            if (circularLinkList.next == null) {
                circularLinkList.next = new CircularLinkList(arr[i]);
            }
            circularLinkList = circularLinkList.next;
        }
        circularLinkList.next = head; //尾节点指向头结点形成环
    }

    //1.求单链表中节点的个数
    public int count(SingleLinkList head) {
        if (head == null) {
            return 0;
        }
        int length = 1;
        while (head.next != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    //2.单链表反转
    public SingleLinkList reverse(SingleLinkList head) {
        if (head == null || head.next == null) {//没有头结点或者只有头结点的链表直接返回
            return head;
        }
        SingleLinkList newSingLinkList = null;
        while (head.next != null) {
            SingleLinkList temp = head.next;//临时节点 用于存放下一个节点，遍历原始链表
            head.next = newSingLinkList;//当前节点的下一个节点指向当前节点的前一个节点
            newSingLinkList = head;//存放当前节点
            head = temp;
        }
        head.next = newSingLinkList;
        newSingLinkList = head;
        return newSingLinkList;
    }

    //3.查找单链表中的倒数第K个结点（k > 0)
    public SingleLinkList getSingleLinkListByK(int k, SingleLinkList head) {
        SingleLinkList orginal = head;
        int i = 0;
        while (i<k-1) {
            if (head == null) {
                return null;
            }
            head = head.next;
            i++;
        }
        SingleLinkList tempSingleLinkList = head;
        while (tempSingleLinkList.next!=null) {
            tempSingleLinkList = tempSingleLinkList.next;
            orginal = orginal.next;
        }
        return orginal;
    }

    //4.查找单链表的中间结点
    public SingleLinkList getMiddle(SingleLinkList head) {
        if (head == null || head.next == null) {//如果只有头结点或者链表为空直接返回
            return head;
        }
        SingleLinkList first = head;
        SingleLinkList second = head;
        while (second.next != null) {
            first = first.next;
            second = second.next;
            if (second.next != null) {
                second = second.next;
            }
        }
        return first;
    }

    //5.从尾到头打印单链表
    public void print(SingleLinkList head) {
        if (head == null) {
            return;
        } else {
            print(head.next);
            System.out.println(head.data);
        }
    }

    //6.已知两个单链表head1和head2 各自有序，把它们合并成一个链表依然有序(假设都是从小到大)
    public SingleLinkList sort(SingleLinkList head1, SingleLinkList head2) {
        SingleLinkList result;
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.data < head2.data) {//初始化头节点
            result = head1;
            head1 = head1.next;
        } else {
            result = head2;
            head2 = head2.next;
        }
        result.next = null;
        SingleLinkList temp = result;
        while (head1!= null && head2!= null) {
            if (head1.data<head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
            temp.next = null;
        }
        if (head1!= null) {
            temp.next = head1;
        } else {
            temp.next = head2;
        }
        return result;
    }

    //7. 判断一个单链表中是否有环
    public boolean annular(SingleLinkList head) {
        SingleLinkList head1 = head;
        SingleLinkList head2 = head;
        while (head1.next != null && head2.next != null) {
            head1 = head1.next;
            head2 = head2.next.next;
            if (head1 == head2) {
                return true;
            }
        }
        return false;
    }

    //8. 判断两个单链表是否相交
    public boolean intersect(SingleLinkList head1, SingleLinkList head2) {
        if (head1 == null || head2 == null) {
            return false;
        }
        SingleLinkList temp1 = head1;
        SingleLinkList temp2 = head2;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        return temp1 == temp2;
    }

    //9. 求两个单链表相交的第一个节点
}
