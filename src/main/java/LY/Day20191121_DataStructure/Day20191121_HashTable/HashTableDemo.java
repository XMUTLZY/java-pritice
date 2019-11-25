package LY.Day20191121_DataStructure.Day20191121_HashTable;

import jdk.nashorn.internal.ir.CallNode;

/**
 * @Auther: liuyang
 * @Date: 2019/11/21 16:52
 * @Description:散列表、自动扩容HashMap
 */
public class HashTableDemo {
    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable();

        for(int i=1;i<100;i++){
            myHashTable.insertData("key"+i,"value"+i);
        }
        myHashTable.get("key5");
        myHashTable.get("key6");
        myHashTable.get("key99");

    }


}

class MyHashTable {
    int box = 16;
    Node a[];  //hash数组
    double init; //加载因子
    int count = 0;

    public MyHashTable() {
        init = 0.75;
        a = new Node[box];
        for(int i=0;i<box;i++){
            a[i] = new Node();
        }
    }

    public void insertData(String key, String value) {
        Node findLast;
        count++;
        if(count>box*init){    //HashMap容量超过加载因子和桶乘积时自动扩容为2倍
            box = box *2;
            a = Expand(a,box);
        }
        int hashindex = key.hashCode() % box; //取模运算可升级为位运算（前提:桶为2的幂次方）
        if (a[hashindex].getDate() == null) {
            a[hashindex].setKey(key);
            a[hashindex].setDate(value);
        } else {
            findLast = a[hashindex];
            while(findLast.getNext()!=null){
                findLast = findLast.getNext();
            }
            Node node = new Node();
            node.setKey(key);
            node.setDate(value);
            findLast.setNext(node);
        }
    }
    Node[] Expand(Node a[],int box){
        /**
         *
         * 功能描述: 扩容为box,通过Node temp[] 为HashMap接收待扩容HashMap
         *
         * @param: [a, box]
         * @return: LY.Day20191121_DataStructure.Day20191121_HashTable.Node[]
         * @auther: liuyang
         * @date: 2019/11/21 9:58 下午
         */

        Node temp[] = new Node[box];
        for(int i=0;i<box;i++){
            temp[i] = new Node();
        }
        Node findLast;
        Node next;
        for(int i=0;i<box/2;i++){
            next = a[i];
            if(next.getKey()==null){
                continue;
            }
            do { //链表一个一个重插
                int hashIndex = next.getKey().hashCode()%box;
                if(temp[hashIndex].getKey()==null){//桶为空，直接插
                    temp[hashIndex].setKey(next.getKey());
                    temp[hashIndex].setDate(next.getDate());
                }
                else { //通过findLast找最后一个链表节点
                    findLast = temp[hashIndex];

                    while(findLast.getNext()!=null){
                        findLast = findLast.getNext();
                    }
                    Node node = new Node();
                    node.setKey(findLast.getKey());
                    node.setDate(findLast.getDate());
                    findLast.setNext(node);
                }

                next = next.getNext();
            }while (next!=null);
        }
        return temp;
    }
    public void get(String key){
        int hashIndex = key.hashCode()%box;
        Node node = a[hashIndex];
        try{
            while(!key.equals(node.getKey())){
                node = node.getNext();
            }
        if(node.getKey().equals(key))
        System.out.println(node.getDate());
        }catch (NullPointerException e){
            System.out.println("未找到此值");
        }

    }

}

class Node {
    String key = null;
    String date = null;
    Node next = null;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}