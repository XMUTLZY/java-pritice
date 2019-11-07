package Day20191101_HashMap.InitHashMap;

/**
 * 初始化hashMap
 */
public class InitHashMap {
    /**
     *  为什么说hashMap是线程不安全的？
     *  1、 外部可能会对同一个hashmap进结构性的修改（注：意思是增加or删除键值，替换value不是结构性的修改） 当发生结构性修改后，hashmap的内部迭代器的remove()方法
     *  会抛出ConcurrentModificationException异常，迭代器会快速失效
     *  2、扩容的概念
     */
    static final float DEAFULT_LOAD_FACTOR = 0.75f;     //哈希表"满"的程度
    static final int DEFAULT_CAPACITY = 16;     //当前桶的数量
    public static void main(String[] args) {

    }
}
