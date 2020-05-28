package LZY.Day20200118_DataStructure.linkList;

/**
 * Created by Lin on 2020/03/11
 */
public class SimpleList {
    private int data;   //数据域
    private SimpleList next;    //指向下一个节点

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SimpleList getNext() {
        return next;
    }

    public void setNext(SimpleList next) {
        this.next = next;
    }

    /**
     * 构造函数
     */
    public SimpleList(int data) {
        this.data = data;
    }

    /**
     * 读取(get)
     * 返回链表中数据域为data的节点
     * @Params: simpleList:原始链表
     *          data: 数据域
     */
    public SimpleList get(SimpleList simpleList, int data) {
        SimpleList head = simpleList;   //指向头节点
        if (head == null) {
            return null;
        }
        while (head.next != null) {
            if (head.getData() == data) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 插入(insert)
     * 插入数据域到指定链表中
     * @Params: simpleList: 原始链表
     *          data: 要插入的值
     *          index: 要插入位置的索引值
     * @Return: 插入成功返回true 否则返回false
     */
    public Boolean insert(SimpleList simpleList, int data, int index) {
        SimpleList head = simpleList;
        if (head == null || index<0) {
            return false;
        }
        int count = 1;
        while (head.next != null) {
            if (count == index) {
                head.next = new SimpleList(data);
            }
            count++;
            head = head.next;
        }
        return true;
    }

    /**
     * 删除(delete)
     * 删除链表中数据域为data的节点
     * @Params: simpleList: 原始链表
     *          data: 要插入的值
     * @Return: 删除成功返回true 否则返回false
     */
    public Boolean delete(SimpleList simpleList, int data) {
        SimpleList head = simpleList;
        if (head == null) {
            return false;
        }
        if (head.getData() == data) {
            simpleList = null;
        }
        while (head.next != null) {
            if (head.next.getData() == data) {
                head.next = head.next.next;
            }
        }
        return true;
    }
}
