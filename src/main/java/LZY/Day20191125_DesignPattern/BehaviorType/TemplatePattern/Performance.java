package LZY.Day20191125_DesignPattern.BehaviorType.TemplatePattern;

/**
 * @author jake.lin
 * @date 2020/11/26
 */
public abstract class Performance {
    public abstract void ready();
    public abstract void say();
    public abstract void over();

    public final void test() {
        ready();
        say();
        over();
    }
}
