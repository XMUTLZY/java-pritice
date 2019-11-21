package LZY.Day20191119_JVM;

import java.util.UUID;

/**
 *
 */
public class MyTest4 {
    public static void main(String[] args) {
        System.out.println(MyParent5.a);
    }
}
interface MyParent4 {
    public static final int b = 2/0;
}
interface MyParent5 extends MyParent4{
    public static final String a = UUID.randomUUID().toString();
}
