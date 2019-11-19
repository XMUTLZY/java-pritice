package Day20191119_JVM;

/**
 * -XX:+TraceClassLoading: 用于追踪类的加载信息
 * -XX:+<option>打开选项
 * -XX:-<option>关闭选项
 * -XX:<option>=value 赋值
 */
public class JVM {
    public static void main(String[] args) {
        System.out.println(Child.str);
    }
}
class Parent{
    public static String str = "parent";
    static {
        System.out.println("class: Parent is init");
    }
}
class Child extends Parent{
//    public static String str = "child";
    static {
        System.out.println("class: Child is init");
    }
}

