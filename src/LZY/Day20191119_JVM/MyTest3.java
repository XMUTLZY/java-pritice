package LZY.Day20191119_JVM;

/**
 *  对于数组实例来说，其类型是在JVM运行期间动态生成的
 *
 *  助记符:
 *  anewarray:表示创建一个引用类型的（如类、接口、数组）数组，并将其引用值压入栈顶
 *  newarray:表示创建一个原始类型（如int、float、char等）数组，并将其引用值压入栈顶
 */
public class MyTest3 {
    public static void main(String[] args) {
        /**
         * 运行发现，MyParent3静态块内部语句并没有执行，说明类没有被初始化即生成的类型是JVM运行其动态生成的
         */
        MyParent3[] myParent3 = new MyParent3[1];
        System.out.println(myParent3.getClass());//查看类型
        System.out.println(myParent3.getClass().getSuperclass());//查看父类类型
        System.out.println("===");
        MyParent3[][] myParent3s = new MyParent3[1][1];
        System.out.println(myParent3s.getClass());
        System.out.println(myParent3s.getClass().getSuperclass());
        System.out.println("====");
        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());
    }
}
class MyParent3 {
    static {
        System.out.println("MyParent3 has been init");
    }
}
