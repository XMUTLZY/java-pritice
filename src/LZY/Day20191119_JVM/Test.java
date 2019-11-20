package LZY.Day20191119_JVM;

/**
 * 静态成员变量加上了final修饰符，再编译阶段会放入到Test的常量池中，run类不会被加载
 * 助记符： ldc  bipush sipush iconst_1
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(run.str);
    }
}
class run{
    public static final String str = "helloworld";
    static {
        System.out.println("123");
    }

}
