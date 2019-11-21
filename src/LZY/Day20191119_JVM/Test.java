package LZY.Day20191119_JVM;

import java.util.UUID;

/**
 * 类成员变量如果是常量 加上了final修饰符，再编译阶段会放入到Test的常量池中，run类不会被加载
 * 类成员变量如果是未知的 加上了final修饰符，再编译阶段不会把该类成员变量放入常量池中，会主动使用run类
 * 助记符： ldc  bipush sipush iconst_1
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(run.str);
        System.out.println("=====");
        System.out.println(run.str2);
    }
}
class run{
    public static final String str2 = UUID.randomUUID().toString();
    public static final String str = "helloworld";
    static {
        System.out.println("static block has been init");
    }

}
