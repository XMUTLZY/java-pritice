package LZY.Day20191119_JVM;

/**
 * 在对类的主动使用时，只有首次使用该类才会进行类的初始化
 */
public class MyTest2 {
    /**
     * 程序输出
     * MyParent has been init
     * ======
     */
    public static void main(String[] args) {
        MyParent myParent = new MyParent();
        System.out.println("======");
        MyParent myParent1 = new MyParent();
    }
}
class MyParent {
    public static String str = "hello world";
    static {
        System.out.println("MyParent has been init");
    }
}
