package LZY.Day20191119_JVM;

import java.util.UUID;

/**
 * 当子接口在初始化时，并不要求父接口也要完成初始化
 *
 * 即下面这段程序并不会报错，因为父接口不会初始化b=2/0，但是通过-XX:+TraceClassLoading 可以发现类完成了加载
 *
 * 注意：加载和初始化不是同一个概念，当类完成加载时，不一定完成类的初始化过程  静态代码块实在类初始化时执行的
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
    public static final String a = UUID.randomUUID().toString();//此时当调用该静态变量的类需要完成对该类的初始化，因为其静态变量不是一个常量，所以
    //对该类是主动使用
}
