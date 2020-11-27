package LZY.Day20191125_DesignPattern.BehaviorType.TemplatePattern;

/**
 * @author jake.lin
 * @date 2020/11/26
 */
public class MikeAthor extends Performance {
    @Override
    public void ready() {
        System.out.println("mike ready performance");
    }

    @Override
    public void say() {
        System.out.println("mike say ing....");
    }

    @Override
    public void over() {
        System.out.println("mike performance over");
    }
}
