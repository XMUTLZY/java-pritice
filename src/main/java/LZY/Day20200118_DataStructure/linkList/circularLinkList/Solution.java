package LZY.Day20200118_DataStructure.linkList.circularLinkList;

import LZY.Day20200118_DataStructure.linkList.doubleLinkList.DoubleLinkList;
import LZY.Day20200118_DataStructure.linkList.singlyLinkList.SingleLinkList;

public class Solution {
    public static void main(String[] args) {
        int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        initSingleLinkList(arr);
    }

    public static void initSingleLinkList(int[] arr) {
        SingleLinkList singleLinkList = null;
        for (int i = 0; i<arr.length; i++) {
            if (singleLinkList == null) {
                singleLinkList = new SingleLinkList(arr[i]);
            }
            singleLinkList = singleLinkList.next;
        }
    }

    public static void initDoubleLinkList(int[] arr) {
        DoubleLinkList doubleLinkList = null;
        for (int i = 0; i<arr.length; i++) {
            if (doubleLinkList == null) {
                doubleLinkList = new DoubleLinkList(arr[i]);
            }
            DoubleLinkList frontNodes = doubleLinkList;
            doubleLinkList = doubleLinkList.next;
            doubleLinkList.front = frontNodes;
        }
    }
}
